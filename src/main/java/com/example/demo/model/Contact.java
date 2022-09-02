package com.example.demo.model;

public class Contact {
//tracks

	private Integer id;
	private String name;
	private String city;
	private String state;
	private String zip;
	private String ownership;

	public Contact(Integer id, String name, String city, String state, String zip, String ownership) {
		
		this(name, city, state, zip,ownership);
		this.id = id;
		
	}
	
	public Contact(String name, String city, String state, String zip, String ownership) {

		this.name = name;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.ownership = ownership;
	}
	
public Contact() {
		
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

}
