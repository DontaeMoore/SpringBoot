package com.TB_Challenge.controller;


import com.TB_Challenge.model.Weather;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.*;




@Controller
public class HorseController {

    @RequestMapping(value="/horse")
    public ModelAndView Weather (ModelAndView model)  throws IOException {
        System.out.println("horse called");
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


        //API call
        try {

            System.out.println("in try call");
            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=30b9cc8f53d547e083d151418222809&q=40511&aqi=no");

            System.out.println(url);
            // url for zip, useful for our tracks api.openweathermap.org/data/2.5/weather?zip=40511&appid=a3dcf5faec94e922e2963d2d8f950464&units=imperial



            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(100);
            System.out.println(conn);
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                System.out.println("HttpResponseCode: " + responseCode);
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                System.out.println("HttpResponseCode: " + responseCode);
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                String content = informationString.toString();
                System.out.println(informationString.toString());
                System.out.println("we have the data");
                JSONObject obj = new JSONObject(content);

                System.out.println(obj);


                String temp_f = obj.getJSONObject("current").get("temp_f").toString();
                String desc = obj.getJSONObject("current").getJSONObject("condition").get("text").toString();
                String wind = obj.getJSONObject("current").get("wind_mph").toString();
                String icon = obj.getJSONObject("current").getJSONObject("condition").get("icon").toString();
                String replacedIcon = icon.replaceAll("64", "128");
                System.out.println(temp_f);
                System.out.println(desc);
                System.out.println(wind);
                System.out.println(replacedIcon);



                Weather w = new Weather(temp_f, desc,replacedIcon, wind);
                String[] weatherData = w.getList();



                model.addObject("Weather",weatherData);
                model.setViewName("horse");


            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }









        return model;


    }

}
