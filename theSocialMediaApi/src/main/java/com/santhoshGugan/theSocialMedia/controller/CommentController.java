package com.santhoshGugan.theSocialMedia.controller;

import com.santhoshGugan.theSocialMedia.dto.CommentUserDTO;
import com.santhoshGugan.theSocialMedia.models.Comment;
import com.santhoshGugan.theSocialMedia.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController extends AbstractController<CommentService, Comment, String> {

    @GetMapping("/post/{id}")
    public ResponseEntity<List<CommentUserDTO>> getCommentsByPost(@PathVariable("id") String postId) {
        return ResponseEntity.ok(s.getCommentsByPostId(postId));
    }
}
