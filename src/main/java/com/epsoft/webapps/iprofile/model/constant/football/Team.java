package com.epsoft.webapps.iprofile.model.constant.football;

import com.epsoft.webapps.iprofile.model.constant.Cuntry;

public class Team {
    private String name;
    private String city;
    private Cuntry cuntry;

    public Team() {

    }

    public Team(String name, String city, Cuntry cuntry) {
        this.name = name;
        this.city = city;
        this.cuntry = cuntry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Cuntry getCuntry() {
        return cuntry;
    }

    public void setCuntry(Cuntry cuntry) {
        this.cuntry = cuntry;
    }

}
