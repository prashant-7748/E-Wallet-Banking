package com.fullstack.project_fullstack.Services;

import com.fullstack.project_fullstack.exception.AccountNotFoundException;
import com.fullstack.project_fullstack.exception.InvalidCredentialsException;
import com.fullstack.project_fullstack.model.PasswordUtils;
import com.fullstack.project_fullstack.model.SecurityConfig;
import com.fullstack.project_fullstack.model.User;
import com.fullstack.project_fullstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private PasswordUtils passwordUtils;
    private SecurityConfig securityConfig;



    public UserServiceImpl(UserRepository userRepository, SecurityConfig securityConfig) {
        this.userRepository = userRepository;
        this.securityConfig =securityConfig;
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getAllUsers() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && PasswordUtils.verifyPassword(password, user.getPassword())) {
            return user;
        }
//
//
        throw new InvalidCredentialsException("Invalid credentials");
    }
}
