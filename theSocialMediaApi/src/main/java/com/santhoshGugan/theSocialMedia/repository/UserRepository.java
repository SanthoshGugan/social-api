package com.santhoshGugan.theSocialMedia.repository;

import com.santhoshGugan.theSocialMedia.models.User;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.repository.MongoRepository;

@DependsOn("mongoTemplate")
public interface UserRepository extends MongoRepository<User, String> {

    void deleteById(String id);
}
