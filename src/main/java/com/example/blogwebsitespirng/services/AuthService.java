package com.example.blogwebsitespirng.services;

import com.example.blogwebsitespirng.models.User;

public interface AuthService {
    boolean userLogin(String email, String password);
    boolean userRegister(User user) throws Exception;
}
