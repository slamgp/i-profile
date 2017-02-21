package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.person.User;
import com.epsoft.webapps.iprofile.service.UserManager;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/userregistration")
public class RegistrationController {
    @Autowired
    UserManager userManager;
    @Autowired
    @Qualifier("passwordEncoder")
    PasswordEncoder encoder;
    @Autowired
    private HttpSession httpSession;


    @RequestMapping(method = RequestMethod.POST)
    public JSONObject registration(@RequestBody JSONObject jsonObject) {
        JSONObject resultJson = new JSONObject();
        User  user = new  User((String) jsonObject.get("login"), (String) jsonObject.get("email"), encoder.encode((String)jsonObject.get("password")));
        boolean newUser = false;
        if (userManager.findByEmail(user.getEmail())) {
            newUser = false;
            resultJson.put("email", user.getEmail());
        } else {
            newUser = true;
        }

        if (userManager.findByLogin(user.getLogin())) {
            newUser = false;
            resultJson.put("login", user.getLogin());
        } else {
            newUser = true;
        }
        resultJson.put("succes", newUser);

        if(newUser) {
            userManager.addUser(user);
        }

        return resultJson;
    }
}
