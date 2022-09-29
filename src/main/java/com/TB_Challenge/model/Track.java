package com.TB_Challenge.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Track {
//tracks

	private Integer id;
	private String name;
	private String city;
	private String state;
	private String zip;
	private String ownership;

	private String temp;

	private String icon;

	public Track(Integer id, String name, String city, String state, String zip, String ownership) {
		
		this(name, city, state, zip,ownership);
		this.id = id;
		
	}
	
	public Track(String name, String city, String state, String zip, String ownership) {

		this.name = name;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ownership = ownership;
	}
	
public Track() {
		
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", ownership=" + ownership + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void findTemp() {

		//API call
		try {

			//URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Lexington&appid=a3dcf5faec94e922e2963d2d8f950464&units=imperial");

			String urlString = "http://api.weatherapi.com/v1/current.json?key=30b9cc8f53d547e083d151418222809&q=" + getZip() + "&aqi=no";
			URL url = new URL(urlString);



			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(100);
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


				String temp_f = obj.getJSONObject("current").get("temp_f").toString();
				setTemp(temp_f);
				String icon = obj.getJSONObject("current").getJSONObject("condition").get("icon").toString();
				setIcon(icon);




				Weather w = new Weather(temp_f, "test", "test", "test");





				String[] weatherData = w.getList();



			}
		} catch (Exception e) {
			setTemp("N/A");
			setIcon("redX");
		}




	}

}
