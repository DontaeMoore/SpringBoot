package com.TB_Challenge.controller;

import com.TB_Challenge.dao.RaceDAO;
import com.TB_Challenge.dao.TrackDAO;
import com.TB_Challenge.dao.UserDAO;
import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.Track;
import com.TB_Challenge.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SessionAttributes("race")
@Controller
public class RaceController {

    @Autowired
    private RaceDAO raceDAO;

    @Autowired
    private TrackDAO trackDAO;


    @RequestMapping(value = "/race")
    public ModelAndView race(ModelAndView model, HttpSession session) throws IOException {

        List<Race> raceList = raceDAO.list();


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
        session.setAttribute("test", "is this working");


        return model;
    }

    @RequestMapping(value = "/viewRace", method = RequestMethod.GET)
    public ModelAndView viewTrack(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Race race = raceDAO.getRace(id);
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
    public ModelAndView newRace(ModelAndView model) throws IOException {

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


        model.setViewName("addRace");

        return model;

    }

    @ModelAttribute("race")
    @RequestMapping(value = "/editRace", method = RequestMethod.GET)
    public ModelAndView editRace(HttpServletRequest request, HttpSession session) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Race race = raceDAO.getRace(id);
        System.out.println("we want to edit this race" + race.toString());

        ModelAndView model = new ModelAndView("addRace");
        List<Integer> list2 = trackDAO.getTrackID();

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
        model.addObject("l", list2);
        session.setAttribute("raceS", "raceS");





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
    public ModelAndView clearSession(@ModelAttribute Race race, HttpSession session, SessionStatus status, WebRequest request) {
        System.out.println("clear Session" + race.getName());
        status.setComplete();
        request.removeAttribute("race2", WebRequest.SCOPE_SESSION);
        request.removeAttribute("sessionMessage", WebRequest.SCOPE_SESSION);

        return new ModelAndView("redirect:/editRace?id=" + race.getId());

    }


    @RequestMapping(value = "/deleteRace", method = RequestMethod.GET)
    public ModelAndView deleteRace(@RequestParam Integer id) {

        raceDAO.delete(id);

        return new ModelAndView("redirect:/race");

    }

    @RequestMapping(value = "/autoSaveFinish", method = RequestMethod.GET)
    public ModelAndView test(@ModelAttribute Race race, HttpSession session, @RequestParam double finish) {

        //take new value for finish line, update database with new value
        //return to page

        System.out.println("HELLO" + race.getId());
        System.out.println("save Session" + race.getName());

        //make sql call
        //update race, pass it back to the page
        raceDAO.changefinish(race.getId(), finish);
        session.setAttribute("race2", race);


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


        return new ModelAndView("redirect:/editRace?id=" + race.getId());

    }




}
