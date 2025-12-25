package sms;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class AddExam {

    TextField studentId;
    TextField subjectId;
    TextField day;
    TextField time;

    Button addExamBtn;
    Label titleLabel;

    GridPane gridPane;
    StackPane root;

    public AddExam() {
        initControls();
        constructScene();
        applyStyle();
    }

    void initControls() {

        titleLabel = new Label("Add Exam");

        studentId = new TextField();
        studentId.setPromptText("Student ID");

        subjectId = new TextField();
        subjectId.setPromptText("Subject ID");

        day = new TextField();
        day.setPromptText("Exam Day");

        time = new TextField();
        time.setPromptText("Exam Time");

        addExamBtn = new Button("Add Exam");

        gridPane = new GridPane();
        root = new StackPane();
    }

    void constructScene() {

        // Title
        gridPane.add(titleLabel, 0, 0, 2, 1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);

        // Fields
        gridPane.add(studentId, 0, 1, 2, 1);
        gridPane.add(subjectId, 0, 2, 2, 1);
        gridPane.add(day, 0, 3, 2, 1);
        gridPane.add(time, 0, 4, 2, 1);

        // Button
        gridPane.add(addExamBtn, 0, 5, 2, 1);
        GridPane.setHalignment(addExamBtn, HPos.CENTER);

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

        titleLabel.getStyleClass().add("title");
        addExamBtn.getStyleClass().add("primary-button");

        studentId.getStyleClass().add("field");
        subjectId.getStyleClass().add("field");
        day.getStyleClass().add("field");
        time.getStyleClass().add("field");
    }

    Scene getScene() {
        Scene scene = new Scene(root, 700, 600);
        scene.getStylesheets().add(
                getClass().getResource("/AddSubject.css").toExternalForm()
        );
        return scene;
    }
}
