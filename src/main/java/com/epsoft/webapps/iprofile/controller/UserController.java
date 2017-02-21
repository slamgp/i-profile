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

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/userRequest")
public class UserController {
    @Autowired
    private HttpSession httpSession;


    @RequestMapping(method = RequestMethod.GET)
    public JSONObject userRequest() {

        JSONObject resultJson = new JSONObject();
        System.out.println("login = " + httpSession.getAttribute("login"));
        if (httpSession.getAttribute("login") == null) {
            resultJson.put("succes", false);
        } else {
            resultJson.put("succes", true);
            resultJson.put("login", httpSession.getAttribute("login"));
        }
        return resultJson;
    }


}
