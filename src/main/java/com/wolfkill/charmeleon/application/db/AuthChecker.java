package com.wolfkill.charmeleon.application.db;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.wolfkill.charmeleon.application.CharmeleonAuthResponse;
import com.wolfkill.charmeleon.application.user.UserProperties;
import com.wolfkill.charmeleon.application.user.UserRepository;

public class AuthChecker {
    private static Logger logger = Logger.getLogger(AuthChecker.class.getName());

    public static UserProperties checkAuthResponse(CharmeleonAuthResponse authResponse, UserRepository userRepository) {
        UserProperties user = null;
        for (UserProperties userProperties : userRepository.findAll()) {
            if (authResponse.getLogin().equals(userProperties.getLogin())
                && authResponse.getPassword().equals(userProperties.getPassword())) {
                user = userProperties;
            }
        }
        if (user != null) {
            logger.info("Пользователь найден");
        } else {
            logger.log(Level.WARNING, "Пользователь не найден");
        }
        return user;
    }
}
