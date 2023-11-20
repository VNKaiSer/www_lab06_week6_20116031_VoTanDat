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
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean published;

    @OneToMany
    @JoinColumn(name = "post_id")
    private Set<PostComment> postComments;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post parent;

    @Column(name = "meta_title")
    private String metaTitle;
    private String summary;
    @Column(name = "created_at")
    private Instant createdAt;
    @OneToMany
    @JoinColumn(name = "post_id")
    private Set<Post> posts;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @JoinColumn(name = "update_at")
    private Instant updateAt;
    @JoinColumn(name = "published_at")
    private Instant publishedAt;

}
