package com.epsoft.webapps.iprofile.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userregistration")
public class RegistrationController {
    @RequestMapping(method = RequestMethod.POST)
    public JSONObject registration(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject.get("login"));
        JSONObject resultJson = new JSONObject();
        resultJson.put("succes", true);
        return resultJson;
    }
}
