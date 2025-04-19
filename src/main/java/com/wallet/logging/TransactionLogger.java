package com.wallet;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.math.BigDecimal;

public class Wallet {
    // Using AtomicReference for thread-safe balance updates
    private final AtomicReference<BigDecimal> balance;
    // Lock for complex operations that can't be handled by simple atomic operations
    private final ReentrantLock operationLock;
    private final TransactionProcessor transactionProcessor;
    
    public Wallet(BigDecimal initialBalance) {
        this.balance = new AtomicReference<>(initialBalance);
        this.operationLock = new ReentrantLock();
        this.transactionProcessor = new TransactionProcessor();
    }

    public BigDecimal getBalance() {
        return balance.get();
    }

    public TransactionResult deposit(BigDecimal amount) {
        try {
            return transactionProcessor.processTransaction(
                new Transaction(TransactionType.DEPOSIT, amount)
            ).get();
        } catch (Exception e) {
            return new TransactionResult(false, "Deposit failed: " + e.getMessage());
        }
    }

    public TransactionResult withdraw(BigDecimal amount) {
        try {
            return transactionProcessor.processTransaction(
                new Transaction(TransactionType.WITHDRAWAL, amount)
            ).get();
        } catch (Exception e) {
            return new TransactionResult(false, "Withdrawal failed: " + e.getMessage());
        }
    }

    public void shutdown() {
        transactionProcessor.shutdown();
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


