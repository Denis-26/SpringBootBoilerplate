package com.dockerspring.test.service;

import com.dockerspring.test.entity.User;

import java.util.Optional;

public interface UserCrudService {

    User save(User user);

    Optional<User> find(String id);

    Optional<User> findByUsername(String username);

}
