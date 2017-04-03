package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.security.User;
import com.epsoft.webapps.iprofile.model.security.UserAuthentication;
import com.epsoft.webapps.iprofile.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    HttpServletRequest request;
    @Autowired
    SecurityContext contextHolder;


    @RequestMapping(method = RequestMethod.POST)
    public JSONObject authentication(@RequestBody JSONObject jsonObject) {
        JSONObject resultJson = new JSONObject();
        String email    = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");


        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        token.setDetails(new WebAuthenticationDetails(request));
        try {
            Authentication authentication = authenticationManager.authenticate(token);
            resultJson.put("succes", true);
            resultJson.put("login", authentication.getName());
            contextHolder.setAuthentication(authentication);
        } catch (AuthenticationException e) {
            resultJson.put("succes", false);
            resultJson.put("noUser", "no user");
        }

        return resultJson;
    }
}
