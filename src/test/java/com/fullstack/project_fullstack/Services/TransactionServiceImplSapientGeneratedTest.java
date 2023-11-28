package com.fullstack.project_fullstack.Services;

import com.fullstack.project_fullstack.model.Transaction;
import com.fullstack.project_fullstack.repository.TransactionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TransactionServiceImplSapientGeneratedTest {

    @Mock(name = "transactionRepository")
    private TransactionRepository transactionRepositoryMock;

    private AutoCloseable autoCloseableMocks;

    @BeforeEach()
    public void beforeTest() {
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
    }

    //Sapient generated method id: ${a6a3096b-c45f-31bc-8154-d288e6290f4d}
    @Test()
    void getAllTransactionsTest() {
        TransactionServiceImpl target = new TransactionServiceImpl(transactionRepositoryMock);
        List<Transaction> transactionList = new ArrayList<>();
        doReturn(transactionList).when(transactionRepositoryMock).findAll();
        List<Transaction> result = target.getAllTransactions();
        assertAll("result", () -> {
            assertThat(result, equalTo(transactionList));
            verify(transactionRepositoryMock).findAll();
        });
    }

    //Sapient generated method id: ${f4903185-bd69-3d6e-9158-4847efc8c2db}
    @Test()
    void createTransactionTest() {
        TransactionServiceImpl target = new TransactionServiceImpl(transactionRepositoryMock);
        Transaction transactionMock = mock(Transaction.class);
        Transaction transactionMock2 = mock(Transaction.class);
        doReturn(transactionMock).when(transactionRepositoryMock).save(transactionMock2);
        Transaction result = target.createTransaction(transactionMock2);
        assertAll("result", () -> {
            assertThat(result, equalTo(transactionMock));
            verify(transactionRepositoryMock).save(transactionMock2);
        });
    }

    //Sapient generated method id: ${d888f95d-72d7-3817-b6b6-7f6d881f02b7}
    @Test()
    void getTransactionsBySenderAccountNumberWhenTransactionListIsEmptyThrowsRuntimeException() {
        /* Branches:
         * (TransactionList.isEmpty()) : true
         */
        TransactionServiceImpl target = new TransactionServiceImpl(transactionRepositoryMock);
        List<Transaction> transactionList = new ArrayList<>();
        doReturn(transactionList).when(transactionRepositoryMock).findBySenderAccountNumber("accountNumber1");
        RuntimeException runtimeException = new RuntimeException("Transactions Not Found");
        final RuntimeException result = assertThrows(RuntimeException.class, () -> {
            target.getTransactionsBySenderAccountNumber("accountNumber1");
        });
        assertAll("result", () -> {
            assertThat(result, is(notNullValue()));
            assertThat(result.getMessage(), equalTo(runtimeException.getMessage()));
            verify(transactionRepositoryMock).findBySenderAccountNumber("accountNumber1");
        });
    }

    //Sapient generated method id: ${9f9b8c32-1da2-32a8-9a0e-f3eb64e4f324}
    @Test()
    void getTransactionsBySenderAccountNumberWhenTransactionListNotIsEmpty() {
        /* Branches:
         * (TransactionList.isEmpty()) : false
         */
        TransactionServiceImpl target = new TransactionServiceImpl(transactionRepositoryMock);
        Transaction transactionMock = mock(Transaction.class);
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transactionMock);
        doReturn(transactionList).when(transactionRepositoryMock).findBySenderAccountNumber("accountNumber1");
        List<Transaction> result = target.getTransactionsBySenderAccountNumber("accountNumber1");
        assertAll("result", () -> {
            assertThat(result, equalTo(transactionList));
            verify(transactionRepositoryMock).findBySenderAccountNumber("accountNumber1");
        });
    }

    //Sapient generated method id: ${881a25d3-bc40-31f9-af45-669f3d8a41fc}
    @Test()
    void getTransactionsByAccountNumberTest() {
        TransactionServiceImpl target = new TransactionServiceImpl(transactionRepositoryMock);
        List<Transaction> transactionList = new ArrayList<>();
        doReturn(transactionList).when(transactionRepositoryMock).findBySenderAccountNumberOrReceiverAccountNumber("accountNumber1", "accountNumber1");
        List<Transaction> result = target.getTransactionsByAccountNumber("accountNumber1");
        assertAll("result", () -> {
            assertThat(result, equalTo(transactionList));
            verify(transactionRepositoryMock).findBySenderAccountNumberOrReceiverAccountNumber("accountNumber1", "accountNumber1");
        });
    }

    @AfterEach()
    public void afterTest() throws Exception {
        autoCloseableMocks.close();
    }
}
