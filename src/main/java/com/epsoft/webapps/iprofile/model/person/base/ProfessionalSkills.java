package com.epsoft.webapps.iprofile.model.person.base;

import com.epsoft.webapps.iprofile.model.person.KindOfSports;
import com.epsoft.webapps.iprofile.model.person.Review;

public abstract class ProfessionalSkills {
    private KindOfSports kindOfSports;
    private Review reviews;
    
    public KindOfSports getKindOfSport() {
        return kindOfSports;
    };

    public void setKindOfSport(KindOfSports kindOfSports) {
        this.kindOfSports = kindOfSports;
    }

    public Review getReviews() {
        return reviews;
    }

    public void setReviews(Review reviews) {
        this.reviews = reviews;
    };
}
