package com.TB_Challenge.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TB_Challenge.dao.TrackDAO;
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

import com.TB_Challenge.dao.UserDAO;
import com.TB_Challenge.model.Track;
import com.TB_Challenge.model.User;


@Controller
public class HomeController {

    @Autowired
   private TrackDAO trackDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value="/2")
    public ModelAndView test(HttpServletResponse response) throws IOException{
        return new ModelAndView("home");
    }

    @RequestMapping(value="/yo")
    public ModelAndView test2(HttpServletResponse response) throws IOException{


        ModelAndView model = new ModelAndView("yo");

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


        return model;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView viewTrack(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Track track = trackDAO.get(id);

        ModelAndView model = new ModelAndView("view");

        model.addObject("contact", track);


        return model;

    }



    @RequestMapping(value = {"/", "home"})
    public ModelAndView listContact(ModelAndView model) throws IOException {

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





        List<Track> listTrack = trackDAO.list();
        List<User>  userList = userDAO.list();
        System.out.println(userList);
        model.addObject("listContact", listTrack);
        model.addObject("WelcomeMessage", login);

        model.setViewName("home");

        return model;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView newTrack(ModelAndView model) throws IOException {

        Track newTrack = new Track();


        model.addObject("contact", newTrack);

        model.setViewName("add");

        return model;

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Track track) {

        if(track.getId() == null) {
            trackDAO.save(track);
        }
        else {
            trackDAO.update(track);
        }


        return new ModelAndView("redirect:/");

    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Track track = trackDAO.get(id);

        ModelAndView model = new ModelAndView("add");

        model.addObject("contact", track);


        return model;

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam Integer id) {

        trackDAO.delete(id);

        return new ModelAndView("redirect:/");

    }


}


