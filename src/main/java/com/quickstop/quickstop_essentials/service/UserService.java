package com.quickstop.quickstop_essentials.service;

import com.quickstop.quickstop_essentials.model.Role;
import com.quickstop.quickstop_essentials.model.User;
import com.quickstop.quickstop_essentials.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {

        user.setEmail(
                user.getEmail().trim().toLowerCase()
        );

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        // Users who register through the public form
        // must always receive the CUSTOMER role.
        user.setRole(Role.CUSTOMER);

        return userRepository.save(user);
    }

    public boolean emailExists(String email) {

        if (email == null || email.isBlank()) {
            return false;
        }

        return userRepository.existsByEmail(
                email.trim().toLowerCase()
        );
    }
}