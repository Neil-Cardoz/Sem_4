package org.example.app;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class AddMoney {
    public static Scene Scene1;

    public void start(Stage stage) {

        // Text field
        TextField CreditcardNo = new TextField();
        ;
        TextField Name = new TextField();
        TextField Money = new TextField();

        Button Add = new Button("Add Money");
        Button back = new Button("Back");
        Label error = new Label();

        VBox v = new VBox(10,CreditcardNo,Name, Money, Add, error);
        Scene Scene1 = new Scene(v, 600, 400);

        Add.setOnAction(e ->{
            //logic for add money
            String credit = CreditcardNo.getText();
            String name = Name.getText();
            String money = Money.getText();
            error.setText("Money Added");
            stage.setScene(Homepage.Scene);
            stage.show();

        });



        back.setOnAction(e ->{
            Homepage homepage = new Homepage();
            stage.setScene(Homepage.Scene);


        });




    }

    public void stage(Stage stage) {

    }
}
