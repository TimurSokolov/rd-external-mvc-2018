package com.epam.rd.rdtestweb.dto;

public class User {

    private String login;
    private String password;
    private String role;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String login) {
        super();
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
