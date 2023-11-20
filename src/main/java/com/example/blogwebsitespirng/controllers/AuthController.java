package com.example.blogwebsitespirng.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
@Controller
@ComponentScan(basePackages = "com.example.blogwebsitespirng")
public class AuthController {
    @GetMapping("/login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/";
        } else {
            return "login";
        }
    }
}
