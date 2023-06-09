package com.santhoshGugan.theSocialMedia.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

    @Id
    private String id;
    private String name;
    private String profileDpUrl;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileDpUrl() {
        return profileDpUrl;
    }

    public void setProfileDpUrl(String profileDpUrl) {
        this.profileDpUrl = profileDpUrl;
    }
}
