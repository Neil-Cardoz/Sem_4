package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CreateController {

    @FXML
    private Label UserSuccess;

    @FXML
    private Label UserFail;

    // Optionally, you can also inject TextField controls if you need to read user input
    // @FXML private TextField firstNameField;
    // @FXML private TextField lastNameField;
    // @FXML private TextField phoneNumberField;
    // @FXML private TextField emailField;

    @FXML
    public void handleLoginCreateAccount(ActionEvent event) {
        // Process the user creation logic (validation, saving, etc.)
        // For demonstration, we simply set a success message.
        UserSuccess.setText("User created successfully!");
        UserFail.setText("");

        // Optionally, transition to another view, such as the login view.
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Login Page");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            UserFail.setText("Error switching to login view.");
        }
    }
}
