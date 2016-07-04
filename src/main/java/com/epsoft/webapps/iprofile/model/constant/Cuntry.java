package com.epsoft.webapps.iprofile.model.constant;

public class Cuntry {
    private String name;
    private String shortName;
    private String flag;

    public Cuntry() {
    }

    public Cuntry(String name, String shortName, String flag) {
        this.name = name;
        this.shortName = shortName;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}
