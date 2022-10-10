package com.TB_Challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class DerbyErrorController implements ErrorController  {

        private static final Logger LOGGER = LoggerFactory.getLogger(DerbyErrorController.class);

    public String getErrorPath(){
        return "/error";
    }
    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request, ModelAndView model) throws IOException {


        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()){
                model.setViewName("error/404");
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                model.setViewName("error/500");
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value()){
                model.setViewName("error/403");
            }
        }

        return model;
    }

}
