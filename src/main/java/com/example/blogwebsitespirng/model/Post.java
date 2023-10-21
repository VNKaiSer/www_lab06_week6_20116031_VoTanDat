package com.example.blogwebsitespirng.model;

import jakarta.persistence.*;

@Entity
public class Post {
    @jakarta.persistence.Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

//    private
}
