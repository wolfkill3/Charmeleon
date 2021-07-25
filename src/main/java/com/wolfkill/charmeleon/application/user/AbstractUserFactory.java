package com.wolfkill.charmeleon.application.user;

import com.wolfkill.charmeleon.application.controller.db.UserData;

public interface AbstractUserFactory {
    default User createUser(UserData userData) {
        return null;
    }
}
