package com.epsoft.webapps.iprofile.model;

import org.springframework.stereotype.Repository;

@Repository
public class Look {
    private double height; // cm
    private double weight; // kg
    private double lengthOfTheLegs; // cm
    private double lengthOfTheArms; // cm
    private double lengthOfTheBody; // cm
    private double waist; // cm
    private double chest; // cm
    private double hip; // cm
    private String avatar; // photo ava

    public Look() {
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLengthOfTheLegs() {
        return lengthOfTheLegs;
    }

    public void setLengthOfTheLegs(double lengthOfTheLegs) {
        this.lengthOfTheLegs = lengthOfTheLegs;
    }

    public double getLengthOfTheArms() {
        return lengthOfTheArms;
    }

    public void setLengthOfTheArms(double lengthOfTheArms) {
        this.lengthOfTheArms = lengthOfTheArms;
    }

    public double getLengthOfTheBody() {
        return lengthOfTheBody;
    }

    public void setLengthOfTheBody(double lengthOfTheBody) {
        this.lengthOfTheBody = lengthOfTheBody;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getHip() {
        return hip;
    }

    public void setHip(double hip) {
        this.hip = hip;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
