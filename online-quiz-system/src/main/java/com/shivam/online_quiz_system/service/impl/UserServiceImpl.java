package com.shivam.online_quiz_system.service.impl;

import com.shivam.online_quiz_system.model.User;
import com.shivam.online_quiz_system.repository.UserRepository;
import com.shivam.online_quiz_system.security.JwtUtil;
import com.shivam.online_quiz_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User registerUser(User user) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // Ensure password is encoded
        return userRepository.save(user);
    }

    @Override
    public String authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the password matches the encoded password
        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());  // Generate JWT token
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @Override
    public User saveUser(User user) {
        // Call registerUser to ensure password is hashed
        return registerUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER")  // You can customize authorities as needed
                .build();
    }
}
