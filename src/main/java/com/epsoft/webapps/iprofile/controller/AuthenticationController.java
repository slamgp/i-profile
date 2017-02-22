package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.person.User;
import com.epsoft.webapps.iprofile.service.UserManager;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    UserManager userManager;
    @Autowired
    @Qualifier("passwordEncoder")
    PasswordEncoder encoder;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping(method = RequestMethod.POST)
    public JSONObject authentication(@RequestBody JSONObject jsonObject) {
        JSONObject resultJson = new JSONObject();
        String email    = (String) jsonObject.get("email");
        String password = (String) jsonObject.get("password");
        User user = userManager.getUserByEmail(email);
        if (user != null) {
            httpSession.setAttribute("user", user);
            if (encoder.matches(password, user.getPassword())) {
                resultJson.put("succes", true);
                resultJson.put("login", user.getLogin());
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
