package com.example.blogwebsitespirng.services;

import com.example.blogwebsitespirng.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByMobile(String mobile);

    Optional<User> findByUsername(String authUsername);
}
