package com.wolfkill.restservice;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserProperties, Integer> {
}
