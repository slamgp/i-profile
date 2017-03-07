package com.epsoft.webapps.iprofile.model.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, SUPER_USE, USER;

    public String getAuthority() {
        return name();
    }
}
