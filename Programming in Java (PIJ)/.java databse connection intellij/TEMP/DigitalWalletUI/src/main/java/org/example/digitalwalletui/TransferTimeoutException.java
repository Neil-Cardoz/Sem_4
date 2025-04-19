package org.example.digitalwalletui;

public class TransferTimeoutException extends Exception {
    public TransferTimeoutException() {
        super("Transfer timed out. Please try again.");
    }
}
