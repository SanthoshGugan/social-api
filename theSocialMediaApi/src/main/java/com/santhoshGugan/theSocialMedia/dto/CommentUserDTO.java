package com.santhoshGugan.theSocialMedia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.santhoshGugan.theSocialMedia.models.Comment;
import com.santhoshGugan.theSocialMedia.models.User;
import org.springframework.data.annotation.Id;

public class CommentUserDTO {

    @Id
    private String id;

    @JsonProperty("parent_id")
    private String parentId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("author_id")
    private String authorId;

    @JsonProperty("author_name")
    private String authorName;

    @JsonProperty("author_profile_dp_url")
    private String authorProfileDpUrl;

    public CommentUserDTO(String id, String parentId, String content, String authorId, String authorName, String authorProfileDpUrl) {
        this.id = id;
        this.parentId = parentId;
        this.content = content;
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorProfileDpUrl = authorProfileDpUrl;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorProfileDpUrl() {
        return authorProfileDpUrl;
    }

    public void setAuthorProfileDpUrl(String authorProfileDpUrl) {
        this.authorProfileDpUrl = authorProfileDpUrl;
    }

    public static CommentUserDTO convert(
            final Comment comment,
            final User user
    ) {
        return new CommentUserDTO(
                comment.getId(),
                comment.getParentId(),
                comment.getContent(),
                comment.getAuthorId(),
                user.getName(),
                user.getProfileDpUrl()
        );
    }
}
