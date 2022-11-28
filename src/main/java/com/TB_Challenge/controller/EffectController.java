package com.TB_Challenge.controller;

import com.TB_Challenge.model.Weather;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@RestController
public class EffectController {

    @RequestMapping(value="/effect")
    public ModelAndView effect (ModelAndView model)  throws IOException {


        return model;


    }

    public String hello(String name){
        return String.format("Hello, %s", name);
    }


    @GetMapping("/hello")
    public String hello2(@RequestParam (name="name", defaultValue="World") String name){
        return String.format("Hello, %s", name);
    }

    @RequestMapping("/check")
    public String check(HttpServletRequest request,
                        HttpServletResponse response, ModelAndView model) {
        return "This is a JQUERY AJAX COMMAND";
    }



}
