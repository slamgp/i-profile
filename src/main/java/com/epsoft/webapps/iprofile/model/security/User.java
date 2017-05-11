package com.epsoft.webapps.iprofile.model.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Repository
public class User  implements UserDetails {
    private long id;
    private String login;
    private String email;
    private String password;
    private List<Role> authorities;
    private String avatar;
    private String allName;
    private String position;
    private UserAppearance appearance;
    private List<TeamInfo> teamsInfo;


    public User() {

    }

    public User(long id, String login, String email, String password, List<Role> authorities) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        avatar = "/i-profile/resources/img/main_avatar.jpg";
        allName = "WOLF WOLF WOLF WOLF";
        position = "CB";
        appearance = new UserAppearance(29, 190, 90, "L");
        TeamInfo teamInfo1 = new TeamInfo("SM-25", "01-01-2015", "-", "amator", "Kiev obl", "Brovarskiy", "Semypolki", "CB, LB, CM");
        TeamInfo teamInfo2 = new TeamInfo("OVRUT", "01-01-2007", "01-01-2015", "amator", "Kiev obl", "Brovarskiy", "Semypolki", "CB, LB, CM");
        teamsInfo = new ArrayList<TeamInfo>();
        teamsInfo.add(teamInfo1);
        teamsInfo.add(teamInfo2);

    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return null;
    }

    public boolean isAccountNonExpired() {
        return false;
    }

    public boolean isAccountNonLocked() {
        return false;
    }

    public boolean isCredentialsNonExpired() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getAllName() {
        return allName;
    }

    public String getPosition() {
        return position;
    }

    public UserAppearance getAppearance() {
        return appearance;
    }

    public List<TeamInfo> getTeamsInfo() {
        return teamsInfo;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setAllName(String allName) {
        this.allName = allName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAppearance(UserAppearance appearance) {
        this.appearance = appearance;
    }

    public void setTeamsInfo(List<TeamInfo> teamsInfo) {
        this.teamsInfo = teamsInfo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {

        return id;
    }
}

