package com.fullstack.project_fullstack.Services;

import com.fullstack.project_fullstack.model.User;

import java.util.List;

public interface UserService {

        User createUser(User user);
        User getUser(String id);

        List<User> getAllUsers();

       // double getBalance(String id);

        User login(String username, String password);



}


