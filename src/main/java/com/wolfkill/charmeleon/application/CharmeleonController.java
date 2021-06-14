package com.wolfkill.charmeleon.application;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.wolfkill.charmeleon.application.db.AuthChecker;
import com.wolfkill.charmeleon.application.user.UserData;
import com.wolfkill.charmeleon.application.user.UserProperties;
import com.wolfkill.charmeleon.application.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Component
@RestController
public class CharmeleonController {
    @Autowired
    private UserRepository userRepository;
    private Logger logger = Logger.getLogger(CharmeleonController.class.getName());

    @PostMapping("/auth")
    public UserProperties authResponse(
        @RequestParam(value = "login") String login,
        @RequestParam(value = "password") String password,
        @RequestParam(value = "cookie") String cookie) {
        CharmeleonLoginProperties authResponse = new CharmeleonLoginProperties(login, password);
        UserProperties userProperties = AuthChecker.checkAuthResponse(authResponse, userRepository);
        if (userProperties.responseStatus == ResponseStatus.CONFIRMED) {
            userProperties.personalCookie = cookie;
            logger.log(Level.INFO,"cookie = " + cookie);
        }
        return userProperties;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public @ResponseBody
    ResponseStatus addNewUser(@RequestBody UserData userData) {
        UserProperties userProperties = AuthChecker.checkRegistrationResponse(userData, userRepository);
        if (userProperties.responseStatus == ResponseStatus.NOT_USED) {
            userRepository.save(userData);
        }
        return userProperties.responseStatus;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<UserData> getAllUsers() {
        return userRepository.findAll();
    }
}
