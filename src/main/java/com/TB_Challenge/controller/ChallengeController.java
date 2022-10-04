package com.TB_Challenge.controller;


import com.TB_Challenge.dao.ChallengeDAO;
import com.TB_Challenge.dao.RaceDAO;
import com.TB_Challenge.model.Challenge;
import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.Status;
import com.TB_Challenge.model.Track;
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
import java.util.List;

@SessionAttributes("challenge")
@Controller
public class ChallengeController {

    @Autowired
    private ChallengeDAO challengeDAO;
    @Autowired
    private RaceDAO raceDAO;

    @RequestMapping(value = "/challenge")
    public ModelAndView challenge(ModelAndView model) throws IOException {

        List<Status> s = challengeDAO.status();
        List<Challenge> challengeList = challengeDAO.list(s);


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

        List<Track> trackList = raceDAO.getTracks();
        List<Race> RaceList = challengeDAO.listRaces(id, trackList);



        for(Race r : RaceList){
            System.out.println(r.toString() + " _Race");
        }

        if(RaceList.isEmpty()){
            Race r = new Race("N/A", "N/A", "N/A","N/A");
            RaceList.add(r);
        }



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
        model.addObject("r", RaceList);



        model.setViewName("viewChallenge");

        return model;

    }

    @RequestMapping(value = "/addChallenge", method = RequestMethod.GET)
    public ModelAndView newChallenge(ModelAndView model, HttpSession session) throws IOException {

        Challenge c = new Challenge();
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
        model.addObject("challenge", c);


        model.setViewName("addChallenge");

        return model;

    }

    @RequestMapping(value = "/saveChallenge", method = RequestMethod.POST)
    public ModelAndView saveChallenge(@ModelAttribute Challenge challenge) {
        System.out.println("save was called for challenge");
        System.out.println(challenge.toString());
        System.out.println();


        if(challenge.getId() == null){
            challengeDAO.save(challenge);
        }
        else {
            challengeDAO.update(challenge);

        }




        return new ModelAndView("redirect:/challenge");

    }

    @RequestMapping(value = "/updateChallengeCheck", method = RequestMethod.GET)
    public ModelAndView updateCheck(@ModelAttribute Challenge challenge, HttpSession session, @RequestParam boolean check) {
        System.out.println("BOOLEAN Challenge check is " + check);


        if(check == true){
            session.setAttribute("checkValue", "checked");
        }
        else {
            session.setAttribute("checkValue", "");
        }


            Challenge c = (Challenge)session.getAttribute("challenge");
            System.out.println("Challenge session attribute: " + c.toString());


        return new ModelAndView("redirect:/editChallenge?id=" + challenge.getId());

    }


    @RequestMapping(value = "/editChallenge", method = RequestMethod.GET)
    public ModelAndView editChallenge(HttpServletRequest request, HttpSession session) {
        session.setAttribute("checkbox", "");
        Integer id = Integer.parseInt(request.getParameter("id"));
        Challenge challenge = challengeDAO.getChallenge(id);
        System.out.println("we want to edit this Challenge" + challenge.toString());
        List<Status> s = challengeDAO.status();
        List<Integer> sID = new ArrayList<>();
        System.out.println("Each status id needed to be shown in edit challenge");
        for(Status status : s){
            sID.add(status.getId());
            System.out.println(status.getId());
        }

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
        model.addObject("challenge", challenge);
        model.addObject("statusIDs", sID);




        return model;

    }

    @RequestMapping(value = "/deleteChallenge", method = RequestMethod.GET)
    public ModelAndView deleteChallenge(@RequestParam Integer id) {

        challengeDAO.delete(id);

        return new ModelAndView("redirect:/challenge");

    }

    @RequestMapping(value = "/autoSaveCName", method = RequestMethod.GET)
    public ModelAndView autoName(@ModelAttribute Challenge challenge, HttpSession session, @RequestParam String name) {

        //make sql call
        //update challenge, pass it back to the page
        challengeDAO.changeName(challenge.getId(), name);

        return new ModelAndView("redirect:/editChallenge?id=" + challenge.getId());

    }

    @RequestMapping(value = "/autoSaveCDesc", method = RequestMethod.GET)
    public ModelAndView autoDesc(@ModelAttribute Challenge challenge, HttpSession session, @RequestParam String desc) {

        //make sql call
        //update challenge, pass it back to the page
        challengeDAO.changeDesc(challenge.getId(), desc);

        return new ModelAndView("redirect:/editChallenge?id=" + challenge.getId());

    }
    @RequestMapping(value = "/autoSaveCFirst", method = RequestMethod.GET)
    public ModelAndView autoFirst(@ModelAttribute Challenge challenge, HttpSession session, @RequestParam Integer first) {

        //make sql call
        //update challenge, pass it back to the page
        challengeDAO.changeFirst(challenge.getId(), first);

        return new ModelAndView("redirect:/editChallenge?id=" + challenge.getId());

    }
    @RequestMapping(value = "/autoSaveCSecond", method = RequestMethod.GET)
    public ModelAndView autoSecond(@ModelAttribute Challenge challenge, HttpSession session, @RequestParam Integer second) {

        //make sql call
        //update challenge, pass it back to the page
        challengeDAO.changeSecond(challenge.getId(), second);

        return new ModelAndView("redirect:/editChallenge?id=" + challenge.getId());

    }
    @RequestMapping(value = "/autoSaveCThird", method = RequestMethod.GET)
    public ModelAndView autoThird(@ModelAttribute Challenge challenge, HttpSession session, @RequestParam Integer third) {

        //make sql call
        //update challenge, pass it back to the page
        challengeDAO.changeThird(challenge.getId(), third);

        return new ModelAndView("redirect:/editChallenge?id=" + challenge.getId());

    }
    @RequestMapping(value = "/autoSaveCFourth", method = RequestMethod.GET)
    public ModelAndView autoFourth(@ModelAttribute Challenge challenge, HttpSession session, @RequestParam Integer fourth) {

        //make sql call
        //update challenge, pass it back to the page
        challengeDAO.changeFourth(challenge.getId(), fourth);

        return new ModelAndView("redirect:/editChallenge?id=" + challenge.getId());

    }
    @RequestMapping(value = "/autoSaveCStatus", method = RequestMethod.GET)
    public ModelAndView autoStatus(@ModelAttribute Challenge challenge, HttpSession session, @RequestParam String status) {

        //make sql call
        //update challenge, pass it back to the page
        challengeDAO.changeStatus(challenge.getId(), status);

        return new ModelAndView("redirect:/editChallenge?id=" + challenge.getId());

    }
    @RequestMapping(value = "/autoSaveCDate", method = RequestMethod.GET)
    public ModelAndView autoDate(@ModelAttribute Challenge challenge, HttpSession session, @RequestParam String date) {

        //make sql call
        //update challenge, pass it back to the page
        challengeDAO.changeDate(challenge.getId(), date);

        return new ModelAndView("redirect:/editChallenge?id=" + challenge.getId());

    }





}
