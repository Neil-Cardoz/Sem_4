package org.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button bt1 = new Button("Click Me");
        Button bt2 = new Button("Click Me");
        Button bt3 = new Button("Click Me");
        Button bt4 = new Button("Click Me");
        Button bt5 = new Button("Click Me");
        Button bt6 = new Button("Click Me");
        Button bt7 = new Button("Click Me");
        Button bt8 = new Button("Click Me");
        Button bt9 = new Button("Click Me");
        Button bt10 = new Button("Click Me");
        Button bt11 = new Button("Click Me");
        Button bt12 = new Button("Click Me");
        Button bt13 = new Button("Click Me");
//        GridPane root = new GridPane();
//        FlowPane flowPane = new FlowPane();
//        VBox vbox = new VBox();
//        HBox hbox = new HBox();
        // for BorderPane
        BorderPane root = new BorderPane();
        root.setBottom(bt1);
        root.setLeft(bt2);
        root.setRight(bt3);
//        root.setTop(bt4);
        root.setCenter(bt5);

//        root.setSpacing(50)
        // for GridPane
//        root.add(bt1, 0, 0);
//        root.add(bt2, 1, 1);
//        root.add(bt3, 2, 2);
//        root.setHgap(20);
//        root.setVgap(20);
        // for GridPane
//        root.getChildren().add(bt2);
//        root.getChildren().add(bt3);
//        root.getChildren().add(bt4);
//        root.getChildren().add(bt5);
//        root.getChildren().add(bt6);
//        root.getChildren().add(bt7);
//        root.getChildren().add(bt8);
//        root.getChildren().add(bt9);
//        root.getChildren().add(bt10);
//        root.getChildren().add(bt11);
//        root.getChildren().add(bt12);
//        root.getChildren().add(bt13);
        Scene sc = new Scene(root);
        stage.setScene(sc);
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setTitle("Hello World");
//        stage.setFullScreen(true);
        stage.setResizable(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}