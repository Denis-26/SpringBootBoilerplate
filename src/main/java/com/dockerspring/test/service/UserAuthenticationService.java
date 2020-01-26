package com.dockerspring.test.service;

import com.dockerspring.test.entity.User;

import java.util.Optional;

public interface UserAuthenticationService {

    Optional<String> login(String username, String password);

    Optional<User> findByUserName(String token);

    void logout(User user);

}
