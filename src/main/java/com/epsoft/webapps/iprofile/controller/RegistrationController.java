package com.epsoft.webapps.iprofile.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public JSONObject registration() {
        JSONObject resultJson = new JSONObject();
        resultJson.put("name", "put your name");
        resultJson.put("email", "put your email");
        return resultJson;
    }
}
