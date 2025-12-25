package sms;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class ExamTable {
    private final TableView<Exam> table;
    Scene scene;
    ExamTable () {
        table = new TableView<>();
        TableColumn<Exam, String> subject = new TableColumn<>("Subject");
        subject.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<Exam, Integer> subjectId = new TableColumn<>("Subject ID");
        subjectId.setCellValueFactory(new PropertyValueFactory<>("subjectId"));

        TableColumn<Exam, String> seatNumber = new TableColumn<>("Seat Number");
        seatNumber.setCellValueFactory(new PropertyValueFactory<>("seatNumber"));

        TableColumn<Exam, String> day = new TableColumn<>("Day");
        day.setCellValueFactory(new PropertyValueFactory<>("day"));

        TableColumn<Exam, String> time = new TableColumn<>("Time");
        time.setCellValueFactory(new PropertyValueFactory<>("time"));

        table.getColumns().addAll(subject, subjectId, day, time);
        HBox hBox = new HBox(table);
        scene = new Scene(hBox);
    }

    public TableView<Exam> getTable() {
        return table;
    }
}
