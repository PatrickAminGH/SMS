package com.example.dsproject4;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class AddGrades {

    TextField studentIDTextfield;
    TextField subjectIDTextfield;
    TextField subjectGradeTextfield;

    Button addGradeButton;
    Label titleLabel;

    GridPane gridPane;
    StackPane root;

    AddGrades() {
        initControls();
        constructScene();
        applyStyle();
    }

    void initControls() {
        titleLabel = new Label("Add Grades");

        studentIDTextfield = new TextField();
        studentIDTextfield.setPromptText("Student ID");

        subjectIDTextfield = new TextField();
        subjectIDTextfield.setPromptText("Subject ID");

        subjectGradeTextfield = new TextField();
        subjectGradeTextfield.setPromptText("Subject Grade");

        addGradeButton = new Button("Add Grade");

        gridPane = new GridPane();
        root = new StackPane();
    }

    void constructScene() {
        // Add title
        gridPane.add(titleLabel, 1, 0);
        GridPane.setColumnSpan(titleLabel, GridPane.REMAINING);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        gridPane.add(studentIDTextfield, 1, 1,8,1);
        gridPane.add(subjectIDTextfield, 1, 2,8,1);
        gridPane.add(subjectGradeTextfield, 1, 3,8,1);

        gridPane.add(addGradeButton, 1, 5,8,1);
        GridPane.setHalignment(addGradeButton, HPos.CENTER);

        gridPane.setHgap(10);
        gridPane.setVgap(18);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40));

        gridPane.setPrefSize(480, 480);
        gridPane.setMaxSize(480, 480);

        root.getChildren().add(gridPane);
    }

    void applyStyle() {
        root.getStyleClass().add("root");
        gridPane.getStyleClass().add("box");

        studentIDTextfield.getStyleClass().add("field");
        subjectIDTextfield.getStyleClass().add("field");
        subjectGradeTextfield.getStyleClass().add("field");

        titleLabel.getStyleClass().add("title");
        addGradeButton.getStyleClass().add("button");
    }

    Scene getScene() {
        return new Scene(root, 900, 600);
    }
}