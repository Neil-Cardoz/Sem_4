package org.example.wallet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class basicGui extends Application
{
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;


    @Override
    public void start(Stage stage) throws Exception {

        BorderPane layoutManager = new BorderPane();



        Scene scene = new Scene(layoutManager, WIDTH, HEIGHT);

        layoutManager.setCenter(new Label("Hello World!"));
        layoutManager.setLeft(new Button("click me"));

        stage.setScene(scene);
        stage.setTitle("Welcome to Wallet Application");
        stage.centerOnScreen();
        stage.show();







    }


    public static void main(String[] args) {
        launch(args);
    }
}
