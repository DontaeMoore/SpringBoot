package com.TB_Challenge.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TB_Challenge.config.EmailSenderService;
import com.TB_Challenge.dao.ChallengeDAO;
import com.TB_Challenge.dao.RoleDAO;
import com.TB_Challenge.dao.TrackDAO;
import com.TB_Challenge.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import com.TB_Challenge.dao.UserDAO;

@Controller
@SessionAttributes("track")
public class HomeController {

    @Autowired
    private TrackDAO trackDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ChallengeDAO challengeDAO;

    @Autowired
    private EmailSenderService senderService;

    @Autowired
    private RoleDAO roleDAO;

    private int homeOffset = 0;
    private int adminOffset = 0;

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

    @RequestMapping("/check")
    @ResponseBody
    public String check(HttpServletRequest request,
                        HttpServletResponse response, ModelAndView model) {
        return "This is a JQUERY AJAX COMMAND";
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


    @RequestMapping(value = {"/", "/home"})
    public ModelAndView track(ModelAndView model, HttpSession session) throws IOException {

        List<Track> listTrack = trackDAO.list(homeOffset);
        if(listTrack.isEmpty()){
            homeOffset-=10;
            listTrack = trackDAO.list(homeOffset);
        }
        List<User> userList = userDAO.list();
        System.out.println(userList);
        model.addObject("listContact", listTrack);
        session.setAttribute("forgotConfirm", "Enter your email to reset your password!");



        User user = grabLoggedinUser();
        model.addObject("user", user);
        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);



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
    public ModelAndView editUser(HttpServletRequest request, HttpSession session) {


        ModelAndView model = new ModelAndView("editUser");

        String login = securityLoginInfo();

        User user = grabLoggedinUser();
        model.addObject("WelcomeMessage", login);
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
        List<Role> roleList = roleDAO.roleList();
        List<Status> s = challengeDAO.status();
        List<User> userList = userDAO.Adminlist(s, roleList, adminOffset);
        if(userList.isEmpty()){
            System.out.println(adminOffset + " admin offset");
            adminOffset-=10;
            userList = userDAO.Adminlist(s, roleList, adminOffset);
        }

        for(User c : userList){
            System.out.println("user " + c.getUsername());
        }
        model.addObject("userList", userList);


        return model;

    }
    @RequestMapping(value = "/aOffset+")
    public ModelAndView increaseAdminOffset(ModelAndView model, HttpSession session) throws IOException {

        adminOffset+=10;
        return new ModelAndView("redirect:/admin");

    }
    @RequestMapping(value = "/aOffset-")
    public ModelAndView decreaseAdminOffset(ModelAndView model, HttpSession session) throws IOException {

        adminOffset-=10;
        if(adminOffset < 0){
            adminOffset = 0;
        }
        return new ModelAndView("redirect:/admin");

    }



    @RequestMapping(value = "/saveForget", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute ForgotPassword fp, HttpSession session) {
        System.out.println("save was called for email" + fp.getEmail());

        User user = userDAO.getUserInfo(fp.getEmail());
        if(user == null){
            session.setAttribute("forgotConfirm", "The email " + fp.getEmail() + " does not exist in our database!");
        }
        else {

            session.setAttribute("forgotConfirm", "The email " + fp.getEmail() + " was found, and the password reset " +
                    "link was send!");
            senderService.sendEmail(fp.getEmail(), "Derby App Password Reset", "https://thompsonprojects.com/passwordReset?id=" +
                    user.getId());
        }






        return new ModelAndView("redirect:/forgot");


    }
    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public ModelAndView forgotView(HttpServletRequest request) {

       ForgotPassword fp = new ForgotPassword();
        System.out.println(fp.toString());
        ModelAndView model = new ModelAndView("forgot");
        String login = securityLoginInfo();
        model.addObject("WelcomeMessage", login);
        model.addObject("forgot", fp);

        return model;

    }
    @RequestMapping(value = "/passwordReset", method = RequestMethod.GET)
    public ModelAndView passwordReset(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User u = userDAO.getUser(id);
        u.setPassword("");
        System.out.println("we want to update this users forgotten password" + u.toString());

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
        model.addObject("user", u);

        model.setViewName("resetPassword");

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

    @RequestMapping(value = "/homeOffset+")
    public ModelAndView increaseRaceOffset(ModelAndView model, HttpSession session) throws IOException {
        System.out.println("Increased race offset");
        homeOffset+=10;
        return new ModelAndView("redirect:/home");

    }
    @RequestMapping(value = "/homeOffset-")
    public ModelAndView decreaseRaceOffset(ModelAndView model, HttpSession session) throws IOException {
        System.out.println("Increased race offset");
        homeOffset-=10;
        if(homeOffset < 0){
            homeOffset = 0;
        }
        return new ModelAndView("redirect:/home");

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



