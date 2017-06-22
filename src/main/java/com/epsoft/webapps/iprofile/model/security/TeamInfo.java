package com.epsoft.webapps.iprofile.model.security;

public class TeamInfo {
    private int id;
    private String name;
    private String startPeriod;
    private String endPeriod;
    private String teamState;
    private String region;
    private String area;
    private String city;
    private String position;

    public TeamInfo(int id, String name, String startPeriod, String endPeriod, String teamState, String region, String area, String city, String position) {
        this.id = id;
        this.name = name;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.teamState = teamState;
        this.region = region;
        this.area = area;
        this.city = city;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStartPeriod() {
        return startPeriod;
    }

    public String getEndPeriod() {
        return endPeriod;
    }

    public String getTeamState() {
        return teamState;
    }

    public String getRegion() {
        return region;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getPosition() {
        return position;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setStartPeriod(String startPeriod) {
        this.startPeriod = startPeriod;
    }

    public void setEndPeriod(String endPeriod) {
        this.endPeriod = endPeriod;
    }

    public void setTeamState(String teamState) {
        this.teamState = teamState;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
