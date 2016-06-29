package com.epsoft.webapps.iprofile.model;

import org.springframework.stereotype.Repository;

@Repository
public class Accaunt {
    private String email;
    private String password;
    private Profile profile;

    public Accaunt() {
    }

    public Accaunt(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
