package com.fullstack.project_fullstack.model;

import com.fullstack.project_fullstack.Controller.AccountController;
import com.fullstack.project_fullstack.Services.AccountService;
import com.fullstack.project_fullstack.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;

@Document(collection = "users")
public class User {
    private String id;
    private String username;
    private String email;
    private String password;
    private String accountNumber;
    private String address;

    @Autowired
    AccountController accountController = new AccountController();

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService ;
   // @Nullable
   // private double balance;

    @Autowired
    SecurityConfig securityConfig = new SecurityConfig();

    public User(String username, String email, String password, String accountNumber, String address ,String id) {
        this.id = id;
        this.username = username;
        this.email = email;
       // this.password = securityConfig.passwordEncoder().encode(password);
        this.password=PasswordUtils.hashPassword(password);

        this.accountNumber = accountNumber;
        this.address = address;

     //   this.balance = balance;
    }

    public User() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getId()
    {return id;}

    public String setAccountNumber()
    {
        Random rd=new Random();
        int rnum=rd.nextInt(100000000);
        String snum=String.valueOf(rnum);

       return this.accountNumber = ("NXT"+snum);
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public String getAccountNumber() {
        return accountNumber;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
    }


}
