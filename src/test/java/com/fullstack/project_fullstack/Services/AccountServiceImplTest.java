//package com.fullstack.project_fullstack.Services;
//
//import com.fullstack.project_fullstack.Controller.TransactionController;
//import com.fullstack.project_fullstack.exception.AccountNotFoundException;
//import com.fullstack.project_fullstack.model.Account;
//import com.fullstack.project_fullstack.repository.AccountRepository;
//import com.fullstack.project_fullstack.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class AccountServiceImplTest {
//
//
//    @Mock
//    private AccountRepository accountRepository;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private TransactionService transactionService;
//
//    @Mock
//    private TransactionController transactionController;
//
//    @InjectMocks
//    private AccountServiceImpl accountService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void getBalance_AccountFound_ShouldReturnBalance() {
//        String accountId = "123456789";
//        double expectedBalance = 500.0;
//        String accountHolderName="Abc";
//        Account account = new Account(accountId, accountHolderName, expectedBalance);
//
//        when(accountRepository.findByAccountNumber(accountId)).thenReturn(Optional.of(account));
//
//        double balance = accountService.getBalance(accountId);
//
//        assertEquals(expectedBalance, balance);
//    }
//
//    @Test
//    void getBalance_AccountNotFound_ShouldThrowException() {
//        String accountId = "123456789";
//
//        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, () -> accountService.getBalance(accountId));
//    }
//
//    @Test
//    void getAllAccounts_ShouldReturnAllAccounts() {
//        List<Account> accounts = new ArrayList<>();
//        accounts.add(new Account("123", 100.0));
//        accounts.add(new Account("456", 200.0));
//        accounts.add(new Account("789", 300.0));
//
//        when(accountRepository.findAll()).thenReturn(accounts);
//
//
//        List<Account> result = accountService.getAllAccounts();
//
//
//        assertEquals(accounts, result);
//    }
//
//
//
//
//    @Test
//    void getAccountById_ValidId_ShouldReturnAccount() {
//        String accountId = "123456789";
//        Account expectedAccount = new Account(accountId, 500.0);
//
//        when(accountRepository.findById(accountId)).thenReturn(Optional.of(expectedAccount));
//
//        Account account = accountService.getAccountById(accountId);
//
//
//        assertEquals(expectedAccount, account);
//    }
//
//    @Test
//    void getAccountById_InvalidId_ShouldThrowException() {
//
//        String invalidId = "999999";
//
//        when(accountRepository.findById(invalidId)).thenReturn(Optional.empty());
//
//
//        assertThrows(AccountNotFoundException.class, () -> accountService.getAccountById(invalidId));
//    }
//
//
//    @Test
//    void createAccount_ValidAccount_ShouldReturnCreatedAccount() {
//        // Arrange
//        Account accountToCreate = new Account("123456789", 500.0);
//        Account createdAccount = new Account("123456789", 500.0);
//
//        when(accountRepository.save(accountToCreate)).thenReturn(createdAccount);
//
//        Account result = accountService.createAccount(accountToCreate);
//
//
//        assertEquals(createdAccount, result);
//    }
//
//    @Test
//    void deleteAccount_ValidId_ShouldDeleteAccount() {
//        // Arrange
//        String accountId = "123456789";
//        Account accountToDelete = new Account(accountId, 500.0);
//
//        when(accountRepository.findById(accountId)).thenReturn(Optional.of(accountToDelete));
//
//
//        accountService.deleteAccount(accountId);
//
//
//        verify(accountRepository).delete(accountToDelete);
//    }
//
//    @Test
//    void deleteAccount_InvalidId_ShouldThrowException() {
//
//        String invalidId = "999999";
//
//        when(accountRepository.findById(invalidId)).thenReturn(Optional.empty());
//
//
//        assertThrows(AccountNotFoundException.class, () -> accountService.deleteAccount(invalidId));
//    }
//
//    @Test
//    void updateBalance_ValidAccountNumber_ShouldUpdateBalance() {
//
//        String accountNumber = "123456789";
//        double newBalance = 1000.0;
//        Account accountToUpdate = new Account(accountNumber, 500.0);
//
//        when(accountRepository.findByAccountNumber(accountNumber)).thenReturn(Optional.of(accountToUpdate));
//
//        accountService.updateBalance(accountNumber, newBalance);
//        assertEquals(newBalance, accountToUpdate.getBalance());
//        verify(accountRepository).save(accountToUpdate);
//    }
//
//    @Test
//    void updateBalance_InvalidAccountNumber_ShouldThrowException() {
//
//        String invalidAccountNumber = "999999";
//
//        when(accountRepository.findByAccountNumber(invalidAccountNumber)).thenReturn(Optional.empty());
//
//
//        assertThrows(AccountNotFoundException.class, () -> accountService.updateBalance(invalidAccountNumber, 1000.0));
//    }
//
//    @Test
//    void getByAccountNumber_ValidAccountNumber_ShouldReturnAccount() {
//        // Arrange
//        String accountNumber = "123456789";
//        Account expectedAccount = new Account(accountNumber, 500.0);
//
//        when(accountRepository.findByAccountNumber(accountNumber)).thenReturn(Optional.of(expectedAccount));
//
//
//        Account account = accountService.getByAccountNumber(accountNumber);
//
//
//        assertEquals(expectedAccount, account);
//    }
//
//    @Test
//    void getByAccountNumber_InvalidAccountNumber_ShouldThrowException() {
//
//        String invalidAccountNumber = "999999";
//
//        when(accountRepository.findByAccountNumber(invalidAccountNumber)).thenReturn(Optional.empty());
//
//
//        assertThrows(AccountNotFoundException.class, () -> accountService.getByAccountNumber(invalidAccountNumber));
//    }
//
//
//    @Test
//    void getBalance_AccountWithZeroBalance_ShouldReturnZero() {
//
//        String accountId = "123456789";
//        double expectedBalance = 0.0;
//        String accountHolderName = "Abc";
//        Account account = new Account(accountId, accountHolderName, expectedBalance);
//
//        when(accountRepository.findByAccountNumber(accountId)).thenReturn(Optional.of(account));
//
//
//        double balance = accountService.getBalance(accountId);
//
//
//        assertEquals(expectedBalance, balance);
//    }
//
//    @Test
//    void getAllAccounts_NoAccountsExist_ShouldReturnEmptyList() {
//
//        List<Account> accounts = new ArrayList<>();
//
//        when(accountRepository.findAll()).thenReturn(accounts);
//
//
//        List<Account> result = accountService.getAllAccounts();
//
//
//        assertTrue(result.isEmpty());
//    }
//
//}