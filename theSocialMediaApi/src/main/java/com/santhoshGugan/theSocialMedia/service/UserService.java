package com.santhoshGugan.theSocialMedia.service;

import com.santhoshGugan.theSocialMedia.models.User;
import com.santhoshGugan.theSocialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User add(final User user) {
        return userRepo.insert(user);
    }

    public Optional<User> get(final String id) {
        return userRepo.findById(id);
    }

    public void delete(final String id) { userRepo.deleteById(id);}

    public User update(final User user, final String id) {
        final var existingUser = userRepo.findById(id);
        if (existingUser.isEmpty()) {
            return null;
        }
        return userRepo.save(user);
    }
}
