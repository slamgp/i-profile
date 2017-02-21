package com.epsoft.webapps.iprofile.service;


import com.epsoft.webapps.iprofile.model.person.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class UserManager {
    @Autowired
    @Qualifier("users")
    List<User> users;

    public boolean findByLogin(String login) {
        for (User user : users) {
            if(user.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public boolean findByEmail(String email) {
        for (User user : users) {
            if(user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByEmail(String email) {
        for (User user : users) {
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}
