package com.example.blogwebsitespirng.services.impl;

import com.example.blogwebsitespirng.models.User;
import com.example.blogwebsitespirng.repositories.UserRepository;
import com.example.blogwebsitespirng.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired private UserRepository userRepository;

    @Override
    public Optional<User> findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
    @Override
    public Optional<User> findUserByMobile(String mobile){
        return userRepository.findUserByMobile(mobile);
    }

    @Override
    public Optional<User> findByUsername(String authUsername) {
        return userRepository.findUserByFirstName(authUsername);
    }
}
