package com.epsoft.webapps.iprofile.model.person;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User {
    private String login;
    private String email;
    private String password;

    public User() {

    }

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

