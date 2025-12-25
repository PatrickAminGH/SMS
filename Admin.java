package sms;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class Admin {

    ToggleGroup group;
    Button nextButton;
    Scene scene;

    public Admin() {

        // Radio Buttons
        RadioButton addStudent = new RadioButton("Add Student");
        RadioButton removeStudent = new RadioButton("Remove Student");
        RadioButton addSubject = new RadioButton("Add Subject");
        RadioButton removeSubject = new RadioButton("Remove Subject");
        RadioButton createSubjectTable = new RadioButton("Create Subject Table");
        RadioButton createExamTable = new RadioButton("Create Exam Table");
        RadioButton setGrades = new RadioButton("Set Grades");

        // Toggle Group
        group = new ToggleGroup();
        addStudent.setToggleGroup(group);
        addStudent.setUserData("ADD_STUDENT");

        removeStudent.setToggleGroup(group);
        removeStudent.setUserData("REMOVE_STUDENT");

        addSubject.setToggleGroup(group);
        addSubject.setUserData("ADD_SUBJECT");

        removeSubject.setToggleGroup(group);
        removeSubject.setUserData("REMOVE_SUBJECT");

        createSubjectTable.setToggleGroup(group);
        createSubjectTable.setUserData("CREATE_SUBJECT_TABLE");

        createExamTable.setToggleGroup(group);
        createExamTable.setUserData("CREATE_EXAM_TABLE");

        setGrades.setToggleGroup(group);
        setGrades.setUserData("SET_GRADES");

        // Next Button
        nextButton = new Button("  Next  ");

        // GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40));
        grid.setHgap(100);
        grid.setVgap(20);
        grid.setAlignment(Pos.TOP_CENTER);

        // Left column
        grid.add(addStudent, 0, 0);
        grid.add(addSubject, 0, 1);
        grid.add(createSubjectTable, 0, 2);
        grid.add(setGrades, 0, 3);

        // Right column
        grid.add(removeStudent, 1, 0);
        grid.add(removeSubject, 1, 1);
        grid.add(createExamTable, 1, 2);

        // Next button (bottom-right)
        grid.add(nextButton, 1, 3);
        GridPane.setHalignment(nextButton, HPos.RIGHT);

        // Scene
        scene = new Scene(grid);
    }
}
