package com.epsoft.webapps.iprofile.model.person;

import com.epsoft.webapps.iprofile.model.security.User;
import org.springframework.stereotype.Repository;

import com.epsoft.webapps.iprofile.model.constant.AppLanguage;
import com.epsoft.webapps.iprofile.model.person.base.Permition;
import com.epsoft.webapps.iprofile.model.person.profiles.EmployeeProfile;
import com.epsoft.webapps.iprofile.model.person.profiles.Profile;

@Repository
public class Accaunt {
    private User user;
    private Profile profile;
    private AppLanguage appLanguage;
    private Permition permition;

    public Accaunt() {
    }

    public Accaunt(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {

        return user;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(EmployeeProfile profile) {
        this.profile = profile;
    }

    public AppLanguage getAppLanguage() {
        return appLanguage;
    }

    public void setAppLanguage(AppLanguage appLanguage) {
        this.appLanguage = appLanguage;
    }

}
