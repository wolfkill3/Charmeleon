package com.wolfkill.charmeleon.application.db;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.wolfkill.charmeleon.application.CharmeleonLoginProperties;
import com.wolfkill.charmeleon.application.ResponseStatus;
import com.wolfkill.charmeleon.application.user.UserData;
import com.wolfkill.charmeleon.application.user.UserProperties;
import com.wolfkill.charmeleon.application.user.UserRepository;

public class AuthChecker {
    private static Logger logger = Logger.getLogger(AuthChecker.class.getName());

    public static UserProperties checkAuthResponse(CharmeleonLoginProperties loginProperties, UserRepository userRepository) {
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

    public static UserProperties checkRegistrationResponse(UserData userData, UserRepository userRepository) {
        UserProperties userProperties = new UserProperties();
        CharmeleonLoginProperties loginProperties = new CharmeleonLoginProperties(userData.getLogin(), userData.getPassword());
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
        for (UserData userData : userRepository.findAll()) {
            if (loginProperties.getLogin().equals(userData.getLogin())
                && loginProperties.getPassword().equals(userData.getPassword())) {
                System.out.println("найден");
                return userData;
            }
        }
        return null;
    }
}
