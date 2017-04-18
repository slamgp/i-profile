package com.epsoft.webapps.iprofile.service;


import org.json.simple.JSONObject;
import org.springframework.security.core.Authentication;

public class JsonResponseCreator {
    public JSONObject createAuthenticateSuccesResponse(Authentication authentication) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("succes", true);
        resultJson.put("login", authentication.getName());
        resultJson.put("avatar", "http://localhost:8082/i-profile/resources/img/main_avatar.jpg");
        resultJson.put("allUserName", "WOLF WOLF WOLF WOLF");
        resultJson.put("position", "GK");
        JSONObject appearance = new JSONObject();
        appearance.put("age", "20 yers");
        appearance.put("high", "178 cm");
        appearance.put("weight", "70 kg");
        appearance.put("mainFoot", "right");
        resultJson.put("appearance",appearance);
        JSONObject carier = new JSONObject();
        JSONObject teamInfo = new JSONObject();
        teamInfo.put("name", "SM-25");
        teamInfo.put("startPeriod", "01-01-2015");
        teamInfo.put("endPeriod", "-");
        teamInfo.put("teamState", "amator");
        teamInfo.put("region", "Kiev obl");
        teamInfo.put("area", "Brovarskiy");
        teamInfo.put("city", "Semypolki");
        teamInfo.put("position", "CB, LB, CM");
        carier.put("info1", teamInfo);
        JSONObject teamInfo2 = new JSONObject();
        teamInfo2.put("name", "OVRUT");
        teamInfo2.put("startPeriod", "01-01-2007");
        teamInfo2.put("endPeriod", "01-01-2015");
        teamInfo2.put("teamState", "amator");
        teamInfo2.put("region", "Kiev obl");
        teamInfo2.put("area", "Brovarskiy");
        teamInfo2.put("city", "Semypolki");
        teamInfo2.put("position", "CB, LB, CM");
        carier.put("info2", teamInfo2);
        resultJson.put("carier",carier);
        resultJson.put("additionalIInfo", "No aditional Info");
        return resultJson;
    }

    public JSONObject createAuthenticateFailureResponse() {
        JSONObject resultJson = new JSONObject();
        resultJson.put("succes", false);
        resultJson.put("noUser", "no user");
        return resultJson;
    }
}

