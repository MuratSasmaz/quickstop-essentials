package com.quickstop.quickstop_essentials.config;

import jakarta.servlet.DispatcherType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth

                        // Allow Spring MVC and error pages to render.
                        .dispatcherTypeMatchers(
                                DispatcherType.FORWARD,
                                DispatcherType.ERROR
                        ).permitAll()

                        // Public pages and static files.
                        .requestMatchers(
                                "/",
                                "/about",
                                "/locations",
                                "/login",
                                "/register",
                                "/access-denied",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/favicon.ico"
                        ).permitAll()

                        // ADMIN-only area.
                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")

                        // Only ADMIN can delete products.
                        .requestMatchers(
                                HttpMethod.POST,
                                "/products/*/delete"
                        ).hasRole("ADMIN")

                        // STAFF and ADMIN can open edit/add pages.
                        .requestMatchers(
                                HttpMethod.GET,
                                "/products/new",
                                "/products/*/edit"
                        ).hasAnyRole("STAFF", "ADMIN")

                        // STAFF and ADMIN can create or update products.
                        .requestMatchers(
                                HttpMethod.POST,
                                "/products",
                                "/products/*/edit"
                        ).hasAnyRole("STAFF", "ADMIN")

                        // All registered roles can view products.
                        .requestMatchers(
                                HttpMethod.GET,
                                "/products",
                                "/products/*"
                        ).hasAnyRole(
                                "CUSTOMER",
                                "STAFF",
                                "ADMIN"
                        )

                        // Any remaining route requires login.
                        .anyRequest()
                        .authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error")
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
                )

                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/access-denied")
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}