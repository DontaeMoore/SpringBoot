package com.TB_Challenge.controller;

import com.TB_Challenge.dao.RaceDAO;
import com.TB_Challenge.dao.TrackDAO;
import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.Track;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes("race")
@Controller
public class RaceController {

    @Autowired
    private RaceDAO raceDAO;

    @Autowired
    private TrackDAO trackDAO;

    private int raceOffset = 0;


    @RequestMapping(value = "/race")
    public ModelAndView race(ModelAndView model, HttpSession session) throws IOException {

        System.out.println("as it should b " + session.getAttribute("sort"));
        List<Race> raceList;
        List<Track> trackList = raceDAO.getTracks();

        if(session.getAttribute("sort") == "name"){
            System.out.println("sorting by =name");
             raceList = raceDAO.listSortByName(trackList, raceOffset);
            if(raceList.isEmpty()){
                raceOffset-=10;
                raceList = raceDAO.listSortByName(trackList, raceOffset);
            }
        }
        else if (session.getAttribute("sort") == "date"){
             raceList = raceDAO.listSortByDate(trackList, raceOffset);
            if(raceList.isEmpty()){
                raceOffset-=10;
                raceList = raceDAO.listSortByDate(trackList, raceOffset);
            }
        }
        else {
             raceList = raceDAO.list(trackList, raceOffset);
             if(raceList.isEmpty()){
                 raceOffset-=10;
                 raceList = raceDAO.list(trackList, raceOffset);
             }
        }



        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = "";

        if(authentication.getName().equals("anonymousUser")) {
            login = "You are not logged in";
            System.out.println(login);
        }
        else {
            login = "Welcome " + StringUtils.capitalize(authentication.getName());
            System.out.println(login);
        }
        model.addObject("WelcomeMessage", login);
        model.addObject("RaceList", raceList);
        session.setAttribute("raceOffset", raceOffset);


        return model;

    }
    @RequestMapping(value = "/raceNameSort")
    public ModelAndView RaceNameSort(ModelAndView model, HttpSession session) throws IOException {
        session.setAttribute("sort", "name");
        return new ModelAndView("redirect:/race");

    }

    @ResponseBody
    @RequestMapping(value = "/raceNameSort2")
    public String RaceNameSort2(ModelAndView model, HttpSession session) throws IOException {
        Gson gson = new Gson();
        List<Race> raceList;
        List<Track> trackList = raceDAO.getTracks();
        raceList = raceDAO.listSortByName(trackList, raceOffset);
        String jsonraceList = gson.toJson(raceList);
        return jsonraceList;


    }
    @RequestMapping(value = "/raceDateSort")
    public ModelAndView RaceDateSort(ModelAndView model, HttpSession session) throws IOException {
        session.setAttribute("sort", "date");
        return new ModelAndView("redirect:/race");

    }
    @RequestMapping(value = "/raceOffset+")
    public ModelAndView increaseRaceOffset(ModelAndView model, HttpSession session) throws IOException {
        System.out.println("Increased race offset");
        raceOffset+=10;
        return new ModelAndView("redirect:/race");

    }
    @RequestMapping(value = "/raceOffset-")
    public ModelAndView decreaseRaceOffset(ModelAndView model, HttpSession session) throws IOException {
        System.out.println("Increased race offset");
        raceOffset-=10;
        if(raceOffset < 0){
            raceOffset = 0;
        }
        return new ModelAndView("redirect:/race");

    }

    @RequestMapping(value = "/viewRace", method = RequestMethod.GET)
    public ModelAndView viewTrack(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Track> trackList = raceDAO.getTracks();
        Race race = raceDAO.getRace(id, trackList);
        System.out.println("we want to view this race" + race.toString());

        ModelAndView model = new ModelAndView("view");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = "";

        if(authentication.getName().equals("anonymousUser")) {
            login = "You are not logged in";
            System.out.println(login);
        }
        else {
            login = "Welcome " + StringUtils.capitalize(authentication.getName());
            System.out.println(login);
        }
        model.addObject("WelcomeMessage", login);
        model.addObject("race", race);




        model.setViewName("viewRace");

        return model;

    }

    @RequestMapping(value = "/addRace", method = RequestMethod.GET)
    public ModelAndView newRace(ModelAndView model, HttpSession session) throws IOException {

        Race newRace = new Race();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = "";

        List<Integer> list2 = trackDAO.getTrackID();

        if(authentication.getName().equals("anonymousUser")) {
            login = "You are not logged in";
            System.out.println(login);
        }
        else {
            login = "Welcome " + StringUtils.capitalize(authentication.getName());
            System.out.println(login);
        }


        model.addObject("WelcomeMessage", login);
        model.addObject("race", newRace);
        model.addObject("l", list2);
        session.setAttribute("checkbox", "disabled");
        session.setAttribute("checkValue", "");


        model.setViewName("addRace");

        return model;

    }

    @ModelAttribute("race")
    @RequestMapping(value = "/editRace", method = RequestMethod.GET)
    public ModelAndView editRace(HttpServletRequest request, HttpSession session) {
        session.setAttribute("checkbox", "");
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Track> trackList = raceDAO.getTracks();
        Race race = raceDAO.getRace(id, trackList);
        System.out.println("we want to edit this race" + race.toString());

        ModelAndView model = new ModelAndView("addRace");
        List<Integer> TrackIDs = trackDAO.getTrackID();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = "";


        if(authentication.getName().equals("anonymousUser")) {
            login = "You are not logged in";
            System.out.println(login);
        }
        else {
            login = "Welcome " + StringUtils.capitalize(authentication.getName());
            System.out.println(login);
        }


        model.addObject("WelcomeMessage", login);
        model.addObject("race", race);
        model.addObject("l", TrackIDs);






        return model;

    }

    @RequestMapping(value = "/saveRace", method = RequestMethod.POST, params = "save")
    public ModelAndView saveRace(@ModelAttribute Race race) {
        System.out.println("save was called for race");
        System.out.println(race.toString());


       if(race.getId() == null){
           raceDAO.save(race);
       }
       else {
            raceDAO.update(race);
            System.out.print("");
       }






        return new ModelAndView("redirect:/race");

    }

    @RequestMapping(value = "/saveRace", method = RequestMethod.POST, params = "submitSession")
    @ModelAttribute("race")
    public ModelAndView saveSession(@ModelAttribute Race race, HttpSession session) {
        System.out.println("save Session" + race.getName());
        session.setAttribute("race2", race);
        session.setAttribute("sessionMessage", "Your form is using a saved session!");

        return new ModelAndView("redirect:/race");

    }

    @RequestMapping(value = "/saveRace", method = RequestMethod.POST, params = "clearSession")
    @ModelAttribute("race")
    public ModelAndView clearSession(@ModelAttribute Race race, HttpSession session) {
        System.out.println("clear Session" + race.getName());
        //session.invalidate();
       // status.setComplete();
        session.removeAttribute("race2");
        session.removeAttribute("sessionMessage");

        return new ModelAndView("redirect:/editRace?id=" + race.getId());

    }



    @RequestMapping(value = "/deleteRace", method = RequestMethod.GET)
    public ModelAndView deleteRace(@RequestParam Integer id) {

        raceDAO.delete(id);

        return new ModelAndView("redirect:/race");

    }

    @RequestMapping(value = "/autoSaveFinish", method = RequestMethod.GET)
    public ModelAndView autoFinish(@ModelAttribute Race race, HttpSession session, @RequestParam double finish) {
        System.out.print("got here");

        //make sql call
        //update race, pass it back to the page
        raceDAO.changefinish(race.getId(), finish);



        return new ModelAndView("redirect:/editRace?id=" + race.getId());

    }

    @RequestMapping(value = "/autoSaveDist", method = RequestMethod.GET)
    public ModelAndView autoDist(@ModelAttribute Race race, HttpSession session, @RequestParam double dist) {


        //make sql call
        //update race, pass it back to the page
        raceDAO.changedist(race.getId(), dist);

        return new ModelAndView("redirect:/editRace?id=" + race.getId());

    }

    @RequestMapping(value = "/autoSaveDead", method = RequestMethod.GET)
    public ModelAndView autoDead(@ModelAttribute Race race, HttpSession session, @RequestParam String dead) {


        //make sql call
        //update race, pass it back to the page
        raceDAO.changedead(race.getId(), dead);

        return new ModelAndView("redirect:/editRace?id=" + race.getId());

    }

    @RequestMapping(value = "/autoSavetrackID", method = RequestMethod.GET)
    public ModelAndView autotrackID(@ModelAttribute Race race, HttpSession session, @RequestParam Integer trackID) {


        //make sql call
        //update race, pass it back to the page
        raceDAO.changetrackID(race.getId(), trackID);

        return new ModelAndView("redirect:/editRace?id=" + race.getId());

    }
    @RequestMapping(value = "/autoSaveDate", method = RequestMethod.GET)
    public ModelAndView autoDate(@ModelAttribute Race race, HttpSession session, @RequestParam String date) {


        //make sql call
        //update race, pass it back to the page
        raceDAO.changeDate(race.getId(), date);

        return new ModelAndView("redirect:/editRace?id=" + race.getId());
    }

    @RequestMapping(value = "/autoSaveName", method = RequestMethod.GET)
    public ModelAndView autoName(@ModelAttribute Race race, HttpSession session, @RequestParam String name) {


        //make sql call
        //update race, pass it back to the page
        raceDAO.changeName(race.getId(), name);

        return new ModelAndView("redirect:/editRace?id=" + race.getId());
    }




    @RequestMapping(value = "/updateCheck", method = RequestMethod.GET)
    public ModelAndView updateCheck(@ModelAttribute Race race, HttpSession session, @RequestParam boolean check) {
        System.out.println("BOOLEAN check is " + check + " " + race.getFinish_time());



        if(check == true){
            session.setAttribute("checkValue", "checked");
        }
        else {
            session.setAttribute("checkValue", "");
        }

        System.out.println(race.getDistance());
        System.out.println(race.getFinish_time());




        return new ModelAndView("redirect:/editRace?id=" + race.getId());

    }




}
