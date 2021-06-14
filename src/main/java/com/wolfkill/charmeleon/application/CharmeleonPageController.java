package com.wolfkill.charmeleon.application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CharmeleonPageController {
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage(Model model) {
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/lk/{id}", method = RequestMethod.GET)
    public String localPage(@PathVariable("id") Integer id) {
        return "localpage";
    }
}
