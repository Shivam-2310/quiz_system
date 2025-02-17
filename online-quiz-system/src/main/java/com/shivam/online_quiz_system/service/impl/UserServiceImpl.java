package com.shivam.online_quiz_system.service.impl;

import com.shivam.online_quiz_system.model.User;
import com.shivam.online_quiz_system.repository.UserRepository;
import com.shivam.online_quiz_system.service.UserService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
