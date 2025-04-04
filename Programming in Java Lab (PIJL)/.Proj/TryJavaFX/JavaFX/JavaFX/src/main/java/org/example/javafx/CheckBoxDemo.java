package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxDemo extends Application {  // ✅ Renamed class

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Label lbl = new Label("Select all your Favourite Subjects");
        Hyperlink yt = new Hyperlink("www.youtube.com");

        // Creating CheckBox buttons
        CheckBox opt1 = new CheckBox("English");
        CheckBox opt2 = new CheckBox("Chemistry");
        CheckBox opt3 = new CheckBox("Computer Science");
        CheckBox opt4 = new CheckBox("DBMS");

        // Creating a submit button
        Button submitButton = new Button("Submit");

        // Layout
        VBox root = new VBox(10, lbl, opt1, opt2, opt3, opt4, yt, submitButton);
        root.setStyle("-fx-padding: 20px;");

        // Scene and Stage
        Scene sc = new Scene(root, 500, 500);
        primaryStage.setTitle("CheckBox Demo");
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
