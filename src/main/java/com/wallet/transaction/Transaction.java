package com.wallet.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final UUID id;
    private final TransactionType type;
    private final BigDecimal amount;
    private final LocalDateTime timestamp;
    private TransactionStatus status;

    public Transaction(TransactionType type, BigDecimal amount) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.status = TransactionStatus.PENDING;
    }

    // Getters
    public UUID getId() { return id; }
    public TransactionType getType() { return type; }
    public BigDecimal getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public TransactionStatus getStatus() { return status; }
    
    // Status can be updated
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}

public enum TransactionType {
    DEPOSIT, WITHDRAWAL
}

public enum TransactionStatus {
    PENDING, PROCESSING, COMPLETED, FAILED
}

public class TransactionResult {
    private final boolean success;
    private final String message;
    private final Transaction transaction;

    public TransactionResult(boolean success, String message, Transaction transaction) {
        this.success = success;
        this.message = message;
        this.transaction = transaction;
    }

    // Getters
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public Transaction getTransaction() { return transaction; }
}