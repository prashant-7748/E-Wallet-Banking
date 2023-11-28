package com.fullstack.project_fullstack.Controller;

import com.fullstack.project_fullstack.Services.AccountService;
import com.fullstack.project_fullstack.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountControllerTest {



    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllAccounts_ShouldReturnAllAccounts() {
        // Arrange
        List<Account> accountList = new ArrayList<>();
        when(accountService.getAllAccounts()).thenReturn(accountList);

        // Act
        ResponseEntity<List<Account>> responseEntity = accountController.getAllAccounts();

        // Assert
        Assertions.assertEquals(accountList, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(accountService, times(1)).getAllAccounts();
    }

    @Test
    void getAccountById_WithValidId_ShouldReturnMatchingAccount() {
        // Arrange
        String id = "123";
        Account account = new Account();
        when(accountService.getAccountById(id)).thenReturn(account);

        // Act
        ResponseEntity<Account> responseEntity = accountController.getAccountById(id);

        // Assert
        Assertions.assertEquals(account, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(accountService, times(1)).getAccountById(id);
    }

    @Test
    void getAccountById_WithInvalidId_ShouldReturnNotFound() {
        // Arrange
        String id = "nonexistent";
        when(accountService.getAccountById(id)).thenReturn(null);

        // Act
        ResponseEntity<Account> responseEntity = accountController.getAccountById(id);

        // Assert
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        verify(accountService, times(1)).getAccountById(id);
    }

    @Test
    void createAccount_ShouldSaveAccountAndReturnSavedAccount() {
        // Arrange
        Account account = new Account();
        when(accountService.createAccount(account)).thenReturn(account);

        // Act
        ResponseEntity<Account> responseEntity = accountController.createAccount(account, null);

        // Assert
        Assertions.assertEquals(account, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(accountService, times(1)).createAccount(account);
    }

    @Test
    void deleteAccount_ShouldDeleteAccount() {
        // Arrange
        String id = "123";

        // Act
        ResponseEntity<String> responseEntity = accountController.deleteAccount(id);

        // Assert
        Assertions.assertEquals("Account with id " + id + " deleted successfully.", responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(accountService, times(1)).deleteAccount(id);
    }

    @Test
    void getBalance_ShouldReturnAccountBalance() {
        // Arrange
        String id = "123";
        double balance = 100.0;
        when(accountService.getBalance(id)).thenReturn(balance);

        // Act
        double result = accountController.getBalance(id);

        // Assert
        Assertions.assertEquals(balance, result);
        verify(accountService, times(1)).getBalance(id);
    }

    @Test
    void addMoney1_ShouldCallAccountServiceToAddMoney() {
        // Arrange
        String accountNumber = "123";
        double newBalance = 100.0;

        // Act
        accountController.addMoney1(accountNumber, newBalance);

        // Assert
        verify(accountService, times(1)).addMoney(accountNumber, newBalance);
    }

    @Test
    void getByAccountNumber_WithValidAccountNumber_ShouldReturnMatchingAccount() {
        // Arrange
        String accountNumber = "123";
        Account account = new Account();
        when(accountService.getByAccountNumber(accountNumber)).thenReturn(account);

        // Act
        ResponseEntity<Account> responseEntity = accountController.getByAccountNumber(accountNumber);

        // Assert
        Assertions.assertEquals(account, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(accountService, times(1)).getByAccountNumber(accountNumber);
    }

    @Test
    void getByAccountNumber_WithInvalidAccountNumber_ShouldReturnNotFound() {
        // Arrange
        String accountNumber = "nonexistent";
        when(accountService.getByAccountNumber(accountNumber)).thenReturn(null);

        // Act
        ResponseEntity<Account> responseEntity = accountController.getByAccountNumber(accountNumber);

        // Assert
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        verify(accountService, times(1)).getByAccountNumber(accountNumber);
    }

    @Test
    void transferMoney_WithValidParameters_ShouldReturnOk() throws Exception {
        // Arrange
        String accountNumber = "123";
        String receiverAccountNumber = "456";
        double amount = 100.0;
        Account sender = new Account();
        Account receiver = new Account();
        when(accountService.getByAccountNumber(accountNumber)).thenReturn(sender);
        when(accountService.getByAccountNumber(receiverAccountNumber)).thenReturn(receiver);

        // Act
        ResponseEntity<String> responseEntity = accountController.transferMoney(accountNumber, receiverAccountNumber, amount);

        // Assert
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals("Done", responseEntity.getBody());
        verify(accountService, times(1)).transactions(sender, receiver, amount);
    }

    @Test
    void transferMoney_WithInvalidAccountNumber_ShouldReturnNotFound() throws Exception {
        // Arrange
        String accountNumber = "nonexistent";
        String receiverAccountNumber = "456";
        double amount = 100.0;
        when(accountService.getByAccountNumber(accountNumber)).thenReturn(null);

        // Act
        ResponseEntity<String> responseEntity = accountController.transferMoney(accountNumber, receiverAccountNumber, amount);

        // Assert
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

    }


}