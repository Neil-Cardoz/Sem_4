package org.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class ListViewDemo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // This is a listview
        ListView<String> subjects = new ListView<String>();
        subjects.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        subjects.getItems().add("JavaFX");
        subjects.getItems().add("Java");
        subjects.getItems().add("C++");
        subjects.getItems().add("Python");
        HBox hbox = new HBox(subjects);
        hbox.setSpacing(10);
        Scene scene = new Scene(hbox, 500, 500);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch();
    }
}