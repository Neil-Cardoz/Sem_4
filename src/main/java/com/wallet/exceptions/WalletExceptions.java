package com.wallet.exceptions;

public class WalletExceptions {
    public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    public static class InvalidAmountException extends Exception {
        public InvalidAmountException(String message) {
            super(message);
        }
    }

    public static class AuthenticationException extends Exception {
        public AuthenticationException(String message) {
            super(message);
        }
    }

    public static class TransactionFailedException extends Exception {
        public TransactionFailedException(String message) {
            super(message);
        }
    }
}