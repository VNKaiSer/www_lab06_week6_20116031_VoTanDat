package com.example.blogwebsitespirng.controllers;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String home(HttpServletRequest request) {
        boolean isLogin = request.getSession().getAttribute("isLogin") == null;
        if (isLogin) {
            return "login";
        }
        return "home";
    }


}

