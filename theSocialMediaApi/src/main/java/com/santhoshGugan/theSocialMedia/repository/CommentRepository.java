package com.santhoshGugan.theSocialMedia.repository;

import com.santhoshGugan.theSocialMedia.models.Comment;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@DependsOn("mongoTemplate")
public interface CommentRepository extends MongoRepository<Comment, String> {

    @Query(" { 'parentId' : { $eq: ?0 } } ")
    List<Comment> getCommentsByPost(String postId);
}

