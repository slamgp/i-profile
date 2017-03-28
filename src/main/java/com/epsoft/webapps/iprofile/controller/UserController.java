package com.epsoft.webapps.iprofile.controller;

import org.json.simple.JSONObject;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/userRequest")
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public JSONObject userRequest() {

        JSONObject resultJson = new JSONObject();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof AnonymousAuthenticationToken) {
            resultJson.put("succes", false);
        } else {
            resultJson.put("succes", true);
            resultJson.put("login", auth.getName() + ", ");
        }
        System.out.println("AUTH = " + auth + "name = " + auth.getName());
        return resultJson;
    }


}
