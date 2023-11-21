package com.example.blogwebsitespirng.services.impl;

import com.example.blogwebsitespirng.helper.AuthHelper;
import com.example.blogwebsitespirng.models.User;
import com.example.blogwebsitespirng.repositories.UserRepository;
import com.example.blogwebsitespirng.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired private UserRepository userRepository;
    @Override
    public boolean userLogin(String email, String password) {
        Optional<User> user = userRepository.findUserByMobile(email);
        Optional<User> mobile = userRepository.findUserByEmail(email);
        if (user.isPresent() && AuthHelper.verifyPassword(password, user.get().getPasswordHash()) ||
                mobile.isPresent() && AuthHelper.verifyPassword(password, mobile.get().getPasswordHash())) {
            return true;
        }
        return false;
    }

    public boolean userRegister(User user) throws Exception {
        if (userRepository.existsUserByMobile(user.getMobile()) || userRepository.existsUserByEmail(user.getEmail())) {
            throw new Exception("Phone or email already exists");
        }
        String passWordHash = AuthHelper.hashPassword(user.getPasswordHash());
        user.setPasswordHash(passWordHash);
        user.setRegisterAt(Instant.now());
        userRepository.save(user);
        return true;
    }
}
