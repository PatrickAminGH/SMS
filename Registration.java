package sms;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Registration {
    TextField firstName;
    TextField lastName;
    TextField email;
    PasswordField password;
    CheckBox rememberMe;
    Button submitBtn;
    Scene scene;

    Registration () {

        StackPane root = new StackPane();
        root.setStyle("""
                    -fx-background-color: linear-gradient(to bottom right, #142f54, #7d8c9c);
                """);
        root.setAlignment(Pos.CENTER);

        GridPane registerBox = new GridPane();
        registerBox.setVgap(20);
        registerBox.setPrefSize(420, 420);
        registerBox.setMaxSize(420, 420);
        registerBox.setPadding(new Insets(40));
        registerBox.setAlignment(Pos.CENTER);
        registerBox.setStyle("""
                    -fx-background-color: #fff;
                    -fx-background-radius: 16;
                """);

        DropShadow shadow = new DropShadow(30, Color.rgb(0, 0, 0, .4));
        shadow.setOffsetY(8);
        registerBox.setEffect(shadow);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);

        registerBox.getColumnConstraints().addAll(col1, col2);

        // title
        Label title = new Label("Register");
        GridPane.setColumnSpan(title, 2);
        GridPane.setHalignment(title, javafx.geometry.HPos.CENTER);
        title.setStyle("""
                    -fx-text-fill: #74a3df;
                    -fx-font-size: 32;
                    -fx-font-weight: bold;
                """);
        // first name
        firstName = new TextField();
        firstName.setPrefHeight(40);
        firstName.setPromptText("Enter your first name");
        GridPane.setColumnSpan(firstName, 2);

        // last name
        lastName = new TextField();
        lastName.setPrefHeight(40);
        lastName.setPromptText("Enter your last name");
        GridPane.setColumnSpan(lastName, 2);

        // email
        email = new TextField();
        email.setPrefHeight(40);
        email.setPromptText("Enter your email");
        GridPane.setColumnSpan(email, 2);

        // password
        password = new PasswordField();
        password.setPrefHeight(40);
        password.setPromptText("Enter your password");
        GridPane.setColumnSpan(password, 2);

        rememberMe = new CheckBox("Remember Me");

        submitBtn = new Button("Sign up");
        submitBtn.setPrefHeight(50);
        submitBtn.setPrefWidth(Double.MAX_VALUE);
        submitBtn.setStyle("""
                    -fx-background-color: #163055;
                    -fx-background-radius: 25;
                    -fx-font-size: 14;
                    -fx-text-fill: #fff;
                    -fx-font-weight: bold;
                """);
        GridPane.setColumnSpan(submitBtn, 2);

        registerBox.add(title, 0, 0);
        registerBox.add(firstName, 0, 1);
        registerBox.add(lastName, 0, 2);
        registerBox.add(email, 0, 3);
        registerBox.add(password, 0, 4);
        registerBox.add(rememberMe, 0, 5);
        registerBox.add(submitBtn, 0, 6);
        root.getChildren().add(registerBox);
        scene = new Scene(root);
    }
}
