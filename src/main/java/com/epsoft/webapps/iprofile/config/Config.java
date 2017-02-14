package com.epsoft.webapps.iprofile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.security.SecureRandom;

@Configuration
@ComponentScan("com.epsoft.webapps.iprofile.controller")
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);

        return new BCryptPasswordEncoder(4,random);
    }

}
