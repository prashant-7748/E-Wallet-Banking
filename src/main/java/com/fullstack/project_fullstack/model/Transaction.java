package com.fullstack.project_fullstack.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Transaction {


    private String senderAccountNumber;

    //private String type;

    private String receiverAccountNumber;
    private double amount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timestamp;

    // Constructors, getters, and setters

    public Transaction() {
        this.timestamp = new Date();
    }

    public Transaction(String senderAccountNumber, String receiverAccountNumber, double amount) {

        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.timestamp = new Date();
    }


    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }
public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = Date.from(timestamp.atZone(ZoneId.systemDefault()).toInstant());
}
}
