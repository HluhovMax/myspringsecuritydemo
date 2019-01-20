package com.example.myspringsecuritydemo.repository;

import com.example.myspringsecuritydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
