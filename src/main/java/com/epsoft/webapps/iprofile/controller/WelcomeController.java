package com.epsoft.webapps.iprofile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    public static final String view = "welcome";

    @RequestMapping(method = RequestMethod.GET)
    public String showWelcome(@RequestParam("name")  String name, @RequestParam("mail")  String mail,ModelMap model) {
        model.addAttribute("name", name);
        model.addAttribute("mail", mail);
        return view;
    }
}
