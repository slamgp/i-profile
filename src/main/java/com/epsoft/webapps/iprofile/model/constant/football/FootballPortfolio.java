package com.epsoft.webapps.iprofile.model.constant.football;

import java.util.Date;
import java.util.List;

import com.epsoft.webapps.iprofile.model.constant.FootballPositions;

public class FootballPortfolio {
    private Team team;
    private Date startDate;
    private Date finishDate;
    private List<FootballPositions> positions;
    private String reviews;
    private List<String> videos;
    private List<String> fotos;

    public FootballPortfolio() {
    }

    public FootballPortfolio(Team team, Date startDate, Date finishDate, List<FootballPositions> positions, String reviews, List<String> videos,
            List<String> fotos) {

        this.team = team;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.positions = positions;
        this.reviews = reviews;
        this.videos = videos;
        this.fotos = fotos;
    }

    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
    public List<FootballPositions> getPositions() {
        return positions;
    }
    public void setPositions(List<FootballPositions> positions) {
        this.positions = positions;
    }
    public String getReviews() {
        return reviews;
    }
    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
    public List<String> getVideos() {
        return videos;
    }
    public void setVideos(List<String> videos) {
        this.videos = videos;
    }
    public List<String> getFotos() {
        return fotos;
    }
    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

}
