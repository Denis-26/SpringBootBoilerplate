package com.dockerspring.test.service;

import com.dockerspring.test.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
