package com.wallet;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CreateAccountPage extends VBox {
    private final DigitalWalletApp app;

    public CreateAccountPage(DigitalWalletApp app) {
        this.app = app;
        setupUI();
    }

    private void setupUI() {
        setSpacing(15);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Create New Account");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");
        nameField.setMaxWidth(250);

        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        emailField.setMaxWidth(250);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setMaxWidth(250);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMaxWidth(250);

        Button createButton = new Button("Create Account");
        createButton.setMaxWidth(250);
        createButton.setOnAction(e -> handleCreateAccount());

        Button backButton = new Button("Back to Login");
        backButton.setMaxWidth(250);
        backButton.setOnAction(e -> app.showLoginPage());

        getChildren().addAll(
            titleLabel,
            nameField,
            emailField,
            usernameField,
            passwordField,
            createButton,
            new Separator(),
            backButton
        );
    }

    private void handleCreateAccount() {
        // Add account creation logic here
        // For now, just navigate back to login
        app.showLoginPage();
    }
}