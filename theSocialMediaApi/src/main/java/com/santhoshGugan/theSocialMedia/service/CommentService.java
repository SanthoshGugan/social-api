package com.santhoshGugan.theSocialMedia.service;

import com.santhoshGugan.theSocialMedia.dto.CommentUserDTO;
import com.santhoshGugan.theSocialMedia.models.Comment;
import com.santhoshGugan.theSocialMedia.models.User;
import com.santhoshGugan.theSocialMedia.repository.CommentRepository;
import com.santhoshGugan.theSocialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommentService extends AbstractService<CommentRepository, Comment, String> {

    @Autowired
    private UserRepository userRepository;
    public List<CommentUserDTO> getCommentsByPostId(final String postId) {
        final var comments = repo.getCommentsByPost(postId);
        final List<String> authorIds = comments.stream()
                .map(Comment::getAuthorId)
                .collect(Collectors.toList());
        final Map<String, User> authorMap = new HashMap<>();
        userRepository.getUsersById(authorIds).stream()
                .forEach(user -> authorMap.put(user.getId(), user));
        return comments.stream()
                .map(comment -> CommentUserDTO.convert(comment, authorMap.get(comment.getAuthorId())))
                .collect(Collectors.toList());
    }
}
