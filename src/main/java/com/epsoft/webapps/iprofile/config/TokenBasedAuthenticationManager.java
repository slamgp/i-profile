package com.epsoft.webapps.iprofile.config;

import com.epsoft.webapps.iprofile.model.security.User;
import com.epsoft.webapps.iprofile.model.security.UserAuthentication;
import com.epsoft.webapps.iprofile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;


public class TokenBasedAuthenticationManager implements AuthenticationManager {
    @Autowired
    UserService userServise;
    @Autowired
    @Qualifier("passwordEncoder")
    PasswordEncoder encoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";

        User user = userServise.loadUserByEmail(username);
        if (user == null) {
            throw new BadCredentialsException("1000");
        }
        if (!encoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("1000");
        }

        return new  UserAuthentication(user);
    }
}
