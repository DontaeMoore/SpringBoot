package com.TB_Challenge.controller;


import com.TB_Challenge.dao.RaceDAO;
import com.TB_Challenge.dao.RaceHorseDAO;
import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.RaceHorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class RaceHorseController {


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
    public ModelAndView editRaceHorse(HttpServletRequest request) {
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
    public ModelAndView newRaceHorse(ModelAndView model) throws IOException {

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
}
