package com.wolfkill.charmeleon.application.controller.db;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.wolfkill.charmeleon.application.controller.CharmeleonLoginProperties;
import com.wolfkill.charmeleon.application.controller.ResponseStatus;
import com.wolfkill.charmeleon.application.user.User;
import com.wolfkill.charmeleon.application.user.properties.UserProperties;

public class AuthChecker {
    private static Logger logger = Logger.getLogger(AuthChecker.class.getName());

    public static UserProperties checkAuthResponse(CharmeleonLoginProperties loginProperties,
                                                   UserRepository userRepository) {
        UserProperties userProperties = new UserProperties();
        userProperties.userData = findUser(loginProperties, userRepository);
        if (userProperties.userData != null) {
            logger.info("Пользователь найден");
            userProperties.responseStatus = ResponseStatus.CONFIRMED;
        } else {
            logger.log(Level.WARNING, "Пользователь не найден");
            userProperties.responseStatus = ResponseStatus.NOT_CONFIRMED;
        }
        return userProperties;
    }

    public static UserProperties checkRegistrationResponse(User user, UserRepository userRepository) {
        UserProperties userProperties = new UserProperties();
        CharmeleonLoginProperties loginProperties = new CharmeleonLoginProperties(user.getUserData().getLogin(), user.getUserData().getPassword());
        userProperties.userData = findUser(loginProperties, userRepository);
        if (userProperties.userData != null) {
            logger.info("Пользователь найден");
            userProperties.responseStatus = ResponseStatus.USED;
        } else {
            logger.log(Level.WARNING, "Пользователь не найден");
            userProperties.responseStatus = ResponseStatus.NOT_USED;
        }
        return userProperties;
    }

    private static UserData findUser(final CharmeleonLoginProperties loginProperties, final UserRepository userRepository) {
        for (UserData user : userRepository.findAll()) {
            if (loginProperties.getLogin().equals(user.getLogin())
                && loginProperties.getPassword().equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
