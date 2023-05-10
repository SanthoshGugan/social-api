package com.santhoshGugan.theSocialMedia.service;

import com.santhoshGugan.theSocialMedia.models.Like;
import com.santhoshGugan.theSocialMedia.repository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService extends AbstractService<LikeRepository, Like, String> {

    public Like getUserLikedPost(final String userId, final String postId) {

        final var like = repo.getLikeByUserIdPostId(userId, postId);
        return like;
    }

    public void deleteLikeByUserIdAndPostId(final String userId,
                                     final String postId) {
        repo.deleteLikeByUserIdAndPostId(userId, postId);
    }
}
