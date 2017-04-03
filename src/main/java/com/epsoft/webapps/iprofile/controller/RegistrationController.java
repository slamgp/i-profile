package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.security.Role;
import com.epsoft.webapps.iprofile.model.security.User;
import com.epsoft.webapps.iprofile.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/userregistration")
public class RegistrationController {
    @Autowired
    UserService userService;
    @Autowired
    @Qualifier("passwordEncoder")
    PasswordEncoder encoder;

    @RequestMapping(method = RequestMethod.POST)
    public JSONObject registration(@RequestBody JSONObject jsonObject) {
        JSONObject resultJson = new JSONObject();
        User user = new User((String) jsonObject.get("login"), (String) jsonObject.get("email"),
                encoder.encode((String) jsonObject.get("password")), createAuthorities());
        boolean newUser;
        String failDescription = "";
        if (userService.findByEmail(user.getEmail())) {
            newUser = false;
            failDescription += user.getEmail();
        } else {
            newUser = true;
        }
        if (userService.findByLogin(user.getLogin())) {
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
        if (newUser) {
            userService.addUser(user);
        }
        return resultJson;
    }

    private List<Role> createAuthorities() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(Role.USER);
        return roles;
    }
}
