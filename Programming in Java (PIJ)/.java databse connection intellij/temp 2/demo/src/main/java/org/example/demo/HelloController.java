package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private Label LoginTxt;

    @FXML
    protected void onLoginButtonClick() {
        LoginTxt.setText("Login Button pressed!");
    }

    @FXML
    public void handleLogin(ActionEvent event) {
        try {
            // Transition to the Create Account view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateAccount.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Digital Wallet - Transfer");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
