package com.fullstack.project_fullstack.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.apache.logging.log4j.util.LambdaUtil.getMessage;
import static org.junit.jupiter.api.Assertions.*;

class AccountNotFoundExceptionTest {


    @Test
    public void testExceptionMessage() {
        String message = "Account not found";
        AccountNotFoundException exception = new AccountNotFoundException(message);

        Assertions.assertEquals(message, exception.getMessage());
    }

    @Test
    public void testExceptionInequality() {
        String message1 = "Account not found";
        String message2 = "Account does not exist";
        AccountNotFoundException exception1 = new AccountNotFoundException(message1);
        AccountNotFoundException exception2 = new AccountNotFoundException(message2);

        Assertions.assertNotEquals(exception1, exception2);
    }
}