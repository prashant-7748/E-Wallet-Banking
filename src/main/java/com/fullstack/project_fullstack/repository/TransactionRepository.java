package com.fullstack.project_fullstack.repository;

import com.fullstack.project_fullstack.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction,String> {


    List<Transaction> findBySenderAccountNumberOrReceiverAccountNumber(String senderAccountNumber, String receiverAccountNumber);

    List<Transaction> findBySenderAccountNumber(String senderAccountNumber);
    List<Transaction> findByReceiverAccountNumber(String receiverAccountNumber);
}
