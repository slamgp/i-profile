package com.epsoft.webapps.iprofile.model.person;

public class Review {
    private Accaunt reviwer;
    private String reviw;

    public Review() {
    }

    public Review(Accaunt reviwer, String reviw) {
        this.reviwer = reviwer;
        this.reviw = reviw;
    }

    public Accaunt getReviwer() {
        return reviwer;
    }

    public void setReviwer(Accaunt reviwer) {
        this.reviwer = reviwer;
    }

    public String getReviw() {
        return reviw;
    }

    public void setReviw(String reviw) {
        this.reviw = reviw;
    }

}
