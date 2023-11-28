package com.fullstack.project_fullstack.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {


    @Test
    public void testGettersAndSetters() {
        // Arrange
        String accountNumber = "1234567890";
        String accountHolderName = "John Doe";
        double balance = 1000.0;

        // Act
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setAccountHolderName(accountHolderName);
        account.setBalance(balance);

        // Assert
        Assertions.assertEquals(accountNumber, account.getAccountNumber());
        Assertions.assertEquals(accountHolderName, account.getAccountHolderName());
        Assertions.assertEquals(balance, account.getBalance());
    }

    @Test
    public void testIdSetterAndGetter() {
        // Arrange
        String id = "123";

        // Act
        Account account = new Account();
        account.setId(id);

        // Assert
        Assertions.assertEquals(id, account.getId());
    }

    @Test
    public void testConstructor() {
        // Arrange
        String accountNumber = "1234567890";
        String accountHolderName = "John Doe";
        double balance = 1000.0;

        // Act
        Account account = new Account(accountNumber, accountHolderName, balance);

        // Assert
        Assertions.assertEquals(accountNumber, account.getAccountNumber());
        Assertions.assertEquals(accountHolderName, account.getAccountHolderName());
        Assertions.assertEquals(balance, account.getBalance());
    }






    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getAccountNumber() {
    }

    @Test
    void setAccountNumber() {
    }

    @Test
    void getAccountHolderName() {
    }


    @Test
    void setAccountHolderName() {
    }

    @Test
    void getBalance() {
    }

    @Test
    void setBalance_ShouldSetBalance() {
        // Arrange
        double balance = 1000.0;
        Account account = new Account();

        // Act
        account.setBalance(balance);

        // Assert
        Assertions.assertEquals(balance, account.getBalance());
    }

}