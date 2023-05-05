package com.santhoshGugan.theSocialMedia.service;

import com.santhoshGugan.theSocialMedia.dto.PostUserDTO;
import com.santhoshGugan.theSocialMedia.models.Friend;
import com.santhoshGugan.theSocialMedia.models.Post;
import com.santhoshGugan.theSocialMedia.models.User;
import com.santhoshGugan.theSocialMedia.repository.FriendRepository;
import com.santhoshGugan.theSocialMedia.repository.PostRepository;
import com.santhoshGugan.theSocialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService extends AbstractService<PostRepository, Post, String> {

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<PostUserDTO> getFriendsPost(final String id) {
        final List<Friend> friends = friendRepository.getFriendsByUserId(id);

        final List<String> friendIds = friends.stream()
                .map(Friend::getFriendId)
                .collect(Collectors.toList());
        final var sort = Sort.by(Sort.Direction.ASC, "authorId");
        final var pageable = PageRequest.of(0, 20, sort);

//        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.match(Criteria.where("authorId").in(friendIds)),
//                Aggregation.lookup("User", "authorId", "_id", "author"),
//                Aggregation.unwind("author"),
//                Aggregation.project("id", "content", "imageUrl", "authorId", "likes")
//                        .and("author._id").as("authorId")
//                        .and("author.name").as("authorName"),
//                Aggregation.limit(20)
//        );

//        return mongoTemplate.aggregate(aggregation, "Post", PostUserDTO.class)
//                .getMappedResults();

            final Map<String, User> userMap = getUserMap(friendIds);
            return repo.getFriendsPost(friendIds, pageable).stream()
                    .map(post -> PostUserDTO.convert(post, userMap.getOrDefault(post.getAuthorId(), new User("", ""))))
                    .collect(Collectors.toList());

    }

    public PostUserDTO getFeedById(final String postId) {
        final var postO = repo.findById(postId);
        if (postO.isEmpty()) return null;

        final var post = postO.get();
        final var authorO = userRepository.findById(post.getAuthorId());
        if (authorO.isEmpty()) return null;
        final var author = authorO.get();
        return PostUserDTO.convert(post, author);
    }

    public List<PostUserDTO> getPostsByUserId(final String userId) {
        final var myPosts = repo.getPostsByUser(userId);

        final var user = userRepository.findById(userId).orElse(null);

        if (user == null) return Collections.emptyList();

        return myPosts.stream()
                .map(post -> PostUserDTO.convert(post, user))
                .collect(Collectors.toList());
    }

    private Map<String, User> getUserMap(final List<String> userIds) {
        final Map<String, User> userMap = new HashMap<>();
        userRepository.getUsersById(userIds).stream()
                .forEach(user -> userMap.put(user.getId(), user));
        return userMap;
    }

}
