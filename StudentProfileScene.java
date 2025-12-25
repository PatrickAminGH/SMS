package sms;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class StudentProfileScene {

    public Scene scene;
    public Button backBtn;
    private Label nameLabel, idLabel, nationalIdLabel, genderLabel;
    private ImageView profilePic;

    public StudentProfileScene(Student student) {

        StackPane root = new StackPane();
        root.setStyle("""
                -fx-background-color: linear-gradient(to bottom right, #142f54, #7d8c9c);
                """);

        VBox box = new VBox(20);
        box.setPadding(new Insets(40));
        box.setAlignment(Pos.CENTER);
        box.setPrefSize(480, 560);
        box.setMaxSize(480, 560);
        box.setStyle("""
                -fx-background-color: white;
                -fx-background-radius: 16;
                """);

        DropShadow shadow = new DropShadow(30, Color.rgb(0, 0, 0, 0.4));
        shadow.setOffsetY(8);
        box.setEffect(shadow);

        // ===== Profile Picture =====
        profilePic = new ImageView(new Image("/user.png"));
        profilePic.setFitHeight(120);
        profilePic.setFitWidth(120);
        profilePic.setPreserveRatio(true);
        profilePic.setStyle("-fx-border-radius: 60; -fx-background-radius: 60;");

        // ===== Student Info Labels =====
        nameLabel = new Label("Name: " + student.getName());
        nameLabel.setStyle("""
                -fx-font-size: 18px;
                -fx-font-weight: bold;
                -fx-text-fill: #163055;
                """);

        idLabel = new Label("Student ID: " + student.getId());
        idLabel.setStyle("""
                -fx-font-size: 16px;
                -fx-text-fill: #163055;
                """);

        nationalIdLabel = new Label("National ID: " + student.getNationalId());
        nationalIdLabel.setStyle("""
                -fx-font-size: 16px;
                -fx-text-fill: #163055;
                """);

        genderLabel = new Label("Gender: " + student.getGender());
        genderLabel.setStyle("""
                -fx-font-size: 16px;
                -fx-text-fill: #163055;
                """);

        // ===== Buttons =====

        backBtn = new Button("Go Back");
        backBtn.setPrefWidth(200);
        backBtn.setPrefHeight(40);
        backBtn.setStyle("""
                -fx-background-color: #7d8c9c;
                -fx-text-fill: white;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                -fx-background-radius: 20;
                """);

        // ===== Layout =====
        HBox buttonBox = new HBox(15, backBtn);
        buttonBox.setAlignment(Pos.CENTER);

        box.getChildren().addAll(profilePic, nameLabel, idLabel, nationalIdLabel, genderLabel, buttonBox);

        root.getChildren().add(box);
        scene = new Scene(root, 900, 600);
    }
}