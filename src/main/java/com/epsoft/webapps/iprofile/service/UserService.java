package com.epsoft.webapps.iprofile.service;


import com.epsoft.webapps.iprofile.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    @Qualifier("users")
    List<User> users;

    public boolean findByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User loadUserByEmail(String email) throws UsernameNotFoundException {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("user not found with email: " + email);
    }

    public User loadUserByUsername(String login) throws UsernameNotFoundException {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("user not found with login: " + login);
    }

    public long getLasId() {
        return users.size() + 1;
    }
}
