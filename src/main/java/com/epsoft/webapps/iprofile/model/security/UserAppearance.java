package com.epsoft.webapps.iprofile.model.security;

public class UserAppearance {
    private int age;
    private int high;
    private int weight;
    private String mainFoot;

    public UserAppearance(int age, int high, int weight, String mainFoot) {
        this.age = age;
        this.high = high;
        this.weight = weight;
        this.mainFoot = mainFoot;
    }

    public int getAge() {
        return age;
    }

    public int getHigh() {
        return high;
    }

    public int getWeight() {
        return weight;
    }

    public String getMainFoot() {
        return mainFoot;
    }
}
