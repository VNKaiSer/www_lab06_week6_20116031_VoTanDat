package com.example.blogwebsitespirng.services.impl;

import com.example.blogwebsitespirng.models.PostComment;
import com.example.blogwebsitespirng.repositories.PostCommentRepository;
import com.example.blogwebsitespirng.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired private PostCommentRepository postCommentRepository;
    @Override
    public PostComment save(PostComment comment) {
        return postCommentRepository.save(comment);
    }

    @Override
    public void delete(PostComment comment) {
        postCommentRepository.delete(comment);
    }
}
