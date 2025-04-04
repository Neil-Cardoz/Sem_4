package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuItems extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("JavaFX Menu Example");

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Create Menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");
        Menu aboutMenu = new Menu("About");

        // File Menu Items
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> stage.close());  // Close application

        // Edit Menu Items
        MenuItem undoItem = new MenuItem("Undo");
        MenuItem redoItem = new MenuItem("Redo");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        MenuItem deleteItem = new MenuItem("Delete");

        // Help Menu Items
        MenuItem updateItem = new MenuItem("Check for Updates");
        MenuItem supportItem = new MenuItem("Contact Support");

        // About Menu Item
        MenuItem aboutUsItem = new MenuItem("Who are we?");

        // Add Items to Menus
        fileMenu.getItems().addAll(newItem, openItem, saveItem, new SeparatorMenuItem(), exitItem);
        editMenu.getItems().addAll(undoItem, redoItem, copyItem, pasteItem, deleteItem);
        helpMenu.getItems().addAll(updateItem, supportItem);
        aboutMenu.getItems().add(aboutUsItem);

        // Add Menus to MenuBar
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, aboutMenu);

        // Set up layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        // Create Scene
        Scene scene = new Scene(borderPane, 500, 500);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
}
