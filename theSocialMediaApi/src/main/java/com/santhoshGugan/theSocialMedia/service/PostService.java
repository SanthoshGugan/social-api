package com.santhoshGugan.theSocialMedia.service;

import com.santhoshGugan.theSocialMedia.models.Post;
import com.santhoshGugan.theSocialMedia.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService extends AbstractService<PostRepository, Post, String> {

//    @Autowired
//    private PostRepository repo;
//
//    public Post add(final Post post) { return repo.insert(post); }
//
//    public Optional<Post> get(final String id) { return repo.findById(id); }
//
//    public Post update(final Post post, final String id) {
//        if (!repo.existsById(id)) return null;
//        return repo.save(post);
//    }
//
//    public void delete(final String id) {
//        repo.deleteById(id);
//    }

}
