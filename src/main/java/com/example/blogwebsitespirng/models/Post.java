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
    @Column(name = "content", columnDefinition = "TEXT")
    private  String content;

    public Post() {
    }

    public Post(boolean published, String metaTitle, String summary, String title, User author, String content) {
        this.published = published;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.createdAt = Instant.now();
        this.title = title;
        this.author = author;
        this.updateAt = Instant.now();
        this.publishedAt = Instant.now();
        this.content = content;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Set<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(Set<PostComment> postComments) {
        this.postComments = postComments;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
