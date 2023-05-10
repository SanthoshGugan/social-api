package com.santhoshGugan.theSocialMedia.controller;

import com.santhoshGugan.theSocialMedia.dto.PostUserDTO;
import com.santhoshGugan.theSocialMedia.models.Post;
import com.santhoshGugan.theSocialMedia.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin
class PostController extends AbstractController<PostService, Post, String> {

    @GetMapping("/feeds/{id}")
    public ResponseEntity<List<PostUserDTO>> getFeed(@PathVariable("id") final String id) {
        final var postUserDTOs = s.getFriendsPost(id);
        return ResponseEntity.ok(postUserDTOs);
    }

    @GetMapping("/feed/{id}")
    public ResponseEntity<PostUserDTO> getFeedById(@PathVariable("id") final String id) {
        final var postUserDto = s.getFeedById(id);
        if (postUserDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(postUserDto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostUserDTO>> getPostByUserId(@PathVariable("userId") final String userId) {
        final var posts = s.getPostsByUserId(userId);
        return ResponseEntity.ok(posts);
    }

}
