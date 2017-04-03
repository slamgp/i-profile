package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.security.User;
import com.epsoft.webapps.iprofile.model.security.UserAuthentication;
import com.epsoft.webapps.iprofile.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/logout")
public class LogOutController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    @Autowired
    SecurityContext contextHolder;

    @RequestMapping(method = RequestMethod.GET)
    public JSONObject logout() {
        Authentication auth = contextHolder.getAuthentication();
        System.out.println("logouh1 = " + contextHolder.getAuthentication());
        JSONObject resultJson = new JSONObject();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            resultJson.put("succes", true);
        } else {
            resultJson.put("succes", false);
        }
        System.out.println("logouh2 = " + contextHolder.getAuthentication());
        return resultJson;
    }
}
