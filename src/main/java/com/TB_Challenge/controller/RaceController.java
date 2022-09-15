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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class RaceController {

    @Autowired
    private RaceDAO raceDAO;

    @Autowired
    private TrackDAO trackDAO;

    @RequestMapping(value = "/race")
    public ModelAndView race(ModelAndView model) throws IOException {

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


        model.setViewName("addRace");

        return model;

    }

    @RequestMapping(value = "/editRace", method = RequestMethod.GET)
    public ModelAndView editRace(HttpServletRequest request) {
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





        return model;

    }

    @RequestMapping(value = "/saveRace", method = RequestMethod.POST)
    public ModelAndView saveRace(@ModelAttribute Race race) {
        System.out.println("save was called for race");
        System.out.println(race.toString());


       if(race.getId() == null){
           raceDAO.save(race);
       }
       else {
            raceDAO.update(race);
       }




        return new ModelAndView("redirect:/race");

    }

    @RequestMapping(value = "/deleteRace", method = RequestMethod.GET)
    public ModelAndView deleteRace(@RequestParam Integer id) {

        raceDAO.delete(id);

        return new ModelAndView("redirect:/race");

    }


}
