package com.fullstack.project_fullstack.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    public static String hashPassword(String password) {
//        return passwordEncoder.encode(password);
//    }
//
//    public static boolean verifyPassword(String password, String hashedPassword) {
//        return passwordEncoder.matches(password, hashedPassword);
//    }

}
