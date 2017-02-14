package com.epsoft.webapps.iprofile.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userregistration")
public class RegistrationController {
    @Autowired
    @Qualifier("passwordEncoder")
    PasswordEncoder encoder;

    @RequestMapping(method = RequestMethod.POST)
    public JSONObject registration(@RequestBody JSONObject jsonObject) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("succes", true);
        resultJson.put("login", jsonObject.get("login"));
        resultJson.put("email", jsonObject.get("email"));
        resultJson.put("password", encoder.encode((CharSequence) jsonObject.get("password")));
        return resultJson;
    }
}
