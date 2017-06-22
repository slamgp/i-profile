package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.security.TeamInfo;
import com.epsoft.webapps.iprofile.model.security.User;
import com.epsoft.webapps.iprofile.model.security.UserAuthentication;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


@RestController
@RequestMapping("/userCarierDataChange")
public class UserCarierChangeController {
    @Autowired
    HttpSession session;
    @Autowired
    HttpServletRequest request;

    @RequestMapping(method = RequestMethod.POST)
    public JSONObject userRequest(@RequestBody JSONObject jsonObject) {
        JSONObject resultJson = new JSONObject();
        ;
        Authentication auth = (UserAuthentication) session.getAttribute(request.getSession().getId());
        if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
            setField((User) auth.getDetails(), Integer.parseInt((String) jsonObject.get("id")), (String) jsonObject.get("change_field"), (String) jsonObject.get("change_value"));
        }
        return resultJson;
    }

    private void setField(User user, int id, String fieldName, String fieldValue) {
        TeamInfo teamInfo = getTeamInfor(user, id);
        if (teamInfo == null) {
            return;
        }

        if ("name".equals(fieldName)) {
            teamInfo.setName(fieldValue);
        }
        if ("startPeriod".equals(fieldName)) {
            teamInfo.setStartPeriod(fieldValue);
        }
        if ("endPeriod".equals(fieldName)) {
            teamInfo.setEndPeriod(fieldValue);
        }
        if ("teamState".equals(fieldName)) {
            teamInfo.setTeamState(fieldValue);
        }
        if ("region".equals(fieldName)) {
            teamInfo.setRegion(fieldValue);
        }
        if ("area".equals(fieldName)) {
            teamInfo.setArea(fieldValue);
        }
        if ("city".equals(fieldName)) {
            teamInfo.setCity(fieldValue);
        }
        if ("position".equals(fieldName)) {
            teamInfo.setPosition(fieldValue);
        }
    }

    private TeamInfo getTeamInfor(User user, int id) {
        for (TeamInfo info: user.getTeamsInfo()) {
            if (info.getId() == id) {
                return info;
            }
        }
        return null;
    }
}
