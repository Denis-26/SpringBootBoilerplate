package com.dockerspring.test.service;

import com.dockerspring.test.entity.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class UUIDAuthenticationService implements UserAuthenticationService {

    @NonNull UserCrudService users;
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public Optional<String> login(final String username, final String password) {
        final String uuid = UUID.randomUUID().toString();
        final User user = User
                .builder()
                .id(uuid)
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();

        users.save(user);
        return Optional.of(uuid);
    }

    @Override
    public Optional<User> findByUserName(final String username) {
        return users.find(username);
    }

    @Override
    public void logout(final User user) {
        users.remove(user);
    }
}
