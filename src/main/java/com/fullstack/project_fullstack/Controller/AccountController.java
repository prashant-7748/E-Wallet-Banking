package com.fullstack.project_fullstack.Controller;

import com.fullstack.project_fullstack.Services.AccountService;
import com.fullstack.project_fullstack.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id) {
        Account account = accountService.getAccountById(id);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }

    @PostMapping("")
    public ResponseEntity<Account> createAccount(@RequestBody Account account , String accountNumber) {
        account = accountService.createAccount(account);
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account with id " + id + " deleted successfully.");
    }


    @GetMapping("/{id}/balance")
    public double getBalance(@PathVariable String id) {
        return accountService.getBalance(id);
    }

    @PutMapping("/v2/{accountNumber}/{balance}")
    public void addMoney1(@PathVariable("accountNumber") String accountNumber, @PathVariable("balance") double newBalance) {
        accountService.addMoney(accountNumber, newBalance);
    }

    @GetMapping("/v1/{accountNumber}")
    public ResponseEntity<Account> getByAccountNumber(@PathVariable String accountNumber) {
        Account account = accountService.getByAccountNumber(accountNumber);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }

    @PutMapping("/transfer/{accountNumber}/to/{receiverAccountNumber}/amount/{amount}")
    public ResponseEntity<String> transferMoney(@PathVariable String accountNumber,@PathVariable String receiverAccountNumber,@PathVariable Double amount) throws Exception {

        Account sender = accountService.getByAccountNumber(accountNumber);
        Account receiver = accountService.getByAccountNumber(receiverAccountNumber);
        accountService.transactions(sender,receiver,amount);
        if (sender == null || receiver==null) {
          //  throw new Exception("Accouht not present");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Done");
    }


}
