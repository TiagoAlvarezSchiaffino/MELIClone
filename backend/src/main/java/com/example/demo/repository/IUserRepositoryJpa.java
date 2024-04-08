package com.example.demo.repository;

import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepositoryJpa extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(Integer id);
}