package com.wolfkill.charmeleon.application.db;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.wolfkill.charmeleon.application.CharmeleonAuthResponse;
import com.wolfkill.charmeleon.application.ResponseStatus;
import com.wolfkill.charmeleon.application.user.UserData;
import com.wolfkill.charmeleon.application.user.UserProperties;
import com.wolfkill.charmeleon.application.user.UserRepository;

public class AuthChecker {
    private static Logger logger = Logger.getLogger(AuthChecker.class.getName());

    public static UserProperties checkAuthResponse(CharmeleonAuthResponse authResponse, UserRepository userRepository) {
        UserProperties userProperties = new UserProperties();
        for (UserData userData : userRepository.findAll()) {
            if (authResponse.getLogin().equals(userData.getLogin())
                && authResponse.getPassword().equals(userData.getPassword())) {
                userProperties.userData = userData;
            }
        }
        if (userProperties.userData != null) {
            logger.info("Пользователь найден");
            userProperties.responseStatus = ResponseStatus.CONFIRMED;
        } else {
            logger.log(Level.WARNING, "Пользователь не найден");
            userProperties.responseStatus = ResponseStatus.NOT_CONFIRMED;
        }
        return userProperties;
    }
}
