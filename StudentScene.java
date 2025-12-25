package sms;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class StudentScene {

    ToggleGroup group;
    Button nextButton;
    Scene scene;

    public StudentScene() {

        // Radio Buttons
        RadioButton personalInformation = new RadioButton("View Personal Information");
        RadioButton subjectsTable = new RadioButton("View Subjects Table");
        RadioButton examsTable = new RadioButton("View Exams Table");
        RadioButton grades = new RadioButton("View Grades");

        // Toggle Group
        group = new ToggleGroup();
        personalInformation.setToggleGroup(group);
        personalInformation.setUserData("PERSONAL_INFORMATION");

        subjectsTable.setToggleGroup(group);
        subjectsTable.setUserData("SUBJECTS_TABLE");

        examsTable.setToggleGroup(group);
        examsTable.setUserData("EXAMS_TABLE");

        grades.setToggleGroup(group);
        grades.setUserData("GRADES");

        // Next Button
        nextButton = new Button("  Next  ");

        // GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40));
        grid.setHgap(100);
        grid.setVgap(20);
        grid.setAlignment(Pos.TOP_CENTER);

        // Left column
        grid.add(personalInformation, 0, 0);
        grid.add(subjectsTable, 0, 1);

        // Right column
        grid.add(examsTable, 1, 0);
        grid.add(grades, 1, 1);

        // Next button (bottom-right)
        grid.add(nextButton, 1, 2);
        GridPane.setHalignment(nextButton, HPos.RIGHT);

        // Scene
        scene = new Scene(grid);
    }
}
