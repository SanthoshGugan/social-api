package com.santhoshGugan.theSocialMedia.repository;

import com.santhoshGugan.theSocialMedia.models.Like;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@DependsOn("mongoTemplate")
public interface LikeRepository extends MongoRepository<Like, String> {

    @Query(" { 'userId': ?0, 'postId' : ?1 } ")
    Like getLikeByUserIdPostId(String userId, String postId);

    void deleteLikeByUserIdAndPostId(String userId, String postId);
}
