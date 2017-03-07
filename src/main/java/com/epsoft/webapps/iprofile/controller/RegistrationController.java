package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.security.Role;
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
        System.out.println("1");
        JSONObject resultJson = new JSONObject();
        System.out.println("2");
        User  user = new  User((String) jsonObject.get("login"), (String) jsonObject.get("email"),
                encoder.encode((String)jsonObject.get("password")), createAuthorities());
        System.out.println("3");
        boolean newUser;
        String failDescription ="";
        System.out.println("4");
        if (userService.findByEmail(user.getEmail())) {
            newUser = false;
            failDescription += user.getEmail();
        } else {
            newUser = true;
        }
        System.out.println("5");
        if (userService.findByLogin(user.getLogin())) {
            newUser = newUser & false;
            failDescription += (", " + user.getLogin());
        } else {
            newUser = newUser & true;
        }
        System.out.println("6");
        resultJson.put("succes", newUser);
        if (newUser) {
            resultJson.put("login", user.getLogin());
        } else {
            resultJson.put("fail", failDescription);
        }
        System.out.println("7");
        if(newUser) {
            userService.addUser(user);
        }
        System.out.println("8");
        return resultJson;
    }

    private List<Role> createAuthorities() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(Role.USER);
        return roles;
    }
}
