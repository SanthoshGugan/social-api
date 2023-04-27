package com.santhoshGugan.theSocialMedia.repository;

import com.santhoshGugan.theSocialMedia.models.Post;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.repository.MongoRepository;

@DependsOn("mongoTemplate")
public interface PostRepository extends MongoRepository<Post, String> {

}
