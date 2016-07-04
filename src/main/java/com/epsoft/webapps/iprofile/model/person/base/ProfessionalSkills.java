package com.epsoft.webapps.iprofile.model.person.base;

import com.epsoft.webapps.iprofile.model.person.KindOfSports;

public abstract class ProfessionalSkills {
    KindOfSports kindOfSports;

    public KindOfSports getKindOfSport() {
        return kindOfSports;
    };

    public void setKindOfSport(KindOfSports kindOfSports) {
        this.kindOfSports = kindOfSports;
    };
}
