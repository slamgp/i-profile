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
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);

        PasswordEncoder enc = new BCryptPasswordEncoder(4, random);
        String encodestr = enc.encode("1111");
        System.out.println(enc.matches( "1111", encodestr));
    }
}
