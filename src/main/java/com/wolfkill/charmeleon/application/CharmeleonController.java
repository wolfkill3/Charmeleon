package com.wolfkill.charmeleon.application;

import java.util.logging.Logger;

import com.wolfkill.charmeleon.application.db.AuthChecker;
import com.wolfkill.charmeleon.application.user.UserProperties;
import com.wolfkill.charmeleon.application.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        @RequestParam(value = "password") String password) {
        logger.info("login = " + login);
        logger.info("password = " + password);
        CharmeleonAuthResponse authResponse = new CharmeleonAuthResponse(login, password);
        return AuthChecker.checkAuthResponse(authResponse, userRepository);
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String link
        , @RequestParam String login
        , @RequestParam String password) {

        UserProperties userProperties = new UserProperties();
        userProperties.setLink(link);
        userProperties.setLogin(login);
        userProperties.setPassword(password);
        userRepository.save(userProperties);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<UserProperties> getAllUsers() {
        return userRepository.findAll();
    }
}
