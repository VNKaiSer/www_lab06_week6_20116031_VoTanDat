package com.example.blogwebsitespirng.services;

import com.example.blogwebsitespirng.models.PostComment;

public interface CommentService {
    PostComment save(PostComment comment);

    void delete(PostComment comment);
}
