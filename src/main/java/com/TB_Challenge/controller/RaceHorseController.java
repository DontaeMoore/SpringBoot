package com.TB_Challenge.controller;


import com.TB_Challenge.dao.RaceDAO;
import com.TB_Challenge.dao.RaceHorseDAO;
import com.TB_Challenge.model.Challenge;
import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.RaceHorse;
import com.TB_Challenge.model.Track;
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
import java.util.List;

@Controller
@SessionAttributes("race")
public class RaceHorseController {

    @ModelAttribute("racehorse")
    public RaceHorse racehorse() {
        return new RaceHorse();
    }

    @Autowired
    private RaceHorseDAO raceHorseDAO;



    @RequestMapping(value = "/racehorse")
    public ModelAndView race(ModelAndView model) throws IOException {



        List<RaceHorse> raceHorseList = raceHorseDAO.list();

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
        model.addObject("racehorse", raceHorseList);



        return model;
    }

    @RequestMapping(value = "/viewRaceHorse", method = RequestMethod.GET)
    public ModelAndView viewRaceHorse(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        RaceHorse race = raceHorseDAO.getRaceHorse(id);
        System.out.println("we want to view this raceHorse" + race.toString());

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
        model.addObject("racehorse", race);



        model.setViewName("viewRaceHorse");

        return model;

    }

    @RequestMapping(value = "/editRaceHorse", method = RequestMethod.GET)
    public ModelAndView editRaceHorse(HttpServletRequest request, HttpSession session) {
        session.setAttribute("checkbox", "");
        Integer id = Integer.parseInt(request.getParameter("id"));
        RaceHorse race = raceHorseDAO.getRaceHorse(id);
        System.out.println("we want to edit this race" + race.toString());

        ModelAndView model = new ModelAndView("addRaceHorse");


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





        return model;

    }
    @RequestMapping(value = "/addRaceHorse", method = RequestMethod.GET)
    public ModelAndView newRaceHorse(ModelAndView model, HttpSession session) throws IOException {
        session.setAttribute("checkbox", "disabled");

        RaceHorse newRaceHorse = new RaceHorse();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = "";

        System.out.println(newRaceHorse.toString());

        if(authentication.getName().equals("anonymousUser")) {
            login = "You are not logged in";
            System.out.println(login);
        }
        else {
            login = "Welcome " + StringUtils.capitalize(authentication.getName());
            System.out.println(login);
        }


        model.addObject("WelcomeMessage", login);
        model.addObject("race", newRaceHorse);


        model.setViewName("addRaceHorse");

        return model;

    }

    @RequestMapping(value = "/saveRaceHorse", method = RequestMethod.POST)
    public ModelAndView saveRace(@ModelAttribute RaceHorse race) {
        System.out.println("save was called for racehorse");
        System.out.println(race.toString());
        if(race.getFoalyear().length() != 4){
            race.setFoalyear(null);
        }


        if(race.getId() == null){
            System.out.println("new horse");
            raceHorseDAO.save(race);
        }
        else {
            System.out.println("update horse");
          raceHorseDAO.update(race);
        }




        return new ModelAndView("redirect:/racehorse");

    }

    @RequestMapping(value = "/deleteRaceHorse", method = RequestMethod.GET)
    public ModelAndView deleteRace(@RequestParam Integer id) {

        raceHorseDAO.delete(id);

        return new ModelAndView("redirect:/racehorse");

    }

    @RequestMapping(value = "/updateRHCheck", method = RequestMethod.GET)
    public ModelAndView updateCheck(HttpSession session, @RequestParam boolean check) {

        RaceHorse race = (RaceHorse) session.getAttribute("race");
        System.out.println("BOOLEAN Race Horse check is " + check + " " + race.getName());


        if(check == true){
            session.setAttribute("checkValue", "checked");
        }
        else {
            session.setAttribute("checkValue", "");
        }





        return new ModelAndView("redirect:/editRaceHorse?id=" + race.getId());

    }
    @RequestMapping(value = "/autoSaveRHName", method = RequestMethod.GET)
    public ModelAndView autoName(@ModelAttribute RaceHorse racehorse, HttpSession session, @RequestParam String name) {
        RaceHorse race = (RaceHorse) session.getAttribute("race");
        //make sql call
        //update challenge, pass it back to the page
        raceHorseDAO.changeName(race.getId(), name);

        return new ModelAndView("redirect:/editRaceHorse?id=" + race.getId());

    }
    @RequestMapping(value = "/autoSaveRHGender", method = RequestMethod.GET)
    public ModelAndView autoGender(@ModelAttribute RaceHorse racehorse, HttpSession session, @RequestParam String gender) {
        RaceHorse race = (RaceHorse) session.getAttribute("race");
        //make sql call
        //update challenge, pass it back to the page
        raceHorseDAO.changeGender(race.getId(), gender);

        return new ModelAndView("redirect:/editRaceHorse?id=" + race.getId());

    }
    @RequestMapping(value = "/autoSaveRHFoal", method = RequestMethod.GET)
    public ModelAndView autoFoal(@ModelAttribute RaceHorse racehorse, HttpSession session, @RequestParam String foal) {
        RaceHorse race = (RaceHorse) session.getAttribute("race");
        //make sql call
        //update challenge, pass it back to the page
        raceHorseDAO.changeFoal(race.getId(), foal);

        return new ModelAndView("redirect:/editRaceHorse?id=" + race.getId());

    }
    @RequestMapping(value = "/autoSaveRHLink", method = RequestMethod.GET)
    public ModelAndView autoLink(@ModelAttribute RaceHorse racehorse, HttpSession session, @RequestParam String link) {
        RaceHorse race = (RaceHorse) session.getAttribute("race");
        //make sql call
        //update challenge, pass it back to the page
        raceHorseDAO.changeLink(race.getId(), link);

        return new ModelAndView("redirect:/editRaceHorse?id=" + race.getId());

    }
    @RequestMapping(value = "/autoSaveRHOwner", method = RequestMethod.GET)
    public ModelAndView autoOwner(@ModelAttribute RaceHorse racehorse, HttpSession session, @RequestParam String owner) {
        RaceHorse race = (RaceHorse) session.getAttribute("race");
        //make sql call
        //update challenge, pass it back to the page
        raceHorseDAO.changeOwner(race.getId(), owner);

        return new ModelAndView("redirect:/editRaceHorse?id=" + race.getId());

    }
    @RequestMapping(value = "/autoSaveRHTrainer", method = RequestMethod.GET)
    public ModelAndView autoTrainer(@ModelAttribute RaceHorse racehorse, HttpSession session, @RequestParam String trainer) {
        RaceHorse race = (RaceHorse) session.getAttribute("race");
        //make sql call
        //update challenge, pass it back to the page
        raceHorseDAO.changeTrainer(race.getId(), trainer);

        return new ModelAndView("redirect:/editRaceHorse?id=" + race.getId());

    }
    @RequestMapping(value = "/autoSaveRHComments", method = RequestMethod.GET)
    public ModelAndView autoComments(@ModelAttribute RaceHorse racehorse, HttpSession session, @RequestParam String comments) {
        RaceHorse race = (RaceHorse) session.getAttribute("race");
        //make sql call
        //update challenge, pass it back to the page
        raceHorseDAO.changeComments(race.getId(), comments);

        return new ModelAndView("redirect:/editRaceHorse?id=" + race.getId());

    }


}
