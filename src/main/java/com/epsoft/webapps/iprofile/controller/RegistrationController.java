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

    @RequestMapping(method = RequestMethod.POST)
    public JSONObject registration(@RequestBody JSONObject jsonObject) {
        JSONObject resultJson = new JSONObject();
        User  user = new  User((String) jsonObject.get("login"), (String) jsonObject.get("email"),
                encoder.encode((String)jsonObject.get("password")));
        boolean newUser;
        String failDescription ="";
        if (userManager.findByEmail(user.getEmail())) {
            newUser = false;
            failDescription += user.getEmail();
        } else {
            newUser = true;
        }

        if (userManager.findByLogin(user.getLogin())) {
            newUser = newUser & false;
            failDescription += (", " + user.getLogin());
        } else {
            newUser = newUser & true;
        }
        resultJson.put("succes", newUser);
        if (newUser) {
            resultJson.put("login", user.getLogin());
        } else {
            resultJson.put("fail", failDescription);
        }

        if(newUser) {
            userManager.addUser(user);
        }

        return resultJson;
    }
}
