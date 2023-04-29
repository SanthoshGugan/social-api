package com.santhoshGugan.theSocialMedia.controller;

import com.santhoshGugan.theSocialMedia.dto.FriendUserDTO;
import com.santhoshGugan.theSocialMedia.models.Friend;
import com.santhoshGugan.theSocialMedia.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend")
@CrossOrigin
public class FriendController extends AbstractController<FriendService, Friend, String> {

    @GetMapping("/users/{id}")
    public ResponseEntity<List<FriendUserDTO>> getFriendsByUserId(@PathVariable("id") String userId) {
        final var friends = s.getFriendsByUserId(userId);
        return ResponseEntity.ok(friends);
    }
}
