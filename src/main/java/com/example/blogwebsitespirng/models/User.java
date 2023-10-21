package com.example.blogwebsitespirng.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long Id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "middle_name", length = 50)
    private String middleName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    private String mobie;
    private String email;
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    @Column(name = "register_at")
    private Instant registerAt;
    @Column(name = "last_login")
    private Instant lastLogin;
    private String intro;
    private String profile;




}
