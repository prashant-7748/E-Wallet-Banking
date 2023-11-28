package com.fullstack.project_fullstack.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidCredentialsExceptionTest {


    @Test
    public void testExceptionMessage() {
        String message = "Invalid credentials";
        InvalidCredentialsException exception = new InvalidCredentialsException(message);

        Assertions.assertEquals(message, exception.getMessage());
    }



    @Test
    public void testExceptionInequality() {
        String message1 = "Invalid credentials";
        String message2 = "Incorrect username or password";
        InvalidCredentialsException exception1 = new InvalidCredentialsException(message1);
        InvalidCredentialsException exception2 = new InvalidCredentialsException(message2);

        Assertions.assertNotEquals(exception1, exception2);
    }



}