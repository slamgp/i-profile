package com.epsoft.webapps.iprofile.model.person.profiles;

import org.springframework.stereotype.Repository;

import com.epsoft.webapps.iprofile.model.person.GeneralInformation;
import com.epsoft.webapps.iprofile.model.person.Look;
import com.epsoft.webapps.iprofile.model.person.base.ProfessionalSkills;

@Repository
public class EmployeeProfile implements Profile{
    private Look look;
    private GeneralInformation generalInformation;
    private ProfessionalSkills professionalSkils;
    private String contactInformation;

    public EmployeeProfile() {
    }

    public EmployeeProfile(Look look, GeneralInformation generalInformation, ProfessionalSkills professionalSkils) {
        this.look = look;
        this.generalInformation = generalInformation;
        this.professionalSkils = professionalSkils;
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

    public ProfessionalSkills getProfessionalSkils() {
        return professionalSkils;
    }

    public void setProfessionalSkils(ProfessionalSkills professionalSkils) {
        this.professionalSkils = professionalSkils;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public boolean isEmployee() {
        return true;
    }

}
