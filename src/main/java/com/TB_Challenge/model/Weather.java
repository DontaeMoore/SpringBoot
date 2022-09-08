package com.TB_Challenge.model;

public class Weather {

    private final String wSpeed;
    private final String description;
    private final String icon;
    private final String temp;

    public Weather(String temp, String description, String icon, String wSpeed) {

        this.temp = temp;
        this.description = description;
        this.icon = icon;
        this.wSpeed = wSpeed;
    }

    public String[] getList() {
        String[] StringArray = new String[4];
        StringArray[0] = temp;
        StringArray[1] = description;
        StringArray[2] = icon;
        StringArray[3] = wSpeed;

        return StringArray;

    }

}