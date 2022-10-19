package com.TB_Challenge.model;

public class UserPicks {

    private Integer upID;

    private Integer user_id;

    private Integer race_id;

    private Integer horse_id;

    private String time;

    public UserPicks(Integer upID,Integer user_id, Integer race_id, Integer horse_id, String time) {
        this.upID = upID;
        this.race_id = race_id;
        this.horse_id = horse_id;
        this.time = time;
        this.user_id = user_id;
    }

    public UserPicks() {
    }

    public Integer getUpID() {
        return upID;
    }

    public void setUpID(Integer upID) {
        this.upID = upID;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRace_id() {
        return race_id;
    }

    public void setRace_id(Integer race_id) {
        this.race_id = race_id;
    }

    public Integer getHorse_id() {
        return horse_id;
    }

    public void setHorse_id(Integer horse_id) {
        this.horse_id = horse_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserPicks{" +
                "upID=" + upID +
                ", user_id=" + user_id +
                ", race_id=" + race_id +
                ", horse_id=" + horse_id +
                ", time='" + time + '\'' +
                '}';
    }
}
