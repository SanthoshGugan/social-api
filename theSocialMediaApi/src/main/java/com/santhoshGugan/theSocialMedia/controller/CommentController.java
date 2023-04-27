package com.santhoshGugan.theSocialMedia.controller;

import com.santhoshGugan.theSocialMedia.models.Comment;
import com.santhoshGugan.theSocialMedia.service.CommentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController extends AbstractController<CommentService, Comment, String> {
}
