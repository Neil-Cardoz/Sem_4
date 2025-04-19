package org.example.app;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Homepage {


    public static Scene Scene;

    public void stage(Stage stage) {
        stage.setTitle("Home Page");
        stage.setResizable(false);

        Button Add$ = new Button("Add Money");
        Add$.setOnAction(e -> {
            Scene Scene3 = AddMoney.Scene1;
            AddMoney am = new AddMoney();

            GotoAddMoney(Scene3);


        });
        Button Pay$ = new Button("Pay Money");
        Button CheckBal = new Button("Check Balance");
        Button ApplyLoan = new Button("Apply Loan");

        HBox hb1 = new HBox(10, Add$, Pay$);
        HBox hb2 = new HBox(10, CheckBal, ApplyLoan);

        VBox vbox = new VBox(10, hb1, hb2);
        vbox.setStyle("-fx-padding: 20px;");

        Scene scene = new Scene(vbox, 400, 200);

        stage.setScene(scene);
        stage.show();




    }

    private void GotoAddMoney(Scene scene3) {
        Scene Scene4 = AddMoney.Scene1;
        GotoAddMoney(Scene4);

    }


}
