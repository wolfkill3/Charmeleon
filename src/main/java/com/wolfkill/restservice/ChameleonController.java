package com.wolfkill.restservice;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ChameleonController {
    @Autowired
    private UserRepository userRepository;
    private Logger logger = Logger.getLogger(ChameleonController.class.getName());

    @PostMapping("/auth")
    public ChameleonAuthResponse authResponse(
        @RequestParam(value = "login") String login,
        @RequestParam(value = "password") String password) {
        logger.info("login = " + login);
        logger.info("password = " + password);
        return new ChameleonAuthResponse(login, password);
    }

    @PostMapping("/auth-config")
    public ChameleonAuthResponse authResponseConfig(
        @RequestParam(required = false, value = "login") String login,
        @RequestParam(required = false, value = "password") String password) {
        return new ChameleonAuthResponse(login, password);
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
