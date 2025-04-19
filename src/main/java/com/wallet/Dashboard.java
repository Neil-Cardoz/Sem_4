package com.wallet;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;

public class Dashboard extends BorderPane {
    private final DigitalWalletApp app;
    private Label balanceLabel;
    private double currentBalance = 0.0;

    public Dashboard(DigitalWalletApp app) {
        this.app = app;
        setupUI();
    }

    private void setupUI() {
        // Top section with balance
        VBox topSection = new VBox(10);
        topSection.setAlignment(Pos.CENTER);
        topSection.setPadding(new Insets(20));
        
        Label welcomeLabel = new Label("Welcome to Your Digital Wallet");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        balanceLabel = new Label(String.format("Current Balance: $%.2f", currentBalance));
        balanceLabel.setStyle("-fx-font-size: 18px;");
        
        topSection.getChildren().addAll(welcomeLabel, balanceLabel);
        setTop(topSection);

        // Center section with operation buttons
        GridPane operationsGrid = new GridPane();
        operationsGrid.setAlignment(Pos.CENTER);
        operationsGrid.setHgap(20);
        operationsGrid.setVgap(20);
        operationsGrid.setPadding(new Insets(20));

        Button addMoneyBtn = createOperationButton("Add Money", "deposit");
        Button payBtn = createOperationButton("Pay/Send", "payment");
        Button investBtn = createOperationButton("Invest", "investment");
        Button historyBtn = createOperationButton("Transaction History", "history");

        operationsGrid.add(addMoneyBtn, 0, 0);
        operationsGrid.add(payBtn, 1, 0);
        operationsGrid.add(investBtn, 0, 1);
        operationsGrid.add(historyBtn, 1, 1);

        setCenter(operationsGrid);

        // Bottom section with logout
        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> app.showLoginPage());
        
        BorderPane bottomSection = new BorderPane();
        bottomSection.setPadding(new Insets(20));
        bottomSection.setRight(logoutBtn);
        setBottom(bottomSection);
    }

    private Button createOperationButton(String text, String operation) {
        Button button = new Button(text);
        button.setMinSize(150, 100);
        button.setStyle("-fx-font-size: 16px;");
        
        button.setOnAction(e -> handleOperation(operation));
        return button;
    }

    private void handleOperation(String operation) {
        switch (operation) {
            case "deposit":
                showDepositDialog();
                break;
            case "payment":
                showPaymentDialog();
                break;
            case "investment":
                showInvestmentDialog();
                break;
            case "history":
                showTransactionHistory();
                break;
        }
    }

    private void showDepositDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Money");
        dialog.setHeaderText("Enter amount to deposit:");
        dialog.showAndWait().ifPresent(amount -> {
            try {
                double depositAmount = Double.parseDouble(amount);
                currentBalance += depositAmount;
                updateBalance();
            } catch (NumberFormatException e) {
                showAlert("Invalid amount entered");
            }
        });
    }

    private void showPaymentDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Make Payment");
        dialog.setHeaderText("Enter amount to pay:");
        dialog.showAndWait().ifPresent(amount -> {
            try {
                double paymentAmount = Double.parseDouble(amount);
                if (paymentAmount <= currentBalance) {
                    currentBalance -= paymentAmount;
                    updateBalance();
                } else {
                    showAlert("Insufficient funds");
                }
            } catch (NumberFormatException e) {
                showAlert("Invalid amount entered");
            }
        });
    }

    private void showInvestmentDialog() {
        // Add investment functionality
        showAlert("Investment feature coming soon!");
    }

    private void showTransactionHistory() {
        // Add transaction history functionality
        showAlert("Transaction history feature coming soon!");
    }

    private void updateBalance() {
        balanceLabel.setText(String.format("Current Balance: $%.2f", currentBalance));
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}