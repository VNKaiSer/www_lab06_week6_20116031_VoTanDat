package com.example.blogwebsitespirng.services.impl;

import com.example.blogwebsitespirng.models.Post;
import com.example.blogwebsitespirng.repositories.PostRepository;
import com.example.blogwebsitespirng.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServicesImpl implements PostService {
    @Autowired private PostRepository postRepository;
    @Override
    public boolean insertPost(Post post) {
        postRepository.save(post);
        return true;
    }

    @Override
    public Optional<Post> getPostById(long id) {
        return postRepository.findById(id);
    }
}
