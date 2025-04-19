package org.example.digitalwalletui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML
    protected void handleLogin() {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        if ("user".equals(user) && "1234".equals(pass)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("transfer.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setTitle("Send Money - Digital Wallet");
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            showError("Invalid credentials!");
        }
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
