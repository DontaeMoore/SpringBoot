package com.TB_Challenge.model;

public class User {
    private Integer id;
    private String username;
    private String password;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    private String role;
    private String status;

    public User(Integer id, String username, String password, String role, String status, String roleName, String statusName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
        this.roleName = roleName;
        this.statusName = statusName;
    }

    private String roleName;
    private String statusName;





    public User (String username, String password, String  role, String status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public User (Integer id, String username, String password, String role, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public String  getRole() {
        return role;
    }

    public void setRole(String  role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleName(int role)
    {

        if(role == 1){
            return "Admin";
        }
        if(role == 2){
            return "User";
        }
        if(role == 3){
            return "Official";
        }
        return "NO ROLE ASSIGNED";
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", roleName='" + roleName + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
