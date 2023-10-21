package com.example.blogwebsitespirng.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "post_comments")
public class PostComment {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private Set<PostComment> postComments;
    private String title;
    private String content;
    private Boolean published;
    @Column(name= "published_at")
    private Instant publishedAt;
    @Column(name= "created_at")
    private Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PostComment parentComment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
