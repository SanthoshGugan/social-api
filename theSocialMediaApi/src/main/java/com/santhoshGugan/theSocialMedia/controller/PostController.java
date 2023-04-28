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
public class PostController extends AbstractController<PostService, Post, String> {

    @GetMapping("/feed/{id}")
    public ResponseEntity<List<PostUserDTO>> getFeed(@PathVariable("id") final String id) {
        final var posts = s.getFriendsPost(id);
        return ResponseEntity.ok(posts);
    }
}
