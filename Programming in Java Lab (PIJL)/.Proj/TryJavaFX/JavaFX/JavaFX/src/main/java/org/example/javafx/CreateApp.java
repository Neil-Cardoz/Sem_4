package org.example.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CreateApp extends Application {

    private Label balanceLabel = new Label("Balance: $1000.00");
    private ProgressBar spendingBar = new ProgressBar(0.7); // Example value
    private TableView<String> transactionTable = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Top Section
        Label welcomeLabel = new Label("Welcome, User!");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        VBox topBox = new VBox(5, welcomeLabel, balanceLabel);
        topBox.setPadding(new Insets(10));

        // Center Buttons
        Button addExpenseBtn = new Button("Add Expense");
        Button addIncomeBtn = new Button("Add Income");
        Button setLimitBtn = new Button("Set Monthly Limit");
        Button viewReportBtn = new Button("View Report");

        VBox buttonBox = new VBox(10, addExpenseBtn, addIncomeBtn, setLimitBtn, viewReportBtn);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setStyle("-fx-background-color: #f0f0f0;");

        // Bottom Section - Progress and Table
        Label limitLabel = new Label("Monthly Spending Limit Usage");
        VBox bottomBox = new VBox(5, limitLabel, spendingBar, new Label("Recent Transactions"), transactionTable);
        bottomBox.setPadding(new Insets(10));

        // Logout button at the bottom
        Button logoutBtn = new Button("Logout");
        logoutBtn.setMaxWidth(Double.MAX_VALUE);

        VBox mainBox = new VBox(10, topBox, buttonBox, bottomBox, logoutBtn);

        ScrollPane scrollPane = new ScrollPane(mainBox);
        scrollPane.setFitToWidth(true);

        BorderPane borderPane = new BorderPane(scrollPane);

        Scene scene = new Scene(borderPane, 350, 500);
        stage.setTitle("Digital Wallet");
        stage.setScene(scene);
        stage.show();
    }
}