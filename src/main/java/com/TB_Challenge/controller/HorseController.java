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

import javax.net.ssl.HttpsURLConnection;


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
            URL url2 = new URL("http://time.jsontest.com");
            System.out.println(url2);
           // url for zip, useful for our tracks api.openweathermap.org/data/2.5/weather?zip=40511&appid=a3dcf5faec94e922e2963d2d8f950464&units=imperial



            HttpURLConnection conn = (HttpURLConnection) url2.openConnection();
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
                Scanner scanner = new Scanner(url2.openStream());

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


                String temp = obj.getJSONObject("main").get("temp").toString();
                System.out.println(temp);

                JSONArray desc = obj.getJSONArray("weather");
                System.out.println(desc.getJSONObject(0).getString("icon"));
                System.out.println(desc.getJSONObject(0).getString("description"));

                String icon = desc.getJSONObject(0).getString("icon");
                String description = desc.getJSONObject(0).getString("description");


                String wind = obj.getJSONObject("wind").get("speed").toString();
                System.out.println(wind);

                Weather w = new Weather(temp, description, icon, wind);
                String[] weatherData = w.getList();
                for(int i = 0; i < weatherData.length; i++){
                    System.out.println(weatherData[i]);
                }
                System.out.println("final ");


                model.addObject("Weather",weatherData);
                model.setViewName("horse");


            }
        } catch (Exception e) {
            System.out.println("Didnt work ");
            e.printStackTrace(System.out);
        }

        //API call
        try {

            System.out.println("in try call");
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Lexington&appid=a3dcf5faec94e922e2963d2d8f950464&units=imperial");

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


                String temp = obj.getJSONObject("main").get("temp").toString();
                System.out.println(temp);

                JSONArray desc = obj.getJSONArray("weather");
                System.out.println(desc.getJSONObject(0).getString("icon"));
                System.out.println(desc.getJSONObject(0).getString("description"));

                String icon = desc.getJSONObject(0).getString("icon");
                String description = desc.getJSONObject(0).getString("description");


                String wind = obj.getJSONObject("wind").get("speed").toString();
                System.out.println(wind);

                Weather w = new Weather(temp, description, icon, wind);
                String[] weatherData = w.getList();
                for(int i = 0; i < weatherData.length; i++){
                    System.out.println(weatherData[i]);
                }
                System.out.println("final ");


                model.addObject("Weather",weatherData);
                model.setViewName("horse");


            }
        } catch (Exception e) {
            System.out.println("Didnt work ");
            e.printStackTrace(System.out);
        }









        return model;


    }

}
