package com.epsoft.webapps.iprofile.controller;

import com.epsoft.webapps.iprofile.model.person.User;
import com.epsoft.webapps.iprofile.model.repository.UserReposytory;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.Set;


@RestController
@RequestMapping("/userregistration")
public class RegistrationController {
  // @Autowired(required = true)
 //  CrudRepository aa;
    @Autowired
    @Qualifier("passwordEncoder")
    PasswordEncoder encoder;


    @RequestMapping(method = RequestMethod.POST)
    public JSONObject registration(@RequestBody JSONObject jsonObject) {
        System.out.println("aaaaaaaaaaa");
   //     if(users.findByEmail((String) jsonObject.get("email")) == null) {
       //     users.save(new User((String)jsonObject.get("login"), (String)jsonObject.get("email"), (String)jsonObject.get("password")));
      //  }
        JSONObject resultJson = new JSONObject();
        Object succes = resultJson.put("succes", true);
    //    resultJson.put("count", users.count());
        resultJson.put("count", 1);
        return resultJson;
    }
}
