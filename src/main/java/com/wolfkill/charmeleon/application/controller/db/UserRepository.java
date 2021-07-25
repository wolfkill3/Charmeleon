package com.wolfkill.charmeleon.application.controller.db;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData, Integer> {
}
