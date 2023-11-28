package com.fullstack.project_fullstack.Services;

import com.fullstack.project_fullstack.Controller.TransactionController;
import com.fullstack.project_fullstack.exception.AccountNotFoundException;
import com.fullstack.project_fullstack.exception.InsufficientBalanceException;
import com.fullstack.project_fullstack.model.Account;
import com.fullstack.project_fullstack.model.Transaction;
import com.fullstack.project_fullstack.repository.AccountRepository;
import com.fullstack.project_fullstack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private  AccountService accountService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    TransactionController transactionController;


    @Override
    public double getBalance(String account) {
        Optional<Account> optionalAccount = accountRepository.findByAccountNumber(account);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get().getBalance();
        } else {
            throw new RuntimeException("Account not found.");
        }
    }


    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


    public Account getAccountById(String id) {

        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (!optionalAccount.isPresent()) {
            throw new AccountNotFoundException("Account not found with id: " + id);
        }
        return optionalAccount.get();
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(String id) {

        Optional<Account> optionalAccount = accountRepository.findById(id);
        if (!optionalAccount.isPresent()) {
            throw new AccountNotFoundException("Account not found with id: " + id);
        }
        accountRepository.delete(optionalAccount.get());
    }

    public void transactions(Account sender,Account receiver,Double amount) throws Exception {

        if (userRepository.findByAccountNumber(sender.getAccountNumber()).isPresent() && userRepository.findByAccountNumber(receiver.getAccountNumber()).isPresent()) {

            if (sender.getBalance() >= amount) {

                sender.setBalance(sender.getBalance()-amount);
                receiver.setBalance(receiver.getBalance()+amount);

                accountRepository.save(sender);
                accountRepository.save(receiver);

                Transaction transaction = new Transaction(sender.getAccountNumber(),receiver.getAccountNumber(),amount);
                transactionService.createTransaction(transaction);
               // transactionController.createTransaction(transaction);
            } else
                throw new InsufficientBalanceException("You don't have enough balance");

        }        else
            throw new Exception("Invalid Account Details");

    }

    public void addMoney(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber).orElse(null);
        if (account != null) {
            double currentBalance = account.getBalance();
            account.setBalance(currentBalance + amount);

            //transactionService.createTransaction(transaction);
            accountRepository.save(account);

            Transaction transaction = new Transaction();
            transaction.setSenderAccountNumber(accountNumber);
            transaction.setReceiverAccountNumber("Self Deposit");
            transaction.setAmount(amount);
           // transaction.setTimestamp(LocalDateTime.now());
            transactionService.createTransaction(transaction);

        } else {
            throw new AccountNotFoundException("Account not found for user ID: " + accountNumber);
        }
    }

    @Override
    public void updateBalance(String accountNumber, double newBalance) {
        Account account = accountRepository.findByAccountNumber(accountNumber).orElse(null);
        if (account != null) {
            account.setBalance(newBalance);
            accountRepository.save(account);
        } else {
            throw new AccountNotFoundException("Account not found for user ID: " + accountNumber);
        }
    }


    public Account getByAccountNumber(String accountNumber) {

        Optional<Account> optionalAccount = accountRepository.findByAccountNumber(accountNumber);
        if (!optionalAccount.isPresent()) {
            throw new AccountNotFoundException("Account not found with Account Number: " + accountNumber);
        }
        return optionalAccount.get();
    }

}
