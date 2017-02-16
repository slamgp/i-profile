package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.person.User;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/userregistration")
public class RegistrationController {
    @Autowired
    @Qualifier("users")
    List<User> users;
    @Autowired
    @Qualifier("passwordEncoder")
    PasswordEncoder encoder;


    @RequestMapping(method = RequestMethod.POST)
    public JSONObject registration(@RequestBody JSONObject jsonObject) {
        if (!findByEmail(users, (String) jsonObject.get("email"))) {
            users.add(new User((String) jsonObject.get("login"), (String) jsonObject.get("email"), (String) jsonObject.get("password")));
        }
        JSONObject resultJson = new JSONObject();
        Object succes = resultJson.put("succes", true);
        resultJson.put("count", users.size());
        return resultJson;
    }

    private boolean findByEmail(List<User> users, String email) {
        for (User user : users) {
            if(user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}
