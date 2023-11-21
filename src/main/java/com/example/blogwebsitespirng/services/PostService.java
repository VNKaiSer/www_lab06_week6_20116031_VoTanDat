package com.example.blogwebsitespirng.services;

import com.example.blogwebsitespirng.models.Post;

import java.util.Optional;

public interface PostService {
    boolean insertPost(Post post);
    Optional<Post> getPostById(long id);

}
