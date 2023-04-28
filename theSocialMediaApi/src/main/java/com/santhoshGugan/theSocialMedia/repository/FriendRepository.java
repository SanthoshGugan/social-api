package com.santhoshGugan.theSocialMedia.repository;

import com.santhoshGugan.theSocialMedia.models.Friend;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@DependsOn("mongoTemplate")
public interface FriendRepository extends MongoRepository<Friend, String> {

    @Query("{ 'userId' : { $eq: ?0 } }")
    List<Friend> getFriendsByUserId(String id);

}
