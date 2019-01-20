package com.example.myspringsecuritydemo.service;

import com.example.myspringsecuritydemo.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
