package com.wallet;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class LoginPage extends VBox {
    private final DigitalWalletApp app;

    public LoginPage(DigitalWalletApp app) {
        this.app = app;
        setupUI();
    }

    private void setupUI() {
        setSpacing(15);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Digital Wallet Login");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setMaxWidth(250);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMaxWidth(250);

        Button loginButton = new Button("Login");
        loginButton.setMaxWidth(250);
        loginButton.setOnAction(e -> handleLogin(usernameField.getText(), passwordField.getText()));

        Button createAccountButton = new Button("Create New Account");
        createAccountButton.setMaxWidth(250);
        createAccountButton.setOnAction(e -> app.showCreateAccountPage());

        getChildren().addAll(
            titleLabel,
            usernameField,
            passwordField,
            loginButton,
            new Separator(),
            createAccountButton
        );
    }

    private void handleLogin(String username, String password) {
        // Add authentication logic here
        // For now, just navigate to dashboard
        app.showDashboard();
    }
}