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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
