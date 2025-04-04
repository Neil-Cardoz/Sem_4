package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        // Load the image
        FileInputStream input = new FileInputStream("C:\\Users\\Neil\\Downloads\\AS15-88-11866_-_Apollo_15_flag,_rover,_LM,_Irwin_-_restoration1.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        // Resize Image
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        // Create Button with Image
        Button button = new Button("Click me");
        button.setGraphic(imageView);

        // Create Label with Text
        Label lbl = new Label("Apollo 15 (July 26 – August 7, 1971) was the ninth crewed mission in the Apollo program and the fourth Moon landing. It was the first J mission, with a longer stay on the Moon and a greater focus on science than earlier landings. Apollo 15 saw the first use of the Lunar Roving Vehicle.");
        lbl.setTextAlignment(TextAlignment.JUSTIFY);
        lbl.setTextFill(Color.RED);
        lbl.setWrapText(true);
        lbl.setFont(new Font("Times New Roman", 20));

        // Layout with VBox
        VBox vb = new VBox(10, button, lbl); // VBox with spacing
        vb.setStyle("-fx-padding: 20px;"); // Add padding for better spacing

        // Create Scene and Show Stage
        Scene scene = new Scene(vb, 600, 700);
        stage.setScene(scene);
        stage.setTitle("Apollo 15 Mission");
        stage.show();
    }
}
