package com.fullstack.project_fullstack.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        //System.out.println(passwordEncoder.matches(password,hashedPassword));
        return passwordEncoder.matches(password, hashedPassword);
    }
}

