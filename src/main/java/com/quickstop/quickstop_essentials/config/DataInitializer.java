package com.quickstop.quickstop_essentials.config;

import com.quickstop.quickstop_essentials.model.Role;
import com.quickstop.quickstop_essentials.model.User;
import com.quickstop.quickstop_essentials.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        createUserIfMissing(
                "QuickStop Administrator",
                "admin@quickstop.ca",
                "Admin123!",
                Role.ADMIN
        );

        createUserIfMissing(
                "QuickStop Staff",
                "staff@quickstop.ca",
                "Staff123!",
                Role.STAFF
        );
    }

    private void createUserIfMissing(
            String fullName,
            String email,
            String rawPassword,
            Role role
    ) {

        if (!userRepository.existsByEmail(email)) {

            User user = new User(
                    fullName,
                    email,
                    passwordEncoder.encode(rawPassword),
                    role
            );

            userRepository.save(user);
        }
    }
}