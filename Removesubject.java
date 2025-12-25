package com.example.dsproject3;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Removesubject {

    TextField subjectIDTextfield;
    Button removeSubjectButton;
    Label titleLabel;

    GridPane gridPane;
    StackPane root;

    Removesubject() {
        initControls();
        constructScene();
        applyStyle();
    }

    void initControls() {

        titleLabel = new Label("Remove Subject");

        subjectIDTextfield = new TextField();
        subjectIDTextfield.setPromptText("Enter Subject ID");

        removeSubjectButton = new Button("Remove Subject");

        gridPane = new GridPane();
        root = new StackPane();
    }

    void constructScene() {

        // Title
        gridPane.add(titleLabel, 0, 0);
        GridPane.setColumnSpan(titleLabel, GridPane.REMAINING);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        // Subject ID field
        gridPane.add(subjectIDTextfield, 0, 1,8,1);

        // Remove button
        gridPane.add(removeSubjectButton, 0, 2,8,1);
        GridPane.setHalignment(removeSubjectButton, HPos.CENTER);

        gridPane.setHgap(10);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40));

        gridPane.setPrefSize(400, 300);
        gridPane.setMaxSize(400, 300);

        root.getChildren().add(gridPane);
    }

    void applyStyle() {
        root.getStyleClass().add("root");
        gridPane.getStyleClass().add("box");

        subjectIDTextfield.getStyleClass().add("field");
        removeSubjectButton.getStyleClass().add("button");
        titleLabel.getStyleClass().add("title");
    }

    Scene getScene() {
        return new Scene(root, 600, 400);
    }
}
