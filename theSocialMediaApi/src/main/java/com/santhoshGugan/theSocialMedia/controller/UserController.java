package com.santhoshGugan.theSocialMedia.controller;

import com.santhoshGugan.theSocialMedia.models.User;
import com.santhoshGugan.theSocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody final User user) {
        final var createdUser = userService.add(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) throws InterruptedException {
        final var userO = userService.get(id);
        if (userO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userO.get());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User> getByName(@PathVariable("name") String name) {
        final var user = userService.getByName(name);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id,
                                           @RequestBody User user) {
        final var updatedUser = userService.update(user, id);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }
}
