package com.shivam.online_quiz_system.service;

import com.shivam.online_quiz_system.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    User registerUser(User user);

    String authenticateUser(String username, String password);

    User saveUser(User user);

    User getUserByUsername(String username);
}
