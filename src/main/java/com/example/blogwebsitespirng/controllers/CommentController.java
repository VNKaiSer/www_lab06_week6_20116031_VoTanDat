package com.example.blogwebsitespirng.controllers;

import com.example.blogwebsitespirng.models.Post;
import com.example.blogwebsitespirng.models.PostComment;
import com.example.blogwebsitespirng.models.User;
import com.example.blogwebsitespirng.services.CommentService;
import com.example.blogwebsitespirng.services.PostService;
import com.example.blogwebsitespirng.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.time.Instant;
import java.util.Optional;

@Controller
public class CommentController {
    @Autowired private CommentService commentService;
    @Autowired private PostService postService;
    @Autowired private UserService userService;


    @GetMapping("/comment/{id}")
    public String showComment(@PathVariable Long id, Model model, HttpSession session) {

        String authUsername = "anonymousUser";
        User principal = (User) session.getAttribute("user");
        if (principal != null) {
            authUsername = principal.getFirstName();
        }


        // find post by id
        Optional<Post> postOptional = this.postService.getPostById(id);
        // if both optionals is present set user and post to a new comment and put former in the model
        if (postOptional.isPresent() && principal!= null) {
            PostComment comment = new PostComment();
            comment.setPost(postOptional.get());
            comment.setUser(principal);
            model.addAttribute("comment", comment);
            session.setAttribute("comment", comment);
            System.err.println("GET comment/{id}: " + comment + "/" + id); // for testing debugging purposes
            return "commentForm";
        } else {
            System.err.println("Could not find a post by id: " + id + " or user by logged in username: " + authUsername); // for testing debugging purposes
            return "error";
        }
    }


    @PostMapping("/comment")
    public String validateComment(@ModelAttribute PostComment comment, BindingResult bindingResult, SessionStatus sessionStatus, HttpSession session) {
        System.err.println("POST comment: " + comment); // for testing debugging purposes
        if (bindingResult.hasErrors()) {
            System.err.println("Comment did not validate");
            return "commentForm";
        } else {
            PostComment savedComment = session.getAttribute("comment") != null ? (PostComment) session.getAttribute("comment") : null;
            session.removeAttribute("comment");
            savedComment.setContent(comment.getContent());
            savedComment.setCreatedAt(Instant.now());
            savedComment.setPublished(true);
            savedComment.setPublishedAt(Instant.now());
            this.commentService.save(savedComment);
            System.err.println("SAVE comment: " + savedComment); // for testing debugging purposes
            sessionStatus.setComplete();
            return "redirect:/post/" + savedComment.getPost().getId();
        }
    }
}
