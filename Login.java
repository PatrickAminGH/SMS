package sms;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Login {

    public TextField id;
    public PasswordField password;
    public CheckBox rememberMe;
    public Button loginBtn;
    public Scene scene;

    public Login() {

        StackPane root = new StackPane();
        root.setStyle("""
            -fx-background-color: linear-gradient(to bottom right, #142f54, #7d8c9c);
        """);

        GridPane loginBox = new GridPane();
        loginBox.setPadding(new Insets(40));
        loginBox.setHgap(10);
        loginBox.setVgap(20);
        loginBox.setAlignment(Pos.CENTER);

        loginBox.setPrefSize(420, 420);
        loginBox.setMaxSize(420, 420);
        loginBox.setStyle("""
            -fx-background-color: white;
            -fx-background-radius: 16;
        """);

        // shadow
        DropShadow shadow = new DropShadow(30, Color.rgb(0, 0, 0, 0.4));
        shadow.setOffsetY(8);
        loginBox.setEffect(shadow);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);

        loginBox.getColumnConstraints().addAll(col1, col2);

        // title
        Label title = new Label("Login");
        title.setStyle("""
            -fx-font-size: 32px;
            -fx-font-weight: bold;
            -fx-text-fill: #74a3df;
        """);
        GridPane.setColumnSpan(title, 2);
        GridPane.setHalignment(title, javafx.geometry.HPos.CENTER);

        // email
        id = new TextField();
        id.setPromptText("Enter your ID");
        id.setPrefHeight(40);
        id.setMaxWidth(Double.MAX_VALUE);
        GridPane.setColumnSpan(id, 2);

        // password
        password = new PasswordField();
        password.setPromptText("Enter your password");
        password.setPrefHeight(40);
        password.setMaxWidth(Double.MAX_VALUE);
        GridPane.setColumnSpan(password, 2);

        // remember + forgot
        rememberMe = new CheckBox("Remember me");
        Label forgetPass = new Label("Forgot password?");
        forgetPass.setStyle("""
                    -fx-text-fill: #2f5fa7;
                """);

        GridPane.setHalignment(forgetPass, javafx.geometry.HPos.RIGHT);

        // button
        loginBtn = new Button("Login");
        loginBtn.setPrefHeight(40);
        loginBtn.setMaxWidth(Double.MAX_VALUE);
        GridPane.setColumnSpan(loginBtn, 2);

        loginBtn.setStyle("""
            -fx-background-color: #163055;
            -fx-text-fill: white;
            -fx-font-size: 14px;
            -fx-font-weight: bold;
            -fx-background-radius: 20;
        """);

        loginBox.add(title, 0, 0);
        loginBox.add(id, 0, 1);
        loginBox.add(password, 0, 2);
        loginBox.add(rememberMe, 0, 3);
        loginBox.add(forgetPass, 1, 3);
        loginBox.add(loginBtn, 0, 4);
        root.getChildren().add(loginBox);
        scene = new Scene(root, 900, 600);
    }
}
