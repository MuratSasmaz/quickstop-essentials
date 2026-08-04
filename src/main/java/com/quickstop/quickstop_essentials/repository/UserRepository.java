package com.quickstop.quickstop_essentials.repository;

import com.quickstop.quickstop_essentials.model.Role;
import com.quickstop.quickstop_essentials.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    long countByRole(Role role);

    List<User> findAllByOrderByCreatedAtDesc();
}