package com.wallet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DigitalWalletApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Digital Wallet");
        
        // Show login page first
        showLoginPage();
        
        primaryStage.show();
    }

    public void showLoginPage() {
        LoginPage loginPage = new LoginPage(this);
        Scene scene = new Scene(loginPage, 400, 500);
        primaryStage.setScene(scene);
    }

    public void showCreateAccountPage() {
        CreateAccountPage createAccountPage = new CreateAccountPage(this);
        Scene scene = new Scene(createAccountPage, 400, 500);
        primaryStage.setScene(scene);
    }

    public void showDashboard() {
        Dashboard dashboard = new Dashboard(this);
        Scene scene = new Scene(dashboard, 800, 600);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}