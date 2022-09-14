package com.TB_Challenge.controller;


import com.TB_Challenge.dao.ChallengeDAO;
import com.TB_Challenge.dao.RaceDAO;
import com.TB_Challenge.model.Challenge;
import com.TB_Challenge.model.Race;
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
public class ChallengeController {

    @Autowired
    private ChallengeDAO challengeDAO;

    @RequestMapping(value = "/challenge")
    public ModelAndView challenge(ModelAndView model) throws IOException {

        List<Challenge> challengeList = challengeDAO.list();

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
        model.addObject("challenge", challengeList);



        return model;
    }

    @RequestMapping(value = "/viewChallenge", method = RequestMethod.GET)
    public ModelAndView viewChallenge(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Challenge c = challengeDAO.getChallenge(id);
        System.out.println("we want to view this challenge" + c.toString());

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
        model.addObject("challenge", c);



        model.setViewName("viewChallenge");

        return model;

    }

    @RequestMapping(value = "/addChallenge", method = RequestMethod.GET)
    public ModelAndView newChallenge(ModelAndView model) throws IOException {

        Challenge c = new Challenge();

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
        model.addObject("challenge", c);


        model.setViewName("addChallenge");

        return model;

    }

    @RequestMapping(value = "/saveChallenge", method = RequestMethod.POST)
    public ModelAndView saveChallenge(@ModelAttribute Challenge challenge) {
        System.out.println("save was called for challenge");
        challenge.toString();


        if(challenge.getId() == null){
            challengeDAO.save(challenge);
        }
        else {
            challengeDAO.update(challenge);

        }




        return new ModelAndView("redirect:/challenge");

    }

    @RequestMapping(value = "/editChallenge", method = RequestMethod.GET)
    public ModelAndView editChallenge(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Challenge c = challengeDAO.getChallenge(id);
        System.out.println("we want to edit this race" + c.toString());

        ModelAndView model = new ModelAndView("addChallenge");


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
        model.addObject("challenge", c);




        return model;

    }

    @RequestMapping(value = "/deleteChallenge", method = RequestMethod.GET)
    public ModelAndView deleteChallenge(@RequestParam Integer id) {

        challengeDAO.delete(id);

        return new ModelAndView("redirect:/challenge");

    }


}
