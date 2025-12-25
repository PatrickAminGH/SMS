package com.example.dsproject4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        AddGrades addGrades = new AddGrades();

        Scene scene = addGrades.getScene();
        scene.getStylesheets().add(getClass().getResource("/Styles.css").toExternalForm()
        );

        stage.setScene(scene);
        stage.setTitle("Add Grades");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}