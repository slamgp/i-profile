package com.epsoft.webapps.iprofile.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class GeneralInformation {
    private int numberOfBirth; // 1-31
    private int monthOfBirth; // 1-12
    private int yearsOfBirth;
    private int cuntryOfBirth;
    private int cityOfBirth;
    private int cuntryOfLive;
    private int cityOfLive;
    private List<String> citizenship;
    private String nationality;
    private Boolean isMaried;
    private int countChildren;

    public GeneralInformation() {

    }

    public int getNumberOfBirth() {
        return numberOfBirth;
    }

    public void setNumberOfBirth(int numberOfBirth) {
        this.numberOfBirth = numberOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearsOfBirth() {
        return yearsOfBirth;
    }

    public void setYearsOfBirth(int yearsOfBirth) {
        this.yearsOfBirth = yearsOfBirth;
    }

    public int getCuntryOfBirth() {
        return cuntryOfBirth;
    }

    public void setCuntryOfBirth(int cuntryOfBirth) {
        this.cuntryOfBirth = cuntryOfBirth;
    }

    public int getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(int cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public int getCuntryOfLive() {
        return cuntryOfLive;
    }

    public void setCuntryOfLive(int cuntryOfLive) {
        this.cuntryOfLive = cuntryOfLive;
    }

    public int getCityOfLive() {
        return cityOfLive;
    }

    public void setCityOfLive(int cityOfLive) {
        this.cityOfLive = cityOfLive;
    }

    public List<String> getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(List<String> citizenship) {
        this.citizenship = citizenship;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getIsMaried() {
        return isMaried;
    }

    public void setIsMaried(Boolean isMaried) {
        this.isMaried = isMaried;
    }

    public int getCountChildren() {
        return countChildren;
    }

    public void setCountChildren(int countChildren) {
        this.countChildren = countChildren;
    }

}
