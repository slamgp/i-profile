package com.epsoft.webapps.iprofile.model.person;

import com.epsoft.webapps.iprofile.model.constant.FootballPositions;
import com.epsoft.webapps.iprofile.model.constant.football.FootballPortfolio;
import com.epsoft.webapps.iprofile.model.person.base.ProfessionalSkills;

public class FootballSkills extends ProfessionalSkills{
    private FootballPortfolio portfolio;
    private FootballPositions favoritePosition; 

    public FootballSkills() {
    } 

    public FootballSkills(FootballPortfolio portfolio, FootballPositions favoritePosition) {
        this.portfolio = portfolio;
        this.favoritePosition = favoritePosition;
    }

    public FootballPortfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(FootballPortfolio portfolio) {
        this.portfolio = portfolio;
    }

    public FootballPositions getFavoritePosition() {
        return favoritePosition;
    }

    public void setFavoritePosition(FootballPositions favoritePosition) {
        this.favoritePosition = favoritePosition;
    }

}
