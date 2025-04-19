package org.example.digitalwalletui;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.digitalwalletui.InvalidAmountException;
import org.example.digitalwalletui.TransferTimeoutException;

public class TransferController {
    @FXML private TextField amountField;
    @FXML private Button sendButton;
    @FXML private ProgressBar progressBar;

    @FXML
    protected void handleSend() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0) throw new InvalidAmountException("Amount must be positive!");

            Task<Void> transferTask = new Task<>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(3000); // Simulate network delay

                    if (amount > 10000) { // Simulate timeout for large amount
                        throw new TransferTimeoutException();
                    }
                    return null;
                }

                @Override
                protected void succeeded() {
                    Platform.runLater(() -> showSuccess("₹" + amount + " sent successfully!"));
                }

                @Override
                protected void failed() {
                    Platform.runLater(() -> showError(getException().getMessage()));
                }
            };

            progressBar.setVisible(true);
            new Thread(transferTask).start();

        } catch (InvalidAmountException | NumberFormatException e) {
            showError(e.getMessage());
        }
    }

    private void showError(String msg) {
        progressBar.setVisible(false);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void showSuccess(String msg) {
        progressBar.setVisible(false);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
