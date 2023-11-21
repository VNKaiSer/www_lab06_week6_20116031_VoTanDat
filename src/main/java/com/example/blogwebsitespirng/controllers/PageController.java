package com.example.blogwebsitespirng.controllers;

import com.example.blogwebsitespirng.models.Post;
import com.example.blogwebsitespirng.services.PostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class PageController {
    @Autowired private PostService postService;
    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        boolean isLogin = request.getSession().getAttribute("isLogin") == null;
        if (isLogin) {
            return "login";
        }
        Collection<Post> posts = this.postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "home";
    }


}

