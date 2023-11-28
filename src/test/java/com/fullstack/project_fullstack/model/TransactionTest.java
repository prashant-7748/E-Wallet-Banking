package com.fullstack.project_fullstack.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {




    @Test
    public void testGettersAndSetters() {
        // Arrange
        String senderAccountNumber = "1234567890";
        String receiverAccountNumber = "0987654321";
        double amount = 1000.0;
        LocalDateTime timestamp = LocalDateTime.now();

        // Act
        Transaction transaction = new Transaction();
        transaction.setSenderAccountNumber(senderAccountNumber);
        transaction.setReceiverAccountNumber(receiverAccountNumber);
        transaction.setAmount(amount);
        transaction.setTimestamp(timestamp);

        // Assert
        Assertions.assertEquals(senderAccountNumber, transaction.getSenderAccountNumber());
        Assertions.assertEquals(receiverAccountNumber, transaction.getReceiverAccountNumber());
        Assertions.assertEquals(amount, transaction.getAmount());
        Assertions.assertEquals(Date.from(timestamp.atZone(ZoneId.systemDefault()).toInstant()), transaction.getTimestamp());
    }

    @Test
    public void testConstructor() {
        // Arrange
        String senderAccountNumber = "1234567890";
        String receiverAccountNumber = "0987654321";
        double amount = 1000.0;

        // Act
        Transaction transaction = new Transaction(senderAccountNumber, receiverAccountNumber, amount);

        // Assert
        Assertions.assertEquals(senderAccountNumber, transaction.getSenderAccountNumber());
        Assertions.assertEquals(receiverAccountNumber, transaction.getReceiverAccountNumber());
        Assertions.assertEquals(amount, transaction.getAmount());
        Assertions.assertNotNull(transaction.getTimestamp());
    }

    @Test
    public void testSetTimestamp() {
        // Arrange
        LocalDateTime timestamp = LocalDateTime.of(2023, 1, 1, 12, 0, 0);
        Date expectedDate = Date.from(timestamp.atZone(ZoneId.systemDefault()).toInstant());

        // Act
        Transaction transaction = new Transaction();
        transaction.setTimestamp(timestamp);

        // Assert
        Assertions.assertEquals(expectedDate, transaction.getTimestamp());
    }





@Test
    void getSenderAccountNumber() {
        // Arrange
        String senderAccountNumber = "1234567890";
        Transaction transaction = new Transaction();
        transaction.setSenderAccountNumber(senderAccountNumber);

        // Act
        String result = transaction.getSenderAccountNumber();

        // Assert
        Assertions.assertEquals(senderAccountNumber, result);
    }

    @Test
    void getSenderAccountNumber_Null() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setSenderAccountNumber(null);

        // Act
        String result = transaction.getSenderAccountNumber();

        // Assert
        Assertions.assertNull(result);
    }
    @Test
    void setSenderAccountNumber() {
        // Arrange
        String senderAccountNumber = "1234567890";
        Transaction transaction = new Transaction();

        // Act
        transaction.setSenderAccountNumber(senderAccountNumber);

        // Assert
        Assertions.assertEquals(senderAccountNumber, transaction.getSenderAccountNumber());
    }

    @Test
    void setSenderAccountNumber_Null() {
        // Arrange
        Transaction transaction = new Transaction();

        // Act
        transaction.setSenderAccountNumber(null);

        // Assert
        Assertions.assertNull(transaction.getSenderAccountNumber());
    }

    @Test
    void setSenderAccountNumber_EmptyString() {
        // Arrange
        String senderAccountNumber = "";
        Transaction transaction = new Transaction();

        // Act
        transaction.setSenderAccountNumber(senderAccountNumber);

        // Assert
        Assertions.assertEquals(senderAccountNumber, transaction.getSenderAccountNumber());
    }

    @Test
    void setSenderAccountNumber_Whitespace() {
        // Arrange
        String senderAccountNumber = "  ";
        Transaction transaction = new Transaction();

        // Act
        transaction.setSenderAccountNumber(senderAccountNumber);

        // Assert
        Assertions.assertEquals(senderAccountNumber, transaction.getSenderAccountNumber());
    }


    @Test
    void getReceiverAccountNumber() {
    }

    @Test
    void setReceiverAccountNumber() {
    }

    @Test
    void getAmount() {
    }

    @Test
    void setAmount() {
    }

    @Test
    void getTimestamp() {
    }

    @Test
    void setTimestamp() {
    }
}