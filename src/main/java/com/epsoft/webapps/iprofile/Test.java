package com.epsoft.webapps.iprofile;

import com.epsoft.webapps.iprofile.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.security.SecureRandom;

/**
 * Created by evgenyp on 2/14/2017.
 */
public class Test {
    public static  void main (String [] args) {
        String password = "123456";
        String passwor2 = "123456";
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);


        PasswordEncoder passwordEncoder = (PasswordEncoder)ctx.getBean("passwordEncoder");

        String hashedPassword = passwordEncoder.encode(password);
        String hashedPassword2 = passwordEncoder.encode(passwor2);

        System.out.println( hashedPassword);
        System.out.println( hashedPassword2);

        System.out.println(passwordEncoder.matches(password, hashedPassword));
        System.out.println(passwordEncoder.matches(passwor2, hashedPassword2));
        System.out.println(passwordEncoder.matches("123456_", hashedPassword));
    }
}
