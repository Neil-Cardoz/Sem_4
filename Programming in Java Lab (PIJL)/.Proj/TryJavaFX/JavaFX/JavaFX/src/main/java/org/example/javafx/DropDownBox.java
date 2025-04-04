package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DropDownBox extends Application {  // ✅ Renamed to follow Java naming conventions

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Creating a ComboBox with Proper Generic Type
        ComboBox subjects = new ComboBox();
        subjects.getItems().addAll("English", "Computer", "Maths", "Physics");

        // VBox layout with padding & spacing
        VBox root = new VBox(10, subjects);  // 10px spacing
        root.setStyle("-fx-padding: 20px;"); // Adding padding for better layout

        // Scene & Stage setup
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Controls Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
