package com.epsoft.webapps.iprofile.model.security;

public class TeamInfo {
    private String name;
    private String startPeriod;
    private String endPeriod;
    private String teamState;
    private String region;
    private String area;
    private String city;
    private String position;

    public TeamInfo(String name, String startPeriod, String endPeriod, String teamState, String region, String area, String city, String position) {
        this.name = name;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.teamState = teamState;
        this.region = region;
        this.area = area;
        this.city = city;
        this.position = position;
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
}
