package com.wolfkill.charmeleon;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserProperties, Integer> {
}
