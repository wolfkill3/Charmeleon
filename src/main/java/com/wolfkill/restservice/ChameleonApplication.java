package com.wolfkill.restservice;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChameleonApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ChameleonApplication.class);
        application.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        application.run(args);
    }

}
