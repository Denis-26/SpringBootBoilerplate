package com.dockerspring.test.controller;

import com.dockerspring.test.entity.TestEntity;
import com.dockerspring.test.entity.User;
import com.dockerspring.test.service.ITestService;
import com.dockerspring.test.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
final class SecuredUsersController {

    private UserAuthenticationService authentication;
    private ITestService testService;

    @Autowired
    public SecuredUsersController(UserAuthenticationService authentication, ITestService testService) {
        this.authentication = authentication;
        this.testService = testService;
    }

    @PostMapping("/current")
    User getCurrent(Authentication authentication) {
        return (User)authentication.getPrincipal();
    }

    @PostMapping("/testInfo")
    List<TestEntity> getTestInfo() {
        return testService.getAll();
    }

    @PostMapping("/logout")
    boolean logout(@AuthenticationPrincipal final User user) {
        authentication.logout(user);
        return true;
    }
}
