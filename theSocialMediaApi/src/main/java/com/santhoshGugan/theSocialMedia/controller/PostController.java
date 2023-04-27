package com.santhoshGugan.theSocialMedia.controller;

import com.santhoshGugan.theSocialMedia.models.Post;
import com.santhoshGugan.theSocialMedia.service.PostService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class PostController extends AbstractController<PostService, Post, String> {

}
