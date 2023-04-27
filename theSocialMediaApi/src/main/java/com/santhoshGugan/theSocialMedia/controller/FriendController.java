package com.santhoshGugan.theSocialMedia.controller;

import com.santhoshGugan.theSocialMedia.models.Friend;
import com.santhoshGugan.theSocialMedia.service.FriendService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friend")
@CrossOrigin
public class FriendController extends AbstractController<FriendService, Friend, String> {
}
