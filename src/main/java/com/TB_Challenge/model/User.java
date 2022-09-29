package com.TB_Challenge.model;

public class User {
    private Integer id;
    private String username;
    private String password;
    private int role;
    private int status;

    public User (String username, String password, int role, int status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public User (Integer id, String username, int role, int status) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password " + password + ", role " + role + ", status " + status
                +  "]";
    }

}
