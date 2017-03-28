package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.security.User;
import com.epsoft.webapps.iprofile.model.security.UserAuthentication;
import com.epsoft.webapps.iprofile.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    UserService userServise;
    @Autowired
    @Qualifier("passwordEncoder")
    PasswordEncoder encoder;


    @RequestMapping(method = RequestMethod.POST)
    public JSONObject authentication(@RequestBody JSONObject jsonObject) {
        JSONObject resultJson = new JSONObject();
        String email    = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");
        User user = userServise.loadUserByEmail(email);
        if (user != null) {
            if (encoder.matches(password, user.getPassword())) {
                resultJson.put("succes", true);
                resultJson.put("login", user.getLogin());
                SecurityContextHolder.getContext().setAuthentication(new UserAuthentication(user));
            } else {
                resultJson.put("succes", false);
            }
        } else {
            resultJson.put("succes", false);
            resultJson.put("noUser", true);
        }
        return resultJson;
    }
}
