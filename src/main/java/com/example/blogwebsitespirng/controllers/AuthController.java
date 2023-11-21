package com.example.blogwebsitespirng.controllers;

import com.example.blogwebsitespirng.helper.AuthHelper;
import com.example.blogwebsitespirng.models.User;
import com.example.blogwebsitespirng.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
@Controller
@ComponentScan(basePackages = "com.example.blogwebsitespirng")
public class AuthController {
    @Autowired private AuthService authService;
    @GetMapping("/login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/";
        } else {
            return "login";
        }
    }

    @GetMapping("/signup")
    public String register() {
        return "registerForm";
    }

    @PostMapping("/signup")
    public String register(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "mobile") String mobile,
                           HttpServletRequest request,
                           Model model) {

        User user = new User(username, mobile,email, password);
        try {
            authService.userRegister(user);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "registerForm";
        }
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        HttpServletRequest request) {

        if (authService.userLogin(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogin", true);
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }
}
