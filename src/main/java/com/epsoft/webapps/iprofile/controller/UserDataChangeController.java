package com.epsoft.webapps.iprofile.controller;

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

import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


@RestController
@RequestMapping("/userDataChange")
public class UserDataChangeController {
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
            setField((User) auth.getDetails(), (String) jsonObject.get("change_field"), (String) jsonObject.get("change_value"));
        }
        return resultJson;
    }

    private void setField(User user, String fieldName, String fieldValue) {
        if ("allUserName".equals(fieldName)) {
            user.setAllName(fieldValue);
        }
        if ("age".equals(fieldName)) {
            user.getAppearance().setAge(Integer.valueOf(fieldValue));
        }
        if ("high".equals(fieldName)) {
            user.getAppearance().setHigh(Integer.valueOf(fieldValue));
        }
        if ("weight".equals(fieldName)) {
            user.getAppearance().setWeight(Integer.valueOf(fieldValue));
        }
        if ("mainFoot".equals(fieldName)) {
            user.getAppearance().setMainFoot(fieldValue);
        }
        if ("avatar".equals(fieldName)) {
            byte[] array = DatatypeConverter.parseBase64Binary(fieldValue);
            FileOutputStream fos = null;
            try {
                String userDir = new File(".").getCanonicalPath();
                String allPathDir = userDir + "\\avatars\\" + user.getId() + "\\";
                File userDirectory = new File(allPathDir);
                userDirectory.mkdirs();
                File userAvatarFile = new File(allPathDir + "avatar.jpg");
                if (userAvatarFile.exists()) {
                    userAvatarFile.delete();
                }
                userAvatarFile.createNewFile();
                fos = new FileOutputStream(userAvatarFile);
                fos.write(array, 0, array.length);
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
