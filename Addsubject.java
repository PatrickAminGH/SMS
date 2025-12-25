package com.example.dsproject;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Addsubject {

    TextField subjectNameTextfield;
    TextField subjectCreditHourTextfield;
    TextField subjectIDTextfield;
    TextField subjectGradeTextfield;
    DatePicker datePicker;
    TextField subjectTimeTextfield;

    Button addSubjectButton;
    Label titleLabel;

    GridPane gridPane;
    StackPane root;

    Addsubject() {
        initControls();
        constructScene();
        applyStyle();
    }

    void initControls() {

        titleLabel = new Label("Add Subject");

        subjectNameTextfield = new TextField();
        subjectNameTextfield.setPromptText("subject Name");

        subjectCreditHourTextfield = new TextField();
        subjectCreditHourTextfield.setPromptText("Credit Hours");

        subjectIDTextfield = new TextField();
        subjectIDTextfield.setPromptText("Subject ID");

        subjectGradeTextfield = new TextField();
        subjectGradeTextfield.setPromptText("Subject Grade");

        datePicker = new DatePicker();
        datePicker.setPromptText("Subject Day");

        subjectTimeTextfield = new TextField();
        subjectTimeTextfield.setPromptText("Subject Time");

        addSubjectButton = new Button("Add Subject");

        gridPane = new GridPane();
        root = new StackPane();
    }

    void constructScene() {

        // Add title
        gridPane.add(titleLabel, 1, 0);
        GridPane.setColumnSpan(titleLabel, GridPane.REMAINING); // span all columns
        GridPane.setHalignment(titleLabel, HPos.CENTER);        // center horizontally

        gridPane.add(subjectNameTextfield, 1, 1);
        gridPane.add(subjectCreditHourTextfield, 1, 2);
        gridPane.add(subjectIDTextfield, 1, 3);

        gridPane.add(subjectGradeTextfield, 7, 2);
        gridPane.add(datePicker, 7, 3);
        gridPane.add(subjectTimeTextfield, 7, 1);

        gridPane.add(addSubjectButton, 0, 5,8,1);
        GridPane.setHalignment(addSubjectButton, HPos.CENTER);

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

        subjectNameTextfield.getStyleClass().add("field");
        subjectCreditHourTextfield.getStyleClass().add("field");
        subjectIDTextfield.getStyleClass().add("field");
        subjectGradeTextfield.getStyleClass().add("field");
        subjectTimeTextfield.getStyleClass().add("field");
        datePicker.getStyleClass().add("field");

        titleLabel.getStyleClass().add("title");
    }

    Scene getScene() {
        return new Scene(root, 900, 600);
    }
}
