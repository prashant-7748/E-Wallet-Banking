package com.fullstack.project_fullstack.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestTest {


    @Test
    void getEmail_ShouldReturnEmail() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        LoginRequest loginRequest = new LoginRequest(email, password);

        // Act
        String retrievedEmail = loginRequest.getEmail();

        // Assert
        assertEquals(email, retrievedEmail);
    }

    @Test
    void setEmail_ShouldSetEmail() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        LoginRequest loginRequest = new LoginRequest("", password);

        // Act
        loginRequest.setEmail(email);

        // Assert
        assertEquals(email, loginRequest.getEmail());
    }

    @Test
    void getPassword_ShouldReturnPassword() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        LoginRequest loginRequest = new LoginRequest(email, password);

        // Act
        String retrievedPassword = loginRequest.getPassword();

        // Assert
        assertEquals(password, retrievedPassword);
    }

    @Test
    void setPassword_ShouldSetPassword() {
        // Arrange
        String email = "test@example.com";
        String password = "password";
        LoginRequest loginRequest = new LoginRequest(email, "");

        // Act
        loginRequest.setPassword(password);

        // Assert
        assertEquals(password, loginRequest.getPassword());
    }



    @Test
    void getEmail() {
    }

    @Test
    void setEmail() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void setPassword() {
    }
}