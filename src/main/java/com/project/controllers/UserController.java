package com.project.controllers;

import com.project.exceptions.NotFoundException;
import com.project.models.User;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Integer userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }
}

