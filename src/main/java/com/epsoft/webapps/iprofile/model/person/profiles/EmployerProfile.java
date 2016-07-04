package com.epsoft.webapps.iprofile.model.person.profiles;

import org.springframework.stereotype.Repository;

import com.epsoft.webapps.iprofile.model.constant.Cuntry;
import com.epsoft.webapps.iprofile.model.person.Review;

@Repository
public class EmployerProfile implements Profile{
    private Cuntry cuntry;
    private String city;
    private String contactInformation;
    private String actualProposotion;
    private Review information;

    public EmployerProfile() {
    }

    public EmployerProfile(Cuntry cuntry, String city, String contactInformation, String actualProposotion, Review information) {
        this.cuntry = cuntry;
        this.city = city;
        this.contactInformation = contactInformation;
        this.actualProposotion = actualProposotion;
        this.information = information;
    }

    public Cuntry getCuntry() {
        return cuntry;
    }

    public void setCuntry(Cuntry cuntry) {
        this.cuntry = cuntry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getActualProposotion() {
        return actualProposotion;
    }

    public void setActualProposotion(String actualProposotion) {
        this.actualProposotion = actualProposotion;
    }

    public Review getInformation() {
        return information;
    }

    public void setInformation(Review information) {
        this.information = information;
    }

    public boolean isEmployee() {
        return false;
    }

}
