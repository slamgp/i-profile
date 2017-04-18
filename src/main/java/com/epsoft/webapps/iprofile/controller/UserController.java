package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.security.UserAuthentication;
import com.epsoft.webapps.iprofile.service.JsonResponseCreator;
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
    @Autowired
    JsonResponseCreator responseCreator;

    @RequestMapping(method = RequestMethod.POST)
    public JSONObject userRequest() {

        JSONObject resultJson;
        Authentication auth = (UserAuthentication) session.getAttribute(request.getSession().getId());
        //contextHolder.getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            resultJson = responseCreator.createAuthenticateFailureResponse();
        } else {
            resultJson = responseCreator.createAuthenticateSuccesResponse(auth);
        }
        return resultJson;
    }


}
