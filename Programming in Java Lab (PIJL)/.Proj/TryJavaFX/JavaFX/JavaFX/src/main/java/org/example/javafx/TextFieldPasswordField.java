package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TextFieldPasswordField extends Application {

    @Override
    public void start(Stage stage) {

        // Create a Text Field
        TextField tf = new TextField();
        tf.setPromptText("Enter Username");  // Placeholder text

        // Create a Password Field
        PasswordField pf = new PasswordField();
        pf.setPromptText("Enter Password");

        // Create a Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String username = tf.getText();
            String password = pf.getText();
            insertIntoDatabase(username, password);
        });

        // VBox layout with padding & spacing
        VBox root = new VBox(10, tf, pf, submitButton);  // Added button to layout
        root.setStyle("-fx-padding: 20px;");

        // Scene & Stage setup
        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setTitle("UserID and Password Field");
        stage.show();
    }

    private void insertIntoDatabase(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/userdb";  // Database URL
        String user = "root";  // Change this to your MySQL username
        String pass = "Weinachten01@";      // Change this to your MySQL password

        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("User added successfully!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
