package com.wolfkill.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChameleonController {
    @Autowired
    private UserRepository userRepository;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/inform")
    public ChameleonResponse greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new ChameleonResponse(counter.incrementAndGet(), String.format(template, name));
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
