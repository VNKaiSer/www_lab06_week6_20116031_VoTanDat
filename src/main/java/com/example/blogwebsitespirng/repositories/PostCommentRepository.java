package com.example.blogwebsitespirng.repositories;

import com.example.blogwebsitespirng.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends JpaRepository <PostComment, Long> {
}
