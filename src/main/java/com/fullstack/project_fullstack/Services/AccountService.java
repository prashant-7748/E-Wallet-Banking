package com.fullstack.project_fullstack.Services;

import com.fullstack.project_fullstack.model.Account;

import java.util.List;

public interface AccountService {

    double getBalance(String id);
   // void updateBalance(String account, double amount);

    //void transfer(String fromAccount, String toAccount, double amount);

    List<Account> getAllAccounts();

    Account getAccountById(String id);

    Account createAccount(Account account );

     //Account updateAccount(Account account);

    void deleteAccount(String id);

   // Account recharge(String id, double balance);

    //double getBalance(String id);

    void addMoney(String accountNumber, double amount);
    void updateBalance(String accountNumber, double newBalance);


    Account getByAccountNumber(String accountNumber);

    public void transactions(Account sender,Account receiver,Double amount) throws Exception;
}
