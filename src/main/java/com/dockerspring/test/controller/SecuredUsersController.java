package com.dockerspring.test.controller;

import com.dockerspring.test.entity.User;
import com.dockerspring.test.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
final class SecuredUsersController {

    private UserAuthenticationService authentication;

    @Autowired
    public SecuredUsersController(UserAuthenticationService authentication) {
        this.authentication = authentication;
    }

    @GetMapping("/current")
    User getCurrent(@AuthenticationPrincipal final User user) {
        return user;
    }

    @GetMapping("/logout")
    boolean logout(@AuthenticationPrincipal final User user) {
        authentication.logout(user);
        return true;
    }
}
