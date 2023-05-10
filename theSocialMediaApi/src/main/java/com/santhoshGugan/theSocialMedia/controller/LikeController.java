package com.santhoshGugan.theSocialMedia.controller;

import com.santhoshGugan.theSocialMedia.Response.LikeByUserAndPost;
import com.santhoshGugan.theSocialMedia.models.Like;
import com.santhoshGugan.theSocialMedia.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/like")
@CrossOrigin
class LikeController extends AbstractController<LikeService, Like, String> {

    @GetMapping("/post/{postId}/user/{userId}")
    public ResponseEntity<LikeByUserAndPost> getLikeByUserAndPostI(@PathVariable("postId") final String postId,
                                                                   @PathVariable("userId") final String userId) {
        final var like = s.getUserLikedPost(userId, postId);
        final var likeByUserAndPost = new LikeByUserAndPost(like != null, like);
        return ResponseEntity.ok(likeByUserAndPost);
    }

    @DeleteMapping("/post/{postId}/user/{userId}")
    public ResponseEntity<Void> deleteLikeByUserIdAndPostId(@PathVariable("postId")  final String postId,
                                                            @PathVariable("userId")  final String userId) {
        s.deleteLikeByUserIdAndPostId(userId, postId);
        return ResponseEntity.noContent().build();
    }
}
