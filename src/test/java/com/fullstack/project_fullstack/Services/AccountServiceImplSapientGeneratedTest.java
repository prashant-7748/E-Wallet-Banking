package com.fullstack.project_fullstack.Services;

import com.fullstack.project_fullstack.exception.AccountNotFoundException;
import com.fullstack.project_fullstack.exception.InsufficientBalanceException;
import com.fullstack.project_fullstack.model.Account;
import com.fullstack.project_fullstack.model.Transaction;
import com.fullstack.project_fullstack.repository.AccountRepository;
import com.fullstack.project_fullstack.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AccountServiceImplSapientGeneratedTest {

    @Mock(name = "accountRepository")
    private AccountRepository accountRepositoryMock;

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private AccountServiceImpl target;

    @Mock(name = "userRepository")
    private UserRepository userRepositoryMock;

    @Mock(name = "transactionService")
    private TransactionService transactionServiceMock;

    //Sapient generated method id: ${a49d948d-220e-3fc1-b67f-f86a5283cec4}
    @Test()
    void getBalanceWhenOptionalAccountIsPresent() {
        /* Branches:
         * (optionalAccount.isPresent()) : true
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        Account accountMock = mock(Account.class);
        doReturn(Optional.of(accountMock)).when(accountRepositoryMock).findByAccountNumber("account1");
        doReturn(Double.parseDouble("0.0")).when(accountMock).getBalance();
        double result = target.getBalance("account1");
        assertAll("result", () -> {
            assertThat(result, closeTo(Double.parseDouble("0.0"), 0.00001));
            verify(accountRepositoryMock).findByAccountNumber("account1");
            verify(accountMock).getBalance();
        });
    }

    //Sapient generated method id: ${ce540cee-da32-3160-89f8-9884f0d95811}
    @Test()
    void getBalanceWhenOptionalAccountNotIsPresentThrowsRuntimeException() {
        /* Branches:
         * (optionalAccount.isPresent()) : false
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        doReturn(Optional.empty()).when(accountRepositoryMock).findByAccountNumber("account1");
        RuntimeException runtimeException = new RuntimeException("Account not found.");
        final RuntimeException result = assertThrows(RuntimeException.class, () -> {
            target.getBalance("account1");
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(runtimeException.getMessage()));
            verify(accountRepositoryMock).findByAccountNumber("account1");
        });
    }

    //Sapient generated method id: ${11f60e93-2bea-3be0-8428-5a77ebc5e406}
    @Test()
    void getAllAccountsTest() {
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        List<Account> accountList = new ArrayList<>();
        doReturn(accountList).when(accountRepositoryMock).findAll();
        List<Account> result = target.getAllAccounts();
        assertAll("result", () -> {
            assertThat(result, equalTo(accountList));
            verify(accountRepositoryMock).findAll();
        });
    }

    //Sapient generated method id: ${5b83c6d8-d8e8-3e01-a534-3defc6875d3b}
    @Test()
    void getAccountByIdWhenOptionalAccountNotIsPresentThrowsAccountNotFoundException() {
        /* Branches:
         * (!optionalAccount.isPresent()) : true
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        doReturn(Optional.empty()).when(accountRepositoryMock).findById("B");
        AccountNotFoundException accountNotFoundException = new AccountNotFoundException("Account not found with id: B");
        final AccountNotFoundException result = assertThrows(AccountNotFoundException.class, () -> {
            target.getAccountById("B");
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(accountNotFoundException.getMessage()));
            verify(accountRepositoryMock).findById("B");
        });
    }

    //Sapient generated method id: ${bc0b60fe-dc6b-30c3-a70e-90b7c3ace08e}
    @Test()
    void getAccountByIdWhenOptionalAccountIsPresent() {
        /* Branches:
         * (!optionalAccount.isPresent()) : false
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        Account accountMock = mock(Account.class);
        doReturn(Optional.of(accountMock)).when(accountRepositoryMock).findById("id1");
        Account result = target.getAccountById("id1");
        assertAll("result", () -> {
            assertThat(result, equalTo(accountMock));
            verify(accountRepositoryMock).findById("id1");
        });
    }

    //Sapient generated method id: ${6914da9c-9057-39cb-a8ab-3b7ec19055a3}
    @Test()
    void createAccountTest() {
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        Account accountMock = mock(Account.class);
        Account accountMock2 = mock(Account.class);
        doReturn(accountMock).when(accountRepositoryMock).save(accountMock2);
        Account result = target.createAccount(accountMock2);
        assertAll("result", () -> {
            assertThat(result, equalTo(accountMock));
            verify(accountRepositoryMock).save(accountMock2);
        });
    }

    //Sapient generated method id: ${c7f67d17-d7c0-32bb-aeec-17fd869b6f10}
    @Test()
    void deleteAccountWhenOptionalAccountNotIsPresentThrowsAccountNotFoundException() {
        /* Branches:
         * (!optionalAccount.isPresent()) : true
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        doReturn(Optional.empty()).when(accountRepositoryMock).findById("B");
        AccountNotFoundException accountNotFoundException = new AccountNotFoundException("Account not found with id: B");
        final AccountNotFoundException result = assertThrows(AccountNotFoundException.class, () -> {
            target.deleteAccount("B");
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(accountNotFoundException.getMessage()));
            verify(accountRepositoryMock).findById("B");
        });
    }

    //Sapient generated method id: ${52084373-1d16-379f-a643-22d247498fe6}
    @Test()
    void deleteAccountWhenOptionalAccountIsPresent() {
        /* Branches:
         * (!optionalAccount.isPresent()) : false
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        Account accountMock = mock(Account.class);
        doReturn(Optional.of(accountMock)).when(accountRepositoryMock).findById("id1");
        target.deleteAccount("id1");
        assertAll("result", () -> {
            verify(accountRepositoryMock).findById("id1");
            verify(accountRepositoryMock).delete(accountMock);
        });
    }

    //Sapient generated method id: ${cd589744-2767-3b96-b095-a58fa29f2b8c}
    @Test()
    void transactionsWhenUserRepositoryFindByAccountNumberSenderGetAccountNumberNotIsPresentThrowsException() throws Exception {
        /* Branches:
         * (userRepository.findByAccountNumber(sender.getAccountNumber()).isPresent()) : false
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        Account senderMock = mock(Account.class);
        doReturn("return_of_getAccountNumber1").when(senderMock).getAccountNumber();
        doReturn(Optional.empty()).when(userRepositoryMock).findByAccountNumber("return_of_getAccountNumber1");
        Account accountMock = mock(Account.class);
        Exception exception = new Exception("Invalid Account Details");
        final Exception result = assertThrows(Exception.class, () -> {
            target.transactions(senderMock, accountMock, Double.parseDouble("0.0"));
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(exception.getMessage()));
            verify(senderMock).getAccountNumber();
            verify(userRepositoryMock).findByAccountNumber("return_of_getAccountNumber1");
        });
    }

    //Sapient generated method id: ${0b830a5c-5e24-3f89-a64b-0e83ed8f5e7d}
    @Test()
    void transactionsWhenUserRepositoryFindByAccountNumberReceiverGetAccountNumberNotIsPresentThrowsException() throws Exception {
        /* Branches:
         * (userRepository.findByAccountNumber(sender.getAccountNumber()).isPresent()) : true
         * (userRepository.findByAccountNumber(receiver.getAccountNumber()).isPresent()) : false
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        Account senderMock = mock(Account.class);
        doReturn("return_of_getAccountNumber1").when(senderMock).getAccountNumber();
        Account receiverMock = mock(Account.class);
        doReturn("return_of_getAccountNumber1").when(receiverMock).getAccountNumber();
        Object objectMock = mock(Object.class);
        doReturn(Optional.of(objectMock), Optional.empty()).when(userRepositoryMock).findByAccountNumber("return_of_getAccountNumber1");
        Exception exception = new Exception("Invalid Account Details");
        final Exception result = assertThrows(Exception.class, () -> {
            target.transactions(senderMock, receiverMock, Double.parseDouble("0.0"));
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(exception.getMessage()));
            verify(senderMock).getAccountNumber();
            verify(receiverMock).getAccountNumber();
            verify(userRepositoryMock, times(2)).findByAccountNumber("return_of_getAccountNumber1");
        });
    }

    //Sapient generated method id: ${0d990467-f932-39a8-a9b2-39944e76f744}
//    @Test()
//    void transactionsWhenSenderGetBalanceGreaterThanOrEqualsToAmount() throws Exception {
//        /* Branches:
//         * (userRepository.findByAccountNumber(sender.getAccountNumber()).isPresent()) : true
//         * (userRepository.findByAccountNumber(receiver.getAccountNumber()).isPresent()) : true
//         * (sender.getBalance() >= amount) : true
//         */
//        target = new AccountServiceImpl();
//        autoCloseableMocks = MockitoAnnotations.openMocks(this);
//        Account senderMock = mock(Account.class);
//        doReturn(Double.parseDouble("0.0")).when(senderMock).getBalance();
//        doReturn("return_of_getAccountNumber1").when(senderMock).getAccountNumber();
//        Account receiverMock = mock(Account.class);
//        doReturn(Double.parseDouble("0.0")).when(receiverMock).getBalance();
//        doReturn("return_of_getAccountNumber1").when(receiverMock).getAccountNumber();
//        Object objectMock = mock(Object.class);
//        Object objectMock2 = mock(Object.class);
//        doReturn(Optional.of(objectMock), Optional.of(objectMock2)).when(userRepositoryMock).findByAccountNumber("return_of_getAccountNumber1");
//        Object objectMock3 = mock(Object.class);
//        doReturn(objectMock3).when(accountRepositoryMock).save(senderMock);
//        Object objectMock4 = mock(Object.class);
//        doReturn(objectMock4).when(accountRepositoryMock).save(receiverMock);
//        Transaction transactionMock = mock(Transaction.class);
//        doReturn(transactionMock).when(transactionServiceMock).createTransaction((Transaction) any());
//        target.transactions(senderMock, receiverMock, Double.parseDouble("0.0"));
//        assertAll("result", () -> {
//            verify(senderMock, times(2)).getAccountNumber();
//            verify(senderMock, times(2)).getBalance();
//            verify(senderMock).setBalance(Double.parseDouble("0.0"));
//            verify(receiverMock, times(2)).getAccountNumber();
//            verify(receiverMock).getBalance();
//            verify(receiverMock).setBalance(Double.parseDouble("0.0"));
//            verify(userRepositoryMock, times(2)).findByAccountNumber("return_of_getAccountNumber1");
//            verify(accountRepositoryMock).save(senderMock);
//            verify(accountRepositoryMock).save(receiverMock);
//            verify(transactionServiceMock).createTransaction((Transaction) any());
//        });
//    }

    //Sapient generated method id: ${cb8e2cdb-170b-3bec-a344-c248f1a84204}
    @Test()
    void transactionsWhenSenderGetBalanceLessThanAmountThrowsInsufficientBalanceException() throws Exception {
        /* Branches:
         * (userRepository.findByAccountNumber(sender.getAccountNumber()).isPresent()) : true
         * (userRepository.findByAccountNumber(receiver.getAccountNumber()).isPresent()) : true
         * (sender.getBalance() >= amount) : false
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        Account senderMock = mock(Account.class);
        doReturn("return_of_getAccountNumber1").when(senderMock).getAccountNumber();
        doReturn(Double.parseDouble("0.25")).when(senderMock).getBalance();
        Account receiverMock = mock(Account.class);
        doReturn("return_of_getAccountNumber1").when(receiverMock).getAccountNumber();
        Object objectMock = mock(Object.class);
        Object objectMock2 = mock(Object.class);
        doReturn(Optional.of(objectMock), Optional.of(objectMock2)).when(userRepositoryMock).findByAccountNumber("return_of_getAccountNumber1");
        InsufficientBalanceException insufficientBalanceException = new InsufficientBalanceException("You don't have enough balance");
        final InsufficientBalanceException result = assertThrows(InsufficientBalanceException.class, () -> {
            target.transactions(senderMock, receiverMock, Double.parseDouble("0.5"));
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(insufficientBalanceException.getMessage()));
            verify(senderMock).getAccountNumber();
            verify(senderMock).getBalance();
            verify(receiverMock).getAccountNumber();
            verify(userRepositoryMock, times(2)).findByAccountNumber("return_of_getAccountNumber1");
        });
    }

    //Sapient generated method id: ${ef15a26d-981e-3f2d-b837-750479ae8cd2}
    @Test()
    void updateBalanceWhenAccountIsNullThrowsAccountNotFoundException() {
        /* Branches:
         * (account != null) : false
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        doReturn(Optional.empty()).when(accountRepositoryMock).findByAccountNumber("A");
        AccountNotFoundException accountNotFoundException = new AccountNotFoundException("Account not found for user ID: A");
        final AccountNotFoundException result = assertThrows(AccountNotFoundException.class, () -> {
            target.updateBalance("A", Double.parseDouble("0.0"));
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(accountNotFoundException.getMessage()));
            verify(accountRepositoryMock).findByAccountNumber("A");
        });
    }

    //Sapient generated method id: ${7185d2ca-966d-3fce-a876-e0b58061009f}
    @Test()
    void getByAccountNumberWhenOptionalAccountNotIsPresentThrowsAccountNotFoundException() {
        /* Branches:
         * (!optionalAccount.isPresent()) : true
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        doReturn(Optional.empty()).when(accountRepositoryMock).findByAccountNumber("B");
        AccountNotFoundException accountNotFoundException = new AccountNotFoundException("Account not found with Account Number: B");
        final AccountNotFoundException result = assertThrows(AccountNotFoundException.class, () -> {
            target.getByAccountNumber("B");
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(accountNotFoundException.getMessage()));
            verify(accountRepositoryMock).findByAccountNumber("B");
        });
    }

    //Sapient generated method id: ${f0873986-d776-3779-a10f-3838df25d802}
    @Test()
    void getByAccountNumberWhenOptionalAccountIsPresent() {
        /* Branches:
         * (!optionalAccount.isPresent()) : false
         */
        target = new AccountServiceImpl();
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        Account accountMock = mock(Account.class);
        doReturn(Optional.of(accountMock)).when(accountRepositoryMock).findByAccountNumber("accountNumber1");
        Account result = target.getByAccountNumber("accountNumber1");
        assertAll("result", () -> {
            assertThat(result, equalTo(accountMock));
            verify(accountRepositoryMock).findByAccountNumber("accountNumber1");
        });
    }

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }
}
