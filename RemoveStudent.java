package sms;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RemoveStudent {
    Button removeBtn;
    TextField studentIdField;
    Scene scene;
    RemoveStudent() {
        Label title = new Label("Enter Student ID");
        title.setStyle("""
                -fx-font-size: 16px;
                -fx-font-weight: bold;
                -fx-text-fill: #163055;
                """);

        studentIdField = new TextField();
        studentIdField.setPromptText("Student ID");
        studentIdField.setMaxWidth(220);
        studentIdField.setStyle("""
                -fx-background-radius: 10;
                -fx-border-radius: 10;
                -fx-border-color: #163055;
                -fx-font-size: 13px;
                -fx-padding: 8;
                """);

        removeBtn = new Button("Remove");
        removeBtn.setPrefWidth(220);
        removeBtn.setStyle("""
                -fx-background-color: #163055;
                -fx-text-fill: white;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                -fx-background-radius: 20;
                """);

        VBox root = new VBox(18, title, studentIdField, removeBtn);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setStyle("""
                -fx-background-color: #f4f6f8;
                """);
        scene = new Scene(root, 360, 220);
    }


}