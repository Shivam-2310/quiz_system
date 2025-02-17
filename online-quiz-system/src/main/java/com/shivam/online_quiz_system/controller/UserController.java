package com.shivam.online_quiz_system.controller;

import com.shivam.online_quiz_system.model.User;
import com.shivam.online_quiz_system.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
