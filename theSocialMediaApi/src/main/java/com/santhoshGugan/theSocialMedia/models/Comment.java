package com.santhoshGugan.theSocialMedia.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
public class Comment {
    @Id
    private String id;
    @JsonProperty("parent_id")
    private String parentId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("author_id")
    private String authorId;

    public Comment(String id, String parentId, String authorId , String content) {
        this.id = id;
        this.parentId = parentId;
        this.content = content;
        this.authorId = authorId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
