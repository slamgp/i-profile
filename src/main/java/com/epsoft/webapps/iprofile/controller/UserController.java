package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.security.UserAuthentication;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/userRequest")
public class UserController {
    @Autowired
    SecurityContext contextHolder;
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;

    @RequestMapping(method = RequestMethod.POST)
    public JSONObject userRequest() {

        JSONObject resultJson = new JSONObject();
        Authentication auth = (UserAuthentication) session.getAttribute(request.getSession().getId());
        //contextHolder.getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            resultJson.put("succes", false);
        } else {
            resultJson.put("succes", true);
            resultJson.put("login", auth.getName());
            resultJson.put("avatar", "http://localhost:8082/i-profile/resources/img/main_avatar.jpg");
            resultJson.put("allUserName", "WOLF WOLF WOLF WOLF WOLF WOLF WOLF WOLF");
        }
        return resultJson;
    }


}
