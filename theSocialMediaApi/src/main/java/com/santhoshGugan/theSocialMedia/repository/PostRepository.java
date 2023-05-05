package com.santhoshGugan.theSocialMedia.repository;

import com.santhoshGugan.theSocialMedia.models.Post;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;

@DependsOn("mongoTemplate")
public interface PostRepository extends MongoRepository<Post, String> {

    @Query(" { 'authorId' : { $in: ?0 } } ")
    List<Post> getFriendsPost(List<String> friendIds, Pageable pageable);

    @Query(" { 'authorId' : { $eq: ?0 } }")
    List<Post> getPostsByUser(String userId);
}
