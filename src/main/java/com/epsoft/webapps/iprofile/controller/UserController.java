package com.epsoft.webapps.iprofile.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/userRequest")
public class UserController {
    @Autowired
    SecurityContext contextHolder;

    @RequestMapping(method = RequestMethod.POST)
    public JSONObject userRequest() {

        JSONObject resultJson = new JSONObject();
        Authentication auth = contextHolder.getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            resultJson.put("succes", false);
        } else {
            resultJson.put("succes", true);
            resultJson.put("login", auth.getName());
        }
        return resultJson;
    }


}
