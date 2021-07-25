package com.wolfkill.charmeleon.application.user;

import com.wolfkill.charmeleon.application.user.properties.UserAccess;
import com.wolfkill.charmeleon.application.controller.db.UserData;

public class UserFactory implements AbstractUserFactory {
    private UserAccess userAccess;

    public UserFactory(final UserAccess userAccess) {
        this.userAccess = userAccess;
    }

    @Override
    public User createUser(UserData userData) {
        User user = new User(userData, userAccess);
        return user;
    }
}
