package com.TB_Challenge.model;

public class Status {
    private Integer id;
    private String name;
    private String status;
    private String desc;

    public Status(Integer id, String name, String status, String desc) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.desc = desc;
    }
    public Status() {

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
