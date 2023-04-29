package com.santhoshGugan.theSocialMedia.service;

import com.santhoshGugan.theSocialMedia.dto.FriendUserDTO;
import com.santhoshGugan.theSocialMedia.models.Friend;
import com.santhoshGugan.theSocialMedia.models.User;
import com.santhoshGugan.theSocialMedia.repository.FriendRepository;
import com.santhoshGugan.theSocialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FriendService extends AbstractService<FriendRepository, Friend, String> {

    @Autowired
    private UserRepository userRepository;
    public List<FriendUserDTO> getFriendsByUserId(final String userId) {
        final var friends = repo.getFriendsByUserId(userId);
        final Set<String> userIds = friends.stream().map(friend -> friend.getFriendId())
                .collect(Collectors.toSet());
        userIds.add(userId);

        final Map<String, User> users = new HashMap<>();
        userRepository.getUsersById(userIds.stream().collect(Collectors.toList()))
                .stream()
                .forEach(user -> users.put(user.getId(), user));

        return friends.stream()
                .map(friend ->  FriendUserDTO.convert(friend,
                        users.get(friend.getUserId()),
                        users.get(friend.getFriendId())))
                .collect(Collectors.toList());
    }
}
