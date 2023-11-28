package com.fullstack.project_fullstack.Services;

import com.fullstack.project_fullstack.model.Transaction;
import com.fullstack.project_fullstack.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsBySenderAccountNumber(String accountNumber) {
        List<Transaction> TransactionList = new ArrayList<>();
        TransactionList= transactionRepository.findBySenderAccountNumber(accountNumber);
        if(TransactionList.isEmpty())
            throw new RuntimeException("Transactions Not Found");
       // return transactionRepository.findBySenderAccountNumber(accountNumber);
        return TransactionList;
    }

//    @Override
//    public Transaction createTransactionnew(Transaction transaction) {
//        return transactionRepository.save(transaction);
//    }

    @Override
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
        return transactionRepository.findBySenderAccountNumberOrReceiverAccountNumber(accountNumber, accountNumber);
    }

}
