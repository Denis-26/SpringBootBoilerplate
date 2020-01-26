package com.dockerspring.test.service;

import com.dockerspring.test.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
final class InMemoryUsers implements UserCrudService {

    private Map<String, User> users = new HashMap<>();

    @Override
    public User save(final User user) {
        return users.put(user.getUsername(), user);
    }

    @Override
    public Boolean remove(final User user) {
        return users.remove(user.getUsername(), user);
    }

    @Override
    public Optional<User> find(final String id) {
        return ofNullable(users.get(id));
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        return users
                .values()
                .stream()
                .filter(u -> Objects.equals(username, u.getUsername()))
                .findFirst();
    }

}
