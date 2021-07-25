package com.wolfkill.charmeleon.application.controller;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CharmeleonApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CharmeleonApplication.class);
        application.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        application.run(args);
    }

}
