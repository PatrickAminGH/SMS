package sms;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;


public class GradesTable {
    private final TableView<Grade> table;
    Scene scene;

    GradesTable() {
        table = new TableView<>();

        // Columns
        TableColumn<Grade, String> subject = new TableColumn<>("Subject");
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<Grade, Integer> id = new TableColumn<>("Subject Code");
        id.setCellValueFactory(new PropertyValueFactory<>("subjectId"));

        TableColumn<Grade, Integer> subjectGrade = new TableColumn<>("Subject Grade");
        subjectGrade.setCellValueFactory(new PropertyValueFactory<>("subjectGrade"));

        TableColumn<Grade, Integer> creditHours = new TableColumn<>("Credit Hours");
        creditHours.setCellValueFactory(new PropertyValueFactory<>("creditHours"));

        TableColumn<Grade, Double> grade = new TableColumn<>("Student Grade");
        grade.setCellValueFactory(new PropertyValueFactory<>("grade"));

        //
        table.getColumns().addAll(subject, id, subjectGrade, creditHours, grade);
        HBox hBox = new HBox(table);
        scene = new Scene(hBox);
    }

    public TableView<Grade> getTable() {
        return table;
    }
}
