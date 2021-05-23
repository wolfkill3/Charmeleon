package com.wolfkill.charmeleon;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CharmeleonApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CharmeleonApplication.class);
        application.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        application.run(args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/auth-config").allowedOrigins("http://localhost:8083");
            }
        };
    }

}
