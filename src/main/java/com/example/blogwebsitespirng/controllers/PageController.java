package com.example.blogwebsitespirng.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/createNewPost")
    public String createNewPost(Model model) {

        // Just curious  what if we get username from Principal instead of SecurityContext
        String authUsername = "anonymousUser";

//        Optional<BlogUser> optionalBlogUser = this.blogUserService.findByUsername(authUsername);
//        // set user to post and put former in model
//        if (optionalBlogUser.isPresent()) {
//            Post post = new Post();
//            post.setUser(optionalBlogUser.get());
//            model.addAttribute("post", post);
//            return "postForm";
//        } else {
//            return "error";
//        }
    }
}
