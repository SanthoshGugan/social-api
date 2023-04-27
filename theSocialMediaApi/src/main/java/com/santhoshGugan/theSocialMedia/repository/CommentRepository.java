package com.santhoshGugan.theSocialMedia.repository;

import com.santhoshGugan.theSocialMedia.models.Comment;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.repository.MongoRepository;

@DependsOn("mongoTemplate")
public interface CommentRepository extends MongoRepository<Comment, String> {
}

