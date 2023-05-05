package com.santhoshGugan.theSocialMedia.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Post")
public class Post {
    @Id
    private String id;

    @JsonProperty("authorId")
    private String authorId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("likes")
    private int likes;

    public Post(String id, String authorId, String content, String imageUrl) {
        this.id = id;
        this.authorId = authorId;
        this.content = content;
        this.imageUrl = imageUrl;
        this.likes = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
