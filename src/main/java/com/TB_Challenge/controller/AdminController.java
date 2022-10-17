package com.TB_Challenge.controller;

import com.TB_Challenge.dao.ChallengeDAO;
import com.TB_Challenge.dao.RoleDAO;
import com.TB_Challenge.model.*;
import com.TB_Challenge.dao.UserDAO;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@SessionAttributes("user")
@Controller
public class AdminController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ChallengeDAO challengeDAO;

    @Autowired
    private RoleDAO roleDAO;

    @RequestMapping(value = "/editUserAdmin", method = RequestMethod.GET)
    public ModelAndView editChallenge(HttpServletRequest request, HttpSession session) {
        session.setAttribute("checkbox", "");
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUser(id);
        byte[] decodedPassBytes = Base64.getDecoder().decode(user.getPassword());
        String decodedPass = new String(decodedPassBytes);
        user.setPassword(decodedPass);



        System.out.println("we want to edit this User " + user.toString());

        List<Role> roleList = roleDAO.roleList();
        List<String> roleNameList = new ArrayList<>();
        for(Role r : roleList){
            roleNameList.add(r.getName());
        }

        List<Status> s = challengeDAO.status();
        List<String> statusNameList = new ArrayList<>();
        for(Status stat : s){
            statusNameList.add(stat.getName());
        }

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
        model.addObject("rolelist", roleNameList);
        model.addObject("statuslist", statusNameList);


        return model;

    }

    @RequestMapping(value = "/viewUserAdmin", method = RequestMethod.GET)
    public ModelAndView viewUserAdmin(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUser(id);



        byte[] decodedPassBytes = Base64.getDecoder().decode(user.getPassword());
        String decodedPass = new String(decodedPassBytes);
        user.setPassword(decodedPass);


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
        System.out.println("yo");
        List<Role> roleList = roleDAO.roleList();
        List<Status> statusList = challengeDAO.status();
        for(Role r : roleList){
            if(r.getName().equals(user.getRoleName())){
                user.setRole(r.getId());
            }
        }
        for(Status s : statusList){
            if(s.getName().equals(user.getStatusName())){
                user.setStatus(s.getId().toString());
            }
        }
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

    @RequestMapping(value = "/updateAdminCheck", method = RequestMethod.GET)
    public ModelAndView updateCheck(@ModelAttribute User user, HttpSession session, @RequestParam boolean check) {
        System.out.println("BOOLEAN User check is " + check + " " + user.getUsername());


        if(check == true){
            session.setAttribute("checkValue", "checked");
        }
        else {
            session.setAttribute("checkValue", "");
        }


        return new ModelAndView("redirect:/editUserAdmin?id=" + user.getId());

    }

    @RequestMapping(value = "/autoSaveUsername", method = RequestMethod.GET)
    public ModelAndView autouser(@ModelAttribute User user, HttpSession session, @RequestParam String username) {
        System.out.print("got here");

        //make sql call
        //update user, pass it back to the page
        userDAO.changeUserName(user.getId(), username);



        return new ModelAndView("redirect:/editUserAdmin?id=" + user.getId());

    }
    @RequestMapping(value = "/autoSavePassword", method = RequestMethod.GET)
    public ModelAndView autopassword(@ModelAttribute User user, HttpSession session, @RequestParam String password) {
        System.out.print("got here");

        //make sql call
        //update user, pass it back to the page
        userDAO.changePassword(user.getId(), password);



        return new ModelAndView("redirect:/editUserAdmin?id=" + user.getId());

    }
    @RequestMapping(value = "/autoSaveRole_ID", method = RequestMethod.GET)
    public ModelAndView autorole(@ModelAttribute User user, HttpSession session, @RequestParam String role) {
        System.out.print("got here");

        //make sql call
        //update user, pass it back to the page
        userDAO.changeRole(user.getId(), role);



        return new ModelAndView("redirect:/editUserAdmin?id=" + user.getId());

    }
    @RequestMapping(value = "/autoSaveStatus_ID", method = RequestMethod.GET)
    public ModelAndView autostatus(@ModelAttribute User user, HttpSession session, @RequestParam String status) {
        System.out.print("got here");

        //make sql call
        //update user, pass it back to the page
        userDAO.changeStatus(user.getId(), status);



        return new ModelAndView("redirect:/editUserAdmin?id=" + user.getId());

    }



}
