package com.santhoshGugan.theSocialMedia.service;

import com.santhoshGugan.theSocialMedia.models.Comment;
import com.santhoshGugan.theSocialMedia.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends AbstractService<CommentRepository, Comment, String> {

}
