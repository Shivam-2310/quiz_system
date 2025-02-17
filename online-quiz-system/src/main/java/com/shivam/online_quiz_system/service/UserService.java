package com.shivam.online_quiz_system.service;

import com.shivam.online_quiz_system.model.User;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserByUsername(String username);
}
