package com.epsoft.webapps.iprofile.model;

import org.springframework.stereotype.Repository;

@Repository
public class Profile {
    Look look;
    GeneralInformation generalInformation;

    public Profile() {
    }

    public Look getLook() {
        return look;
    }

    public void setLook(Look look) {
        this.look = look;
    }

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }

}
