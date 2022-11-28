package com.TB_Challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LeafController {

    @GetMapping(value = "/leaf")
    String getHorses(Model model) {
        model.addAttribute("something", "This is coming from the controller");
        return "leafhorse";
    }
}
