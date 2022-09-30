package com.TB_Challenge.config.model;

public class Challenge {

    private Integer id;
    private String name;
    private String desc;
    private int first_points;
    private int second_points;
    private int third_points;
    private int fourth_points;
    private String status;

    private String date;

    public Challenge() {
    }

    public Challenge(Integer id, String name, String desc, int first_points, int second_points, int third_points, int fourth_points, String status, String date) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.first_points = first_points;
        this.second_points = second_points;
        this.third_points = third_points;
        this.fourth_points = fourth_points;
        this.status = status;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getFirst_points() {
        return first_points;
    }

    public void setFirst_points(int first_points) {
        this.first_points = first_points;
    }

    public int getSecond_points() {
        return second_points;
    }

    public void setSecond_points(int second_points) {
        this.second_points = second_points;
    }

    public int getThird_points() {
        return third_points;
    }

    public void setThird_points(int third_points) {
        this.third_points = third_points;
    }

    public int getFourth_points() {
        return fourth_points;
    }

    public void setFourth_points(int fourth_points) {
        this.fourth_points = fourth_points;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", first_points=" + first_points +
                ", second_points=" + second_points +
                ", third_points=" + third_points +
                ", fourth_points=" + fourth_points +
                ", status='" + status + '\'' +
                '}';
    }
}
