package com.santhoshGugan.theSocialMedia.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Friend")
public class Friend {
    @Id
    private String id;

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("friend_id")
    private String friendId;

    public Friend(String id, String friendId) {
        this.id = id;
        this.friendId = friendId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
