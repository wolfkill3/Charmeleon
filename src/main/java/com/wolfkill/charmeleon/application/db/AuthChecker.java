package com.wolfkill.charmeleon.application.db;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.wolfkill.charmeleon.application.CharmeleonAuthResponse;
import com.wolfkill.charmeleon.application.user.UserRepository;

public class AuthChecker {
    private static Logger logger = Logger.getLogger(AuthChecker.class.getName());

    public static boolean checkAuthResponse(CharmeleonAuthResponse authResponse, UserRepository userRepository) {
        AtomicBoolean returnStatus = new AtomicBoolean(false);
        userRepository.findAll().forEach(userProperties -> {
            if (authResponse.getLogin().equals(userProperties.getLogin())
                && authResponse.getPassword().equals(userProperties.getPassword())) {
                returnStatus.set(true);
            }
        });
        if (returnStatus.get()){
            logger.info("Пользователь найден");
        } else {
            logger.log(Level.WARNING,"Пользователь не найден");
        }
        return returnStatus.get();
    }
}
