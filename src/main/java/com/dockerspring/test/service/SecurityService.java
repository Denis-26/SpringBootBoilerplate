package com.dockerspring.test.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityService {

    String findLoggedInUsername();

    UserDetails autoLogin(String username, String password);

}
