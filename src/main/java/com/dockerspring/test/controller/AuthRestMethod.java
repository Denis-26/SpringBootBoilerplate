package com.dockerspring.test.controller;

import com.dockerspring.test.dto.UserDto;
import com.dockerspring.test.entity.User;
import com.dockerspring.test.service.SecurityService;
import com.dockerspring.test.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/rest/api")
public class AuthRestMethod {

    @Resource
    private UserService userService;

    @Resource
    private SecurityService securityService;

    @PostMapping("/sign_in")
    public UserDto sign_in(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserDetails userDetails = securityService.autoLogin(username, password);
        UserDto newUser = new UserDto();
        newUser.setUsername(userDetails.getUsername());

        return newUser;
    }

    @PostMapping("/sign_up")
    public UserDto sign_up(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userService.save(user);
        UserDetails userDetails = securityService.autoLogin(username, password);

        UserDto newUser = new UserDto();
        newUser.setUsername(userDetails.getUsername());

        return newUser;
    }

    @GetMapping(value="/signOut")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }
}
