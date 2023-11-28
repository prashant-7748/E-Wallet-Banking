package com.fullstack.project_fullstack.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsufficientBalanceExceptionTest {


    @Test
    public void testConstructorAndGetMessage() {
        String message = "Insufficient balance";
        InsufficientBalanceException exception = new InsufficientBalanceException(message);

        Assertions.assertEquals(message, exception.getMessage());
    }


    @Test
    public void testDefaultConstructorAndGetMessage() {
        InsufficientBalanceException exception = new InsufficientBalanceException(null);

        Assertions.assertNull(exception.getMessage());
    }

//    @Test
//    public void testExceptionEquality() {
//        String message = "Insufficient balance";
//        InsufficientBalanceException exception1 = new InsufficientBalanceException(message);
//        InsufficientBalanceException exception2 = new InsufficientBalanceException(message);
//
//        Assertions.assertEquals(exception1, exception2);
//    }



    @Test
    public void testExceptionInequality() {
        String message1 = "Insufficient balance";
        String message2 = "Not enough funds";
        InsufficientBalanceException exception1 = new InsufficientBalanceException(message1);
        InsufficientBalanceException exception2 = new InsufficientBalanceException(message2);

        Assertions.assertNotEquals(exception1, exception2);
    }

}