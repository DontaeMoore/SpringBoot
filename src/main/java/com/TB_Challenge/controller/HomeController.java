package com.TB_Challenge.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TB_Challenge.dao.TrackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.TB_Challenge.dao.UserDAO;
import com.TB_Challenge.config.model.Track;
import com.TB_Challenge.config.model.User;

@SessionAttributes("track")
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
        String login = securityLoginInfo();

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
        model.setViewName("viewTracks");

        return model;

    }


    @RequestMapping(value = {"/", "home"})
    public ModelAndView track(ModelAndView model, HttpSession session) throws IOException {

        List<Track> listTrack = trackDAO.list();
        List<User> userList = userDAO.list();
        System.out.println(userList);
        model.addObject("listContact", listTrack);


        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);
        User user = grabLoggedinUser();
        model.addObject("user", user);
        session.setAttribute("rolename", user.getRoleName(user.getRole()));


        model.setViewName("home");

        return model;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView newTrack(ModelAndView model, HttpSession session) throws IOException {

        Track newTrack = new Track();
        session.setAttribute("checkbox", "disabled");
        session.setAttribute("checkValue", "");

        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);
        model.addObject("track", newTrack);
        User user = grabLoggedinUser();
        model.addObject("user", user);

        model.setViewName("addTracks");

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

        userDAO.update(user);


        return new ModelAndView("redirect:/");

    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request, HttpSession session) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        System.out.println("This is id ");
        Track track = trackDAO.get(id);

        System.out.println(track.toString());
        ModelAndView model = new ModelAndView("addTracks");

        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);
        session.setAttribute("checkbox", "");
        User user = grabLoggedinUser();
        model.addObject("user", user);

        model.addObject("track", track);


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
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminView(HttpServletRequest request) {


        ModelAndView model = new ModelAndView("admin");
        User user = grabLoggedinUser();
        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);

        model.addObject("user", user);
        List<User> userList = userDAO.list();
        for(User c : userList){
            System.out.println("user " + c.getUsername());
        }
        model.addObject("userList", userList);


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

    @RequestMapping(value = "/updateTrackCheck", method = RequestMethod.GET)
    public ModelAndView updateCheck(@ModelAttribute Track track, HttpSession session, @RequestParam boolean check) {
        System.out.println("BOOLEAN Track check is " + check + " " + track.getName());


        if(check == true){
            session.setAttribute("checkValue", "checked");
        }
        else {
            session.setAttribute("checkValue", "");
        }


        return new ModelAndView("redirect:/edit?id=" + track.getId());

    }
    @RequestMapping(value = "/autoSaveTName", method = RequestMethod.GET)
    public ModelAndView autoName(@ModelAttribute Track track, HttpSession session, @RequestParam String name) {

        //make sql call
        //update challenge, pass it back to the page
        trackDAO.changeName(track.getId(), name);

        return new ModelAndView("redirect:/edit?id=" + track.getId());

    }
    @RequestMapping(value = "/autoSaveTCity", method = RequestMethod.GET)
    public ModelAndView autoCity(@ModelAttribute Track track, HttpSession session, @RequestParam String city) {

        //make sql call
        //update challenge, pass it back to the page
        trackDAO.changeCity(track.getId(), city);

        return new ModelAndView("redirect:/edit?id=" + track.getId());

    }
    @RequestMapping(value = "/autoSaveTState", method = RequestMethod.GET)
    public ModelAndView autoState(@ModelAttribute Track track, HttpSession session, @RequestParam String state) {

        //make sql call
        //update challenge, pass it back to the page
        trackDAO.changeState(track.getId(), state);

        return new ModelAndView("redirect:/edit?id=" + track.getId());

    }

    @RequestMapping(value = "/autoSaveTZip", method = RequestMethod.GET)
    public ModelAndView autoZip(@ModelAttribute Track track, HttpSession session, @RequestParam String zip) {

        //make sql call
        //update challenge, pass it back to the page
        trackDAO.changeZip(track.getId(), zip);

        return new ModelAndView("redirect:/edit?id=" + track.getId());

    }
    @RequestMapping(value = "/autoSaveTOwner", method = RequestMethod.GET)
    public ModelAndView autoOwner(@ModelAttribute Track track, HttpSession session, @RequestParam String owner) {

        //make sql call
        //update challenge, pass it back to the page
        trackDAO.changeOwner(track.getId(), owner);

        return new ModelAndView("redirect:/edit?id=" + track.getId());

    }


}



