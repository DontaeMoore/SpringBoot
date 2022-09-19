package com.TB_Challenge.model;

import org.springframework.web.bind.annotation.RequestParam;

public class Race {

    private Integer id;
    private String year;
    private String name;
    private int track_id;
    private String date;
    private String deadline;
    private double distance = 0.00;
    private double finish_time = 0.00;

    private String trackName;



    public Race() {

    }

    public Race(String year, String name, String date, String trackName) {
        this.year = year;
        this.name = name;
        this.date = date;
        this.trackName = trackName;
    }
    public Race(Integer id, String year, String name, int track_id, String date, String deadline, double distance, double finishtime) {
        this.id = id;
        this.year = year;
        this.name = name;
        this.track_id = track_id;
        this.date = date;
        this.deadline = deadline;
        this.distance = distance;
        this.finish_time = finishtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrack_id() {
        return track_id;
    }

    public void setTrack_id(int track_id) {

        this.track_id = track_id;



    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTrackName(String name) {
        this.trackName = name;
    }

    public String getTrackName() {
       return trackName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(double finish_time) {
        this.finish_time = finish_time;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", name='" + name + '\'' +
                ", track_id=" + track_id +
                ", date='" + date + '\'' +
                ", deadline='" + deadline + '\'' +
                ", distance='" + distance + '\'' +
                ", finishtime='" + finish_time + '\'' +
                ", trackName='" + trackName + '\'' +
                '}';
    }

    public void checkBox(@RequestParam(value = "checkboxName", required = false) String checkboxValue)
    {
        System.out.println("checkbox is somethings");
        if(checkboxValue != null)
        {
            System.out.println("checkbox is checked");
        }
        else
        {
            System.out.println("checkbox is not checked");
        }
    }
}
