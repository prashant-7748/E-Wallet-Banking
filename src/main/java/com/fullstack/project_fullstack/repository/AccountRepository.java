package com.fullstack.project_fullstack.repository;

import com.fullstack.project_fullstack.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account,String> {
   Optional<Account> findByAccountNumber(String accountNumber);
  // Account getAccountById(String id);
}
