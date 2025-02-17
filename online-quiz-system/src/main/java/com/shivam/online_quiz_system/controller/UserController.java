package com.shivam.online_quiz_system.controller;

import com.shivam.online_quiz_system.model.User;
import com.shivam.online_quiz_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);  // Calling the new method
    }
}
