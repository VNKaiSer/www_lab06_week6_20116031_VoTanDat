package com.example.blogwebsitespirng.repositories;

import com.example.blogwebsitespirng.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Post> {
}
