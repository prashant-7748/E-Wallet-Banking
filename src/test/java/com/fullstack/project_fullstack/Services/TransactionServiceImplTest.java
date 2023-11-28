//package com.fullstack.project_fullstack.Services;
//
//import com.fullstack.project_fullstack.model.Transaction;
//import com.fullstack.project_fullstack.repository.TransactionRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class TransactionServiceImplTest {
//
//    @Mock
//    private TransactionRepository transactionRepository;
//
//    @InjectMocks
//    private TransactionServiceImpl transactionService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void getAllTransactions_ShouldReturnAllTransactions() {
//
//        List<Transaction> transactionList = new ArrayList<>();
//        when(transactionRepository.findAll()).thenReturn(transactionList);
//
//
//        List<Transaction> retrievedTransactions = transactionService.getAllTransactions();
//
//
//        Assertions.assertEquals(transactionList, retrievedTransactions);
//        verify(transactionRepository, times(1)).findAll();
//    }
//
//    @Test
//    void createTransaction_ShouldSaveTransactionAndReturnSavedTransaction() {
//        Transaction transaction = new Transaction();
//        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);
//
//        Transaction savedTransaction = transactionService.createTransaction(transaction);
//
//
//        Assertions.assertEquals(transaction, savedTransaction);
//        verify(transactionRepository, times(1)).save(transaction);
//    }
//
//    @Test
//    void getTransactionsBySenderAccountNumber_WithValidAccountNumber_ShouldReturnMatchingTransactions() {
//        // Arrange
//        String accountNumber = "987654321";
//        List<Transaction> transactionList = new ArrayList<>();
//        Transaction transaction = new Transaction();
//        transaction.setReceiverAccountNumber("123456789");
//        transaction.setSenderAccountNumber("987654321");
//        transaction.setAmount(0.0);
//        transactionList.add(transaction);
//        when(transactionRepository.findBySenderAccountNumber(accountNumber)).thenReturn(transactionList);
//
//
//        List<Transaction> retrievedTransactions = transactionService.getTransactionsBySenderAccountNumber(accountNumber);
//
//        verify(transactionRepository, times(1)).findBySenderAccountNumber(accountNumber);
//
//    }
//
//    @Test
//    void getTransactionsBySenderAccountNumber_WithInvalidAccountNumber_ShouldThrowRuntimeException() {
//        // Arrange
//        String accountNumber = "nonexistent";
//        when(transactionRepository.findBySenderAccountNumber(accountNumber)).thenReturn(new ArrayList<>());
//
//        // Act & Assert
//        Assertions.assertThrows(RuntimeException.class, () -> transactionService.getTransactionsBySenderAccountNumber(accountNumber));
//        verify(transactionRepository, times(1)).findBySenderAccountNumber(accountNumber);
//    }
//
//    @Test
//    void getTransactionsByAccountNumber_ShouldReturnTransactionsMatchingSenderOrReceiverAccountNumber() {
//        // Arrange
//        String accountNumber = "987654321";
//        List<Transaction> transactionList = new ArrayList<>();
//        Transaction transaction = new Transaction();
//        transaction.setReceiverAccountNumber("123456789");
//        transaction.setSenderAccountNumber("987654321");
//        transaction.setAmount(0.0);
//        transactionList.add(transaction);
//        when(transactionRepository.findBySenderAccountNumber(accountNumber)).thenReturn(transactionList);
//        when(transactionRepository.findBySenderAccountNumberOrReceiverAccountNumber(accountNumber, accountNumber)).thenReturn(transactionList);
//
//
//        List<Transaction> retrievedTransactions = transactionService.getTransactionsByAccountNumber(accountNumber);
//
//        verify(transactionRepository, times(1));
//    }
//
//    @Test
//    void getAllTransactions() {
//    }
//
//    @Test
//    void createTransaction() {
//    }
//
//    @Test
//    void getTransactionsBySenderAccountNumber() {
//    }
//
//    @Test
//    void getTransactionsByAccountNumber() {
//    }
//}