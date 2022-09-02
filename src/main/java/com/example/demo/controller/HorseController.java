package com.example.demo.controller;


import com.example.demo.model.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;
import org.json.*;




@Controller
public class HorseController {

    @RequestMapping(value="/horse")
    public ModelAndView Weather (ModelAndView model)  throws IOException {

        //API call
        try {

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Lexington&appid=a3dcf5faec94e922e2963d2d8f950464&units=imperial");





            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                String content = informationString.toString();
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


                model.addObject("Weather",weatherData);
                model.setViewName("horse");


            }
        } catch (Exception e) {
            e.printStackTrace();
        }





        return model;


    }

}
