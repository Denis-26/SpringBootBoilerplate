package com.dockerspring.test.controller;

import com.dockerspring.test.entity.User;
import com.dockerspring.test.service.UserAuthenticationService;
import com.dockerspring.test.service.UserCrudService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
final class PublicUsersController {

    private UserAuthenticationService authentication;
    private UserCrudService users;

    PublicUsersController(UserAuthenticationService authentication, UserCrudService users) {
        this.authentication = authentication;
        this.users = users;
    }

    @PostMapping("/register")
    String register(@RequestParam("username") final String username, @RequestParam("password") final String password) {
        users
                .save(User
                        .builder()
                        .id(username)
                        .username(username)
                        .password(password)
                        .build()
                );

        return login(username, password);
    }

    @PostMapping("/login")
    String login(@RequestParam("username") final String username, @RequestParam("password") final String password) {
        return authentication
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }
}
