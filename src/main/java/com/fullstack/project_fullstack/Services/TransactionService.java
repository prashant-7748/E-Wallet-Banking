package com.fullstack.project_fullstack.Services;

import com.fullstack.project_fullstack.model.Transaction;
import com.fullstack.project_fullstack.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();

    Transaction createTransaction(Transaction transaction);


   // Transaction createTransactionnew(Transaction transaction);
    List<Transaction> getTransactionsByAccountNumber(String accountNumber);




}
