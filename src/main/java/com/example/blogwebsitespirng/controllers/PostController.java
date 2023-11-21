package com.example.blogwebsitespirng.controllers;

import com.example.blogwebsitespirng.models.Post;
import com.example.blogwebsitespirng.models.User;
import com.example.blogwebsitespirng.services.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.time.Instant;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired private PostService postService;
    @GetMapping("/createNewPost")
    public String createNewPost(HttpSession session , Model model) {
        boolean isLogin = session.getAttribute("isLogin") == null;
        if (isLogin) {
            return "redirect:/login";
        }

        Post post = new Post();
        post.setAuthor((User) session.getAttribute("user"));
        model.addAttribute("post", post);
        return "postForm";
    }

    @PostMapping("/createNewPost")
    public String createNewPost(@ModelAttribute Post post, SessionStatus sessionStatus, HttpSession session) {
        System.err.println("POST post: " + post);
        if (post == null) {
            System.err.println("Post did not validate");
            return "postForm";
        }
        post.setAuthor((User) session.getAttribute("user"));
        post.setCreatedAt(Instant.now());
        post.setPublishedAt(Instant.now());
        post.setUpdateAt(Instant.now());
        this.postService.insertPost(post);
        System.err.println("SAVE post: " + post);
        sessionStatus.setComplete();
        return "redirect:/post/" + post.getId();
    }

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Model model, HttpSession session) {

        String authUsername = "anonymousUser";
        User user = (User) session.getAttribute("user");
        if (user != null) {
            authUsername = user.getFirstName();
        }

        Optional<Post> optionalPost = this.postService.getPostById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            if (authUsername.equals(post.getAuthor().getFirstName())) {
                model.addAttribute("isOwner", true);
            }
            return "post";
        } else {
            return "404";
        }
    }

    @GetMapping("editPost/{id}")
    public String editPost(@PathVariable Long id, Model model, HttpSession session) {
        String authUsername = "anonymousUser";
        User user = (User) session.getAttribute("user");
        if (user != null) {
            authUsername = user.getFirstName();
        }

        Optional<Post> optionalPost = this.postService.getPostById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            // Check if current logged in user is owner
            if (authUsername.equals(post.getAuthor().getFirstName())) {
                model.addAttribute("post", post);
                System.err.println("EDIT post: " + post); // for testing debugging purposes
                return "postForm";
            } else {
                System.err.println("Current User has no permissions to edit anything on post by id: " + id); // for testing debugging purposes
                return "403";
            }
        } else {
            System.err.println("Could not find a post by id: " + id);
            return "error";
        }
    }

    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable Long id, HttpSession session) {

        String authUsername = "anonymousUser";
        User user = (User) session.getAttribute("user");
        if (user != null) {
            authUsername = user.getFirstName();
        }

        Optional<Post> optionalPost = this.postService.getPostById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            // Check if current logged in user is owner
            if (authUsername.equals(post.getAuthor().getFirstName())) {
                // if so then it is safe to remove post from database
                this.postService.deletePost(post);
                System.err.println("DELETED post: " + post); // for testing debugging purposes
                return "redirect:/";
            } else {
                System.err.println("Current User has no permissions to edit anything on post by id: " + id); // for testing debugging purposes
                return "403";
            }
        } else {
            System.err.println("Could not find a post by id: " + id); // for testing debugging purposes
            return "error";
        }
    }

}
