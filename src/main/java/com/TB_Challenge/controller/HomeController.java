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

    @RequestMapping(value = "/2")
    public ModelAndView test(HttpServletResponse response) throws IOException {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/yo")
    public ModelAndView test2(HttpServletResponse response) throws IOException {


        ModelAndView model = new ModelAndView("yo");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = "";

        if (authentication.getName().equals("anonymousUser")) {
            login = "You are not logged in";
            System.out.println(login);
        } else {
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

        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);

        User user = grabLoggedinUser();
        model.addObject("user", user);
        model.addObject("contact", track);


        return model;

    }


    @RequestMapping(value = {"/", "home"})
    public ModelAndView listContact(ModelAndView model) throws IOException {


        List<Track> listTrack = trackDAO.list();
        List<User> userList = userDAO.list();
        System.out.println(userList);
        model.addObject("listContact", listTrack);

        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);
        User user = grabLoggedinUser();
        model.addObject("user", user);

        model.setViewName("home");

        return model;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView newTrack(ModelAndView model) throws IOException {

        Track newTrack = new Track();

        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);
        model.addObject("contact", newTrack);
        User user = grabLoggedinUser();
        model.addObject("user", user);

        model.setViewName("add");

        return model;

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Track track) {
        System.out.println("save was called");

        if (track.getId() == null) {
            trackDAO.save(track);
        } else {
            trackDAO.update(track);
        }


        return new ModelAndView("redirect:/");

    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user) {
        System.out.println("save was called for user" + user.toString());


        return new ModelAndView("redirect:/");

    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        System.out.println("This is id " + id);
        Track track = trackDAO.get(id);

        ModelAndView model = new ModelAndView("add");

        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);
        User user = grabLoggedinUser();
        model.addObject("user", user);

        model.addObject("contact", track);


        return model;

    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {


        ModelAndView model = new ModelAndView("editUser");

        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);
        User user = grabLoggedinUser();
        model.addObject("user", user);


        return model;

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam Integer id) {

        trackDAO.delete(id);

        return new ModelAndView("redirect:/");

    }

    public String securityLoginInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = "";

        if (authentication.getName().equals("anonymousUser")) {
            login = "You are not logged in";
            System.out.println(login);
        } else {
            login = "Welcome " + StringUtils.capitalize(authentication.getName());
            System.out.println(login);
        }


        return login;
    }

    public User grabLoggedinUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userDAO.getUserInfo(authentication.getName());

        return user;
    }


}



