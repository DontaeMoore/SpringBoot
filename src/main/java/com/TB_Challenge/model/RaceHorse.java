package com.TB_Challenge.model;

public class RaceHorse {

    private Integer id;
    private String name;
    private String gender;
    private String foalyear;
    private String link;
    private String owner;
    private String trainer;
    private String comments;

    private String chosen;

    private Integer post;

    public RaceHorse() {


    }

    public RaceHorse(String name, String gender, String foalyear, String link, String owner, String trainer, String comments, Integer id) {
        this.name = name;
        this.gender = gender;
        this.foalyear = foalyear;
        this.link = link;
        this.owner = owner;
        this.trainer = trainer;
        this.comments = comments;
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;

    }

    public String getFoalyear() {
        return foalyear;
    }

    public void setFoalyear(String foalyear) {
        this.foalyear = foalyear;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getChosen() {
        return chosen;
    }

    public void setChosen(String chosen) {
        this.chosen = chosen;
    }

    public String setButton(String chosen){
        if(chosen.equals("Not picked")){
            return "";
        }
        return "disabled";
    }

    @Override
    public String toString() {
        return "RaceHorse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", foalyear='" + foalyear + '\'' +
                ", link='" + link + '\'' +
                ", owner='" + owner + '\'' +
                ", trainer='" + trainer + '\'' +
                ", comments='" + comments + '\'' +
                ", chosen='" + chosen + '\'' +
                ", post=" + post +
                '}';
    }
}
