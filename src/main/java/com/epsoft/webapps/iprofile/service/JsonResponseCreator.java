package com.epsoft.webapps.iprofile.service;


import com.epsoft.webapps.iprofile.model.security.TeamInfo;
import com.epsoft.webapps.iprofile.model.security.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.security.core.Authentication;

public class JsonResponseCreator {
    public JSONObject createAuthenticateSuccesResponse(Authentication authentication) {
        User user = (User) authentication.getDetails();
        JSONObject resultJson = new JSONObject();
        resultJson.put("succes", true);
        resultJson.put("login", authentication.getName());
        resultJson.put("avatar", user.getAvatar());
        resultJson.put("allUserName", user.getAllName());
        resultJson.put("position", user.getPosition());
        JSONObject appearance = new JSONObject();
        appearance.put("age", user.getAppearance().getAge());
        appearance.put("high", user.getAppearance().getHigh());
        appearance.put("weight", user.getAppearance().getWeight());
        appearance.put("mainFoot", user.getAppearance().getMainFoot());
        resultJson.put("appearance",appearance);
        JSONArray carier = new JSONArray();
        for (TeamInfo teamInfo: user.getTeamsInfo()) {
            JSONObject teamInfoJson = new JSONObject();
            teamInfoJson.put("id", teamInfo.getId());
            teamInfoJson.put("name", teamInfo.getName());
            teamInfoJson.put("startPeriod", teamInfo.getStartPeriod());
            teamInfoJson.put("endPeriod", teamInfo.getEndPeriod());
            teamInfoJson.put("teamState", teamInfo.getTeamState());
            teamInfoJson.put("region", teamInfo.getRegion());
            teamInfoJson.put("area", teamInfo.getArea());
            teamInfoJson.put("city", teamInfo.getCity());
            teamInfoJson.put("position", teamInfo.getPosition());
            carier.add(teamInfoJson);
        }
        resultJson.put("carier", carier);

        return resultJson;
    }

    public JSONObject createAuthenticateFailureResponse() {
        JSONObject resultJson = new JSONObject();
        resultJson.put("succes", false);
        resultJson.put("noUser", "no user");
        return resultJson;
    }
}

