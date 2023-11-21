package com.example.blogwebsitespirng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.blogwebsitespirng.models")
public class BlogWebsiteSpirngApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogWebsiteSpirngApplication.class, args);
    }

}
