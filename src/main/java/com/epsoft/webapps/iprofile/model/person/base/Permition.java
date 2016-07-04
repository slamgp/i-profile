package com.epsoft.webapps.iprofile.model.person.base;

public class Permition {
    private boolean isAdmin;
    private boolean isEmploee;
    private boolean isEmploer;

    public Permition() {
    }

    public Permition(boolean isAdmin, boolean isEmploee, boolean isEmploer) {
        this.isAdmin = isAdmin;
        this.isEmploee = isEmploee;
        this.isEmploer = isEmploer;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isEmploee() {
        return isEmploee;
    }

    public void setEmploee(boolean isEmploee) {
        this.isEmploee = isEmploee;
    }

    public boolean isEmploer() {
        return isEmploer;
    }

    public void setEmploer(boolean isEmploer) {
        this.isEmploer = isEmploer;
    }

}
