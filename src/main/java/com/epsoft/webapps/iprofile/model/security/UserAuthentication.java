package com.epsoft.webapps.iprofile.model.security;

import com.sun.istack.internal.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

public class UserAuthentication implements Authentication {
    private final User user;
    private boolean authenticated = true;

    public UserAuthentication(@NotNull User user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    public Object getCredentials() {
        return user.getPassword();
    }

    public Object getDetails() {
        return user;
    }

    public Object getPrincipal() {
        return user;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    public String getName() {
        return user.getLogin();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public boolean implies(Subject subject) {
        return false;
    }
}
