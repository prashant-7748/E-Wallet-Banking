package com.fullstack.project_fullstack.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilsTest {



    @Test
    void testHashPassword() {
        // Arrange
        String password = "password";

        // Act
        String hashedPassword = PasswordUtils.hashPassword(password);

        // Assert


        Assertions.assertNotNull(hashedPassword);
        Assertions.assertNotEquals(password, hashedPassword);
    }

    @Test
    void testVerifyPassword() {
        // Arrange
        String password = "password";
        String hashedPassword = PasswordUtils.hashPassword(password);

        // Act
        boolean result = PasswordUtils.verifyPassword(password, hashedPassword);

        // Assert
        Assertions.assertTrue(result);
    }

    @Test
    void testVerifyPassword_IncorrectPassword() {
        // Arrange
        String password = "password";
        String hashedPassword = PasswordUtils.hashPassword(password);
        String incorrectPassword = "wrongpassword";

        // Act
        boolean result = PasswordUtils.verifyPassword(incorrectPassword, hashedPassword);

        // Assert
        Assertions.assertFalse(result);
    }


    @Test
    void hashPassword() {
    }

    @Test
    void verifyPassword() {
    }
}