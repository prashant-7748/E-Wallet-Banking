package com.fullstack.project_fullstack.Controller;

import com.fullstack.project_fullstack.Services.TransactionService;
import com.fullstack.project_fullstack.Services.TransactionServiceImpl;
import com.fullstack.project_fullstack.model.Transaction;
import com.fullstack.project_fullstack.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionControllerTest {


    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionService transactionService;

    private TransactionController transactionController;

    @Mock
    private TransactionServiceImpl transactionServiceImpl;





    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transactionController = new TransactionController(transactionRepository, transactionService);
    }

    @Test
    void getAllTransactions_ShouldReturnAllTransactions() {
        // Arrange
        List<Transaction> transactions = new ArrayList<>();
        when(transactionRepository.findAll()).thenReturn(transactions);

        // Act
        ResponseEntity<List<Transaction>> responseEntity = transactionController.getAllTransactions();

        // Assert
        Assertions.assertEquals(transactions, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(transactionRepository, times(1)).findAll();
    }

    @Test
    void createTransaction_WithValidTransaction_ShouldReturnCreatedTransaction() {
        // Arrange
        Transaction transaction = new Transaction();
        when(transactionRepository.save(transaction)).thenReturn(transaction);

        // Act
        ResponseEntity<Transaction> responseEntity = transactionController.createTransaction(transaction);

        // Assert
        Assertions.assertEquals(transaction, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        verify(transactionRepository, times(1)).save(transaction);
    }

    @Test
    void getTransactionsByAccountNumber_WithValidAccountNumber_ShouldReturnMatchingTransactions() {
        // Arrange
        String accountNumber = "123";
        List<Transaction> transactions = new ArrayList<>();
        when(transactionService.getTransactionsByAccountNumber(accountNumber)).thenReturn(transactions);

        // Act
        List<Transaction> result = transactionController.getTransactionsByAccountNumber(accountNumber);

        // Assert
        Assertions.assertEquals(transactions, result);
        verify(transactionService, times(1)).getTransactionsByAccountNumber(accountNumber);
    }

//    @Test
//    void getTransactionsBySenderAccountNumber_WithValidAccountNumber_ShouldReturnMatchingTransactions() {
//        // Arrange
//        String accountNumber = "123";
//        List<Transaction> transactions = new ArrayList<>();
//        when(transactionServiceImpl.getTransactionsBySenderAccountNumber(accountNumber)).thenReturn(transactions);
//
//        // Act
//        List<Transaction> result = transactionController.getTransactionsBySenderAccountNumber(accountNumber);
//
//        // Assert
//        Assertions.assertEquals(transactions, result);
//        verify(transactionServiceImpl, times(1)).getTransactionsBySenderAccountNumber(accountNumber);
//    }


}