package com.santhoshGugan.theSocialMedia.repository;

import com.santhoshGugan.theSocialMedia.models.User;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

@DependsOn("mongoTemplate")
public interface UserRepository extends MongoRepository<User, String> {

    void deleteById(String id);

    @Query(" { '_id' : { $in: ?0 } }")
    List<User> getUsersById(List<String> userIds);

    @Query(" { 'name' : { $eq: ?0 } } ")
    User getUserByName(String name);
}
