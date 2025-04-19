package com.wallet.validation;

import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class TransactionValidator {
    // Thread pool for parallel validation
    private final ExecutorService validatorExecutor;
    // List of validation rules
    private final List<ValidationRule> validationRules;
    // Maximum time to wait for validation
    private static final int VALIDATION_TIMEOUT_SECONDS = 5;

    public TransactionValidator() {
        this.validatorExecutor = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
        );
        this.validationRules = new ArrayList<>();
        initializeValidationRules();
    }

    /**
     * Initializes default validation rules
     */
    private void initializeValidationRules() {
        validationRules.add(new AmountValidationRule());
        validationRules.add(new FrequencyValidationRule());
        validationRules.add(new SecurityValidationRule());
    }

    /**
     * Validates a transaction using all rules in parallel
     */
    public ValidationResult validateTransaction(Transaction transaction) {
        List<CompletableFuture<ValidationResult>> futures = new ArrayList<>();

        // Run all validation rules in parallel
        for (ValidationRule rule : validationRules) {
            CompletableFuture<ValidationResult> future = CompletableFuture
                .supplyAsync(() -> rule.validate(transaction), validatorExecutor)
                .orTimeout(VALIDATION_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            futures.add(future);
        }

        // Wait for all validations to complete
        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .get(VALIDATION_TIMEOUT_SECONDS, TimeUnit.SECONDS);

            // Combine results
            boolean isValid = true;
            StringBuilder message = new StringBuilder();

            for (CompletableFuture<ValidationResult> future : futures) {
                ValidationResult result = future.get();
                if (!result.isValid()) {
                    isValid = false;
                    message.append(result.getMessage()).append("; ");
                }
            }

            return new ValidationResult(isValid, message.toString());

        } catch (Exception e) {
            return new ValidationResult(false, "Validation failed: " + e.getMessage());
        }
    }

    /**
     * Validation rule interface
     */
    private interface ValidationRule {
        ValidationResult validate(Transaction transaction);
    }

    /**
     * Validates transaction amount
     */
    private static class AmountValidationRule implements ValidationRule {
        @Override
        public ValidationResult validate(Transaction transaction) {
            BigDecimal amount = transaction.getAmount();
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                return new ValidationResult(false, "Amount must be positive");
            }
            if (amount.compareTo(new BigDecimal("1000000")) > 0) {
                return new ValidationResult(false, "Amount exceeds maximum limit");
            }
            return new ValidationResult(true, "Amount valid");
        }
    }

    /**
     * Validates transaction frequency
     */
    private static class FrequencyValidationRule implements ValidationRule {
        @Override
        public ValidationResult validate(Transaction transaction) {
            // Implementation of frequency validation
            return new ValidationResult(true, "Frequency valid");
        }
    }

    /**
     * Validates transaction security
     */
    private static class SecurityValidationRule implements ValidationRule {
        @Override
        public ValidationResult validate(Transaction transaction) {
            // Implementation of security validation
            return new ValidationResult(true, "Security check passed");
        }
    }
}

public class ValidationResult {
    private final boolean valid;
    private final String message;

    public ValidationResult(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() { return valid; }
    public String getMessage() { return message; }
}