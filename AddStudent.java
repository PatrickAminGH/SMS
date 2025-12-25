package sms;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AddStudent {

    public TextField firstName;
    public TextField lastName;
    public TextField nationalId;
    public ComboBox<String> gender; // ComboBox for the dropdown
    public DatePicker birthDate;
    public Button addBtn;
    public Button clearBtn;
    public Button backBtn;
    public Scene scene;

    private Label resultLabel;

    //hashset to prevent duplicate IDs
    private static final Set<Integer> usedIds = new HashSet<>();
    private static final Random random = new Random();

    public AddStudent() {

        StackPane root = new StackPane();
        root.setStyle("""
                    -fx-background-color: linear-gradient(to bottom right, #142f54, #7d8c9c);
                """);

        GridPane box = new GridPane();
        box.setPadding(new Insets(40));
        box.setHgap(10);
        box.setVgap(18);
        box.setAlignment(Pos.CENTER);

        box.setPrefSize(480, 500);
        box.setMaxSize(480, 500);
        box.setStyle("""
                    -fx-background-color: white;
                    -fx-background-radius: 16;
                """);

        // shadow
        DropShadow shadow = new DropShadow(30, Color.rgb(0, 0, 0, 0.4));
        shadow.setOffsetY(8);
        box.setEffect(shadow);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setPercentWidth(50);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPercentWidth(50);
        box.getColumnConstraints().addAll(c1, c2);

        // ===== Title =====
        Label title = new Label("Add Student");
        title.setStyle("""
                    -fx-font-size: 32px;
                    -fx-font-weight: bold;
                    -fx-text-fill: #74a3df;
                """);
        GridPane.setColumnSpan(title, 2);
        GridPane.setHalignment(title, javafx.geometry.HPos.CENTER);

        // ===== Fields =====
        firstName = new TextField();
        firstName.setPromptText("First name");
        firstName.setPrefHeight(40);

        lastName = new TextField();
        lastName.setPromptText("Last name");
        lastName.setPrefHeight(40);

        GridPane.setColumnSpan(firstName, 1);
        GridPane.setColumnSpan(lastName, 1);

        nationalId = new TextField();
        nationalId.setPromptText("National ID");
        nationalId.setPrefHeight(40);
        GridPane.setColumnSpan(nationalId, 2);

        gender = new ComboBox<>();
        gender.getItems().addAll("Male", "Female");
        gender.setPromptText("Student Gender");
        gender.setPrefHeight(40);
        GridPane.setColumnSpan(gender, 2);

        birthDate = new DatePicker();
        birthDate.setPromptText("Student Birthdate:");
        birthDate.setPrefHeight(40);
        GridPane.setColumnSpan(birthDate, 2);

        // ===== Result =====
        resultLabel = new Label();
        resultLabel.setStyle("""
                    -fx-text-fill: #163055;
                    -fx-font-size: 14px;
                    -fx-font-weight: bold;
                """);
        GridPane.setColumnSpan(resultLabel, 2);
        GridPane.setHalignment(resultLabel, javafx.geometry.HPos.CENTER);

        // ===== Button =====
        addBtn = new Button("Add Student");
        addBtn.setPrefHeight(40);
        addBtn.setPrefWidth(120);

        clearBtn = new Button("Clear Fields");
        clearBtn.setPrefHeight(40);
        clearBtn.setPrefWidth(120);

        backBtn = new Button("Go back");
        backBtn.setPrefHeight(40);
        backBtn.setPrefWidth(120);

        backBtn.setStyle("""
                    -fx-background-color: #7d8c9c;
                    -fx-text-fill: white;
                    -fx-font-size: 14px;
                    -fx-font-weight: bold;
                    -fx-background-radius: 20;
                """);

        clearBtn.setStyle("""
                    -fx-background-color: #a3a3a3;
                    -fx-text-fill: white;
                    -fx-font-size: 13px;
                    -fx-font-weight: bold;
                    -fx-background-radius: 20;
                """);

        addBtn.setStyle("""
                    -fx-background-color: #163055;
                    -fx-text-fill: white;
                    -fx-font-size: 14px;
                    -fx-font-weight: bold;
                    -fx-background-radius: 20;
                """);

        clearBtn.setOnAction(e -> clearInputs());

        // ===== Layout =====
        box.add(title, 0, 0);
        box.add(firstName, 0, 1);
        box.add(lastName, 1, 1);
        box.add(nationalId, 0, 2);
        box.add(gender, 0, 4);
        box.add(birthDate, 0, 5);

        // Create an HBox for buttons to align them properly
        HBox buttonBox = new HBox(15); // 15px spacing between buttons
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(addBtn, clearBtn, backBtn);

        // Add the button HBox to grid (spans 2 columns)
        box.add(buttonBox, 0, 6, 2, 1);

        // Add result label
        box.add(resultLabel, 0, 7, 2, 1);

        root.getChildren().add(box);
        scene = new Scene(root, 900, 600);
    }

    // Clearing all inputs in the data field
    private void clearInputs() {
        firstName.clear();
        lastName.clear();
        nationalId.clear();
        gender.setValue(null);
        birthDate.setValue(null);
        resultLabel.setText("");
    }
}