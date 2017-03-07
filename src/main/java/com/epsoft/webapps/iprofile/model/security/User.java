package com.epsoft.webapps.iprofile.model.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User  implements UserDetails {
    private String login;
    private String email;
    private String password;
    private List<Role> authorities;

    public User() {

    }

    public User(String login, String email, String password, List<Role> authorities) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
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
}

