package com.santhoshGugan.theSocialMedia.repository;

import com.santhoshGugan.theSocialMedia.models.Friend;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.repository.MongoRepository;

@DependsOn("mongoTemplate")
public interface FriendRepository extends MongoRepository<Friend, String> {
}
