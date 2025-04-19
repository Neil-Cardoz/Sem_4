package org.example.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Custom Exceptions
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidLoanAmountException extends Exception {
    public InvalidLoanAmountException(String message) {
        super(message);
    }
}

public class App extends Application {
    private Stage primaryStage;
    private Scene loginScene, homeScene, addMoneyScene, payMoneyScene, checkBalanceScene, applyLoanScene;
    private String dbUrl = "jdbc:mysql://localhost:3306/userdb";
    private String dbUser = "root";
    private String dbPass = "Weinachten01@";
    private int currentUserId; // assume user id is int

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Banking App");

        initLoginScene();
        initHomeScene();
        initAddMoneyScene();
        initPayMoneyScene();
        initCheckBalanceScene();
        initApplyLoanScene();

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void initLoginScene() {
        TextField tfUser = new TextField();
        tfUser.setPromptText("Username");
        PasswordField pf = new PasswordField();
        pf.setPromptText("Password");
        Label lblMsg = new Label();
        Button btnLogin = new Button("Login");
        btnLogin.setOnAction(e -> {
            String user = tfUser.getText(), pass = pf.getText();
            Task<Void> loginTask = new Task<>() {
                @Override protected Void call() throws Exception {
                    // simulate DB check
                    try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                         PreparedStatement stmt = conn.prepareStatement(
                                 "SELECT id FROM users WHERE username=? AND password=?")) {
                        stmt.setString(1, user);
                        stmt.setString(2, pass);
                        ResultSet rs = stmt.executeQuery();
                        if (rs.next()) {
                            currentUserId = rs.getInt("id");
                        } else {
                            throw new Exception("Invalid credentials");
                        }
                    }
                    Platform.runLater(() -> primaryStage.setScene(homeScene));
                    return null;
                }
            };
            loginTask.setOnFailed(evt -> Platform.runLater(
                    () -> lblMsg.setText(loginTask.getException().getMessage())));
            new Thread(loginTask).start();
        });

        VBox vbox = new VBox(10, tfUser, pf, btnLogin, lblMsg);
        vbox.setPadding(new Insets(20));
        loginScene = new Scene(vbox, 400, 200);
    }

    private void initHomeScene() {
        Button btnAdd = new Button("Add Money");
        btnAdd.setOnAction(e -> primaryStage.setScene(addMoneyScene));
        Button btnPay = new Button("Pay Money");
        btnPay.setOnAction(e -> primaryStage.setScene(payMoneyScene));
        Button btnCheck = new Button("Check Balance");
        btnCheck.setOnAction(e -> primaryStage.setScene(checkBalanceScene));
        Button btnLoan = new Button("Apply Loan");
        btnLoan.setOnAction(e -> primaryStage.setScene(applyLoanScene));

        VBox vbox = new VBox(10, btnAdd, btnPay, btnCheck, btnLoan);
        vbox.setPadding(new Insets(20));
        homeScene = new Scene(vbox, 400, 250);
    }

    private void initAddMoneyScene() {
        TextField tfCard = new TextField(); tfCard.setPromptText("Card Number");
        TextField tfName = new TextField(); tfName.setPromptText("Name on Card");
        TextField tfAmt = new TextField(); tfAmt.setPromptText("Amount");
        Label lblStatus = new Label();
        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(e -> {
            Task<Void> task = new Task<>() {
                @Override protected Void call() throws Exception {
                    double amt = Double.parseDouble(tfAmt.getText());
                    if (amt <= 0) throw new IllegalArgumentException("Amount must be positive");
                    try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                         PreparedStatement stmt = conn.prepareStatement(
                                 "UPDATE users SET balance = balance + ? WHERE id=?")) {
                        stmt.setDouble(1, amt);
                        stmt.setInt(2, currentUserId);
                        stmt.executeUpdate();
                    }
                    Platform.runLater(() -> lblStatus.setText("Added ₹" + amt));
                    return null;
                }
            };
            task.setOnFailed(evt -> Platform.runLater(
                    () -> lblStatus.setText(task.getException().getMessage())));
            new Thread(task).start();
        });
        Button btnBack = new Button("Back");
        btnBack.setOnAction(e -> primaryStage.setScene(homeScene));

        VBox vbox = new VBox(10, tfCard, tfName, tfAmt, btnAdd, btnBack, lblStatus);
        vbox.setPadding(new Insets(20));
        addMoneyScene = new Scene(vbox, 400, 300);
    }

    private void initPayMoneyScene() {
        TextField tfPayTo = new TextField(); tfPayTo.setPromptText("Recipient Username");
        TextField tfPayAmt = new TextField(); tfPayAmt.setPromptText("Amount");
        Label lblStatus = new Label();
        Button btnPay = new Button("Pay");
        btnPay.setOnAction(e -> {
            Task<Void> task = new Task<>() {
                @Override protected Void call() throws Exception {
                    double amt = Double.parseDouble(tfPayAmt.getText());
                    if (amt <= 0) throw new IllegalArgumentException("Amount must be positive");
                    try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
                        // check balance
                        PreparedStatement check = conn.prepareStatement(
                                "SELECT balance FROM users WHERE id=?");
                        check.setInt(1, currentUserId);
                        ResultSet rs = check.executeQuery();
                        if (rs.next()) {
                            double bal = rs.getDouble("balance");
                            if (bal < amt) throw new InsufficientFundsException("Insufficient funds");
                        }
                        // transfer
                        PreparedStatement withdraw = conn.prepareStatement(
                                "UPDATE users SET balance=balance-? WHERE id=?");
                        withdraw.setDouble(1, amt); withdraw.setInt(2, currentUserId);
                        withdraw.executeUpdate();
                        PreparedStatement deposit = conn.prepareStatement(
                                "UPDATE users SET balance=balance+? WHERE username=?");
                        deposit.setDouble(1, amt); deposit.setString(2, tfPayTo.getText());
                        deposit.executeUpdate();
                    }
                    Platform.runLater(() -> lblStatus.setText("Paid ₹" + amt));
                    return null;
                }
            };
            task.setOnFailed(evt -> Platform.runLater(
                    () -> lblStatus.setText(task.getException().getMessage())));
            new Thread(task).start();
        });
        Button btnBack = new Button("Back");
        btnBack.setOnAction(e -> primaryStage.setScene(homeScene));

        VBox vbox = new VBox(10, tfPayTo, tfPayAmt, btnPay, btnBack, lblStatus);
        vbox.setPadding(new Insets(20));
        payMoneyScene = new Scene(vbox, 400, 300);
    }

    private void initCheckBalanceScene() {
        Label lblBalance = new Label();
        Button btnCheck = new Button("Refresh Balance");
        Button btnBack = new Button("Back");
        btnCheck.setOnAction(e -> {
            Task<Void> task = new Task<>() {
                @Override protected Void call() throws Exception {
                    double bal;
                    try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                         PreparedStatement stmt = conn.prepareStatement(
                                 "SELECT balance FROM users WHERE id=?")) {
                        stmt.setInt(1, currentUserId);
                        ResultSet rs = stmt.executeQuery();
                        if (!rs.next()) throw new Exception("User not found");
                        bal = rs.getDouble("balance");
                    }
                    Platform.runLater(() -> lblBalance.setText("Balance: ₹" + bal));
                    return null;
                }
            };
            task.setOnFailed(evt -> Platform.runLater(
                    () -> lblBalance.setText(task.getException().getMessage())));
            new Thread(task).start();
        });
        btnBack.setOnAction(e -> primaryStage.setScene(homeScene));
        VBox vbox = new VBox(10, btnCheck, lblBalance, btnBack);
        vbox.setPadding(new Insets(20));
        checkBalanceScene = new Scene(vbox, 300, 200);
    }

    private void initApplyLoanScene() {
        TextField tfLoanAmt = new TextField(); tfLoanAmt.setPromptText("Loan Amount");
        Label lblStatus = new Label();
        Button btnApply = new Button("Apply");
        btnApply.setOnAction(e -> {
            Task<Void> task = new Task<>() {
                @Override protected Void call() throws Exception {
                    double loan = Double.parseDouble(tfLoanAmt.getText());
                    if (loan <= 0) throw new InvalidLoanAmountException("Loan must be positive");
                    // simple eligibility: balance must be > 1000
                    double bal;
                    try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                         PreparedStatement stmt = conn.prepareStatement(
                                 "SELECT balance FROM users WHERE id=?")) {
                        stmt.setInt(1, currentUserId);
                        ResultSet rs = stmt.executeQuery();
                        rs.next(); bal = rs.getDouble("balance");
                    }
                    if (bal < 1000) throw new Exception("Minimum balance ₹1000 required");
                    // simulate loan grant
                    Platform.runLater(() -> lblStatus.setText("Loan ₹" + loan + " approved"));
                    return null;
                }
            };
            task.setOnFailed(evt -> Platform.runLater(
                    () -> lblStatus.setText(task.getException().getMessage())));
            new Thread(task).start();
        });
        Button btnBack = new Button("Back");
        btnBack.setOnAction(e -> primaryStage.setScene(homeScene));
        VBox vbox = new VBox(10, tfLoanAmt, btnApply, btnBack, lblStatus);
        vbox.setPadding(new Insets(20));
        applyLoanScene = new Scene(vbox, 350, 220);
    }
}
