package com.dockerspring.test.config;

import com.dockerspring.test.entity.User;
import com.dockerspring.test.service.UserAuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@AllArgsConstructor
public class MyAuthenticationProvider implements AuthenticationProvider {

    private BCryptPasswordEncoder passwordEncoder;
    private final UserAuthenticationService authenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException, UsernameNotFoundException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        User loadedUser = authenticationService.findByUserName(auth.getPrincipal().toString())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String presentedPassword = authentication.getCredentials().toString();

        if (!passwordEncoder.matches(presentedPassword, loadedUser.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }

        String password = authentication.getCredentials().toString();

        return new UsernamePasswordAuthenticationToken(loadedUser, password, Collections.emptyList());
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
