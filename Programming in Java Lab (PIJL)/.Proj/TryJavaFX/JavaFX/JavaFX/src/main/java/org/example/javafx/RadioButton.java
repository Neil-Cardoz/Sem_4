
package org.example.javafx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class RadioButton extends Application{
    public static void main(String[] args){

        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lbl = new Label("Select your Favourite Subject");
        ToggleGroup toggle = new ToggleGroup();
        javafx.scene.control.RadioButton bt1 = new javafx.scene.control.RadioButton("English");
        javafx.scene.control.RadioButton bt2 = new javafx.scene.control.RadioButton("chemistry");
        javafx.scene.control.RadioButton bt3 = new javafx.scene.control.RadioButton("Maths");
        javafx.scene.control.RadioButton bt4 = new javafx.scene.control.RadioButton("Computer Science");
        bt1.setToggleGroup(toggle);
        bt2.setToggleGroup(toggle);
        bt3.setToggleGroup(toggle);
        bt4.setToggleGroup(toggle);
        VBox root = new VBox();
        //we need to add this button to this layout
        root.getChildren().add(lbl);
        root.getChildren().addAll(bt1,bt2,bt3,bt4);
        //we need to add this layout to a scene
        Scene sc = new Scene(root);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setTitle("Radio Button Demo");
        primaryStage.setScene(sc);
        primaryStage.show();

    }
}