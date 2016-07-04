package com.epsoft.webapps.iprofile.model.person;

import com.epsoft.webapps.iprofile.model.constant.FootballPositions;
import com.epsoft.webapps.iprofile.model.constant.football.FootballPortfolio;
import com.epsoft.webapps.iprofile.model.person.base.ProfessionalSkills;

public class FootballSkills extends ProfessionalSkills{
    private FootballPortfolio portfolio;
    private FootballPositions favoritePosition; 
    private String reviews;

    public FootballSkills() {
    } 

    public FootballSkills(FootballPortfolio portfolio, FootballPositions favoritePosition, String reviews) {
        this.portfolio = portfolio;
        this.favoritePosition = favoritePosition;
        this.reviews = reviews;
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

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    } 

    
}
