package com.fullstack.project_fullstack.Controller;

import com.fullstack.project_fullstack.Services.TransactionService;
import com.fullstack.project_fullstack.Services.TransactionServiceImpl;
import com.fullstack.project_fullstack.model.Transaction;
import com.fullstack.project_fullstack.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;
    @Autowired
    private TransactionServiceImpl transactionServiceImpl;
    @Autowired
    public TransactionController(TransactionRepository transactionRepository, TransactionService transactionService) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionRepository.save(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }



    @GetMapping("/{accountNumber}")
    public List<Transaction> getTransactionsByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return transactionService.getTransactionsByAccountNumber(accountNumber);
    }


    @GetMapping("/new/{accountNumber}")
    public List<Transaction> getTransactionsBySenderAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return transactionServiceImpl.getTransactionsBySenderAccountNumber(accountNumber);
    }



}
