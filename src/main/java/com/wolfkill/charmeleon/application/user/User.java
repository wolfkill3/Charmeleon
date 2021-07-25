package com.wolfkill.charmeleon.application.user;

import com.wolfkill.charmeleon.application.user.properties.UserAccess;
import com.wolfkill.charmeleon.application.controller.db.UserData;

public class User {
    private final UserData userData;
    private final UserAccess userAccess;

    public User(final UserData userData, final UserAccess userAccess) {
        this.userData = userData;
        this.userAccess = userAccess;
    }

    public UserData getUserData() {
        return userData;
    }

    public UserAccess getUserAccess() {
        return userAccess;
    }
}
