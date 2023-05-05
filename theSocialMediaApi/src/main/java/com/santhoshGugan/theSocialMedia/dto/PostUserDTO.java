package com.santhoshGugan.theSocialMedia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.santhoshGugan.theSocialMedia.models.Post;
import com.santhoshGugan.theSocialMedia.models.User;
import org.springframework.data.annotation.Id;

public class PostUserDTO {
    @Id
    private String id;

    private String content;

    private String imageUrl;

    @JsonProperty("authorId")
    private String authorId;

    private int likes;

    @JsonProperty("authorName")
    private String authorName;

    public PostUserDTO(String id, String content, String imageUrl, String authorId, int likes, String authorName) {
        this.id = id;
        this.content = content;
        this.imageUrl = imageUrl;
        this.authorId = authorId;
        this.likes = likes;
        this.authorName = authorName;
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

    public String getId() {
        return id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public static PostUserDTO convert(final Post post,
                               final User user) {
        return new PostUserDTO(
                post.getId(),
                post.getContent(),
                post.getImageUrl(),
                user.getId(),
                post.getLikes(),
                user.getName()
        );
    }
}

