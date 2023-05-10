package com.santhoshGugan.theSocialMedia.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.santhoshGugan.theSocialMedia.models.Like;

public class LikeByUserAndPost {

    @JsonProperty("userLiked")
    private boolean userLiked;

    @JsonProperty("like")
    private Like like;

    public LikeByUserAndPost(boolean userLiked, Like like) {
        this.userLiked = userLiked;
        this.like = like;
    }

    public boolean isUserLiked() {
        return userLiked;
    }

    public void setUserLiked(boolean userLiked) {
        this.userLiked = userLiked;
    }

    public Like getLike() {
        return like;
    }

    public void setLike(Like like) {
        this.like = like;
    }
}
