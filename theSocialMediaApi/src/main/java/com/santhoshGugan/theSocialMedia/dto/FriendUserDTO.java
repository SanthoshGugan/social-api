package com.santhoshGugan.theSocialMedia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.santhoshGugan.theSocialMedia.models.Friend;
import com.santhoshGugan.theSocialMedia.models.User;
import org.springframework.data.annotation.Id;

public class FriendUserDTO {

    @Id
    private String id;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("friend_id")
    private String friendId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_profile_dp_url")
    private String userProfileDpUrl;

    @JsonProperty("friend_name")
    private String friendName;

    @JsonProperty("friend_profile_dp_url")
    private String friendProfileDpUrl;

    public FriendUserDTO(String id, String userId, String friendId, String userName, String userProfileDpUrl, String friendName, String friendProfileDpUrl) {
        this.id = id;
        this.userId = userId;
        this.friendId = friendId;
        this.userName = userName;
        this.userProfileDpUrl = userProfileDpUrl;
        this.friendName = friendName;
        this.friendProfileDpUrl = friendProfileDpUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfileDpUrl() {
        return userProfileDpUrl;
    }

    public void setUserProfileDpUrl(String userProfileDpUrl) {
        this.userProfileDpUrl = userProfileDpUrl;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendProfileDpUrl() {
        return friendProfileDpUrl;
    }

    public void setFriendProfileDpUrl(String friendProfileDpUrl) {
        this.friendProfileDpUrl = friendProfileDpUrl;
    }

    public static FriendUserDTO convert(final Friend friend,  final User user, final User connectedUser) {
        return new FriendUserDTO(
                friend.getId(),
                user.getId(),
                connectedUser.getId(),
                user.getName(),
                user.getProfileDpUrl(),
                connectedUser.getName(),
                connectedUser.getProfileDpUrl()
        );
    }
}

