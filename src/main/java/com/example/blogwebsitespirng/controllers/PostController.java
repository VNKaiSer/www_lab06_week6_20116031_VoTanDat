package com.example.blogwebsitespirng.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    @GetMapping("/createNewPost")
    public String createNewPost(HttpSession session) {
        boolean isLogin = session.getAttribute("isLogin") == null;
        if (isLogin) {
            return "redirect:/login";
        }
        return "postForm";
    }
}
