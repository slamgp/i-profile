package com.epsoft.webapps.iprofile.model.person;

import org.springframework.stereotype.Repository;

import com.epsoft.webapps.iprofile.model.constant.AppLanguage;

@Repository
public class Accaunt {
    private String email;
    private String password;
    private Profile profile;
    private AppLanguage appLanguage;

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

    public AppLanguage getAppLanguage() {
        return appLanguage;
    }

    public void setAppLanguage(AppLanguage appLanguage) {
        this.appLanguage = appLanguage;
    }

}
