package com.TB_Challenge.controller;

import com.TB_Challenge.model.User;
import com.TB_Challenge.dao.UserDAO;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class AdminController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/editUserAdmin", method = RequestMethod.GET)
    public ModelAndView editChallenge(HttpServletRequest request, HttpSession session) {
        session.setAttribute("checkbox", "");
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUser(id);
        System.out.println("we want to edit this User " + user.toString());

        ModelAndView model = new ModelAndView("addUser");


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
        model.addObject("user", user);


        return model;

    }

    @RequestMapping(value = "/viewUserAdmin", method = RequestMethod.GET)
    public ModelAndView viewUserAdmin(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUser(id);
        System.out.println("we want to view this User " + user.toString());


        ModelAndView model = new ModelAndView("view");

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
        model.addObject("user", user);


        model.setViewName("viewUser");

        return model;
    }

    @RequestMapping(value = "/deleteUserAdmin", method = RequestMethod.GET)
    public ModelAndView deleteChallenge(@RequestParam Integer id) {

        userDAO.delete(id);

        return new ModelAndView("redirect:/admin");

    }

    @RequestMapping(value = "/addUserAdmin", method = RequestMethod.GET)
    public ModelAndView newUserAdmin(ModelAndView model, HttpSession session) throws IOException {

        User u = new User();
        session.setAttribute("checkbox", "disabled");
        session.setAttribute("checkValue", "");
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


        model.setViewName("addUser");

        return model;

    }
    @RequestMapping(value = "/saveUserAdmin", method = RequestMethod.POST)
    public ModelAndView saveChallenge(@ModelAttribute User user) {
        System.out.println("save was called for ADMIN user");
        System.out.println(user.toString());
        System.out.println();


       if(user.getId() == null){
           System.out.println("new ");
            userDAO.saveAdmin(user);
        }
        else {
           userDAO.updateAdmin(user);

        }




        return new ModelAndView("redirect:/admin");

    }


}
