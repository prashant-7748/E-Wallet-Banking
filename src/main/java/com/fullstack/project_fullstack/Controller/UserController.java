package com.fullstack.project_fullstack.Controller;

import com.fullstack.project_fullstack.Services.AccountService;
import com.fullstack.project_fullstack.Services.UserService;
import com.fullstack.project_fullstack.model.Account;
import com.fullstack.project_fullstack.model.LoginRequest;
import com.fullstack.project_fullstack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    private AccountService accountService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        user.setAccountNumber();
        Account account = new Account(user.getAccountNumber(), user.getUsername(),0.0);
        accountService.createAccount(account);
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {

        return userService.getUser(id);
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
//
//    @GetMapping("/{id}/balance")
//    public double getBalance(@PathVariable("id") String id) {
//        return userService.getBalance(id);
//    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String useremail = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        User user = userService.login(useremail, password);
        if (user != null) {
            // Login successful
            return user.getId();
        } else {
            // Invalid credentials
            return null;
        }
    }


}
