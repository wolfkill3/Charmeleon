package com.wolfkill.charmeleon.application.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserProperties, Integer> {
}
