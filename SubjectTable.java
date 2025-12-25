package sms;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;


public class SubjectTable {
     private final TableView<Subject> table;
     Scene scene;

     SubjectTable() {
         table = new TableView<>();

         // Columns
         TableColumn<Subject, String> subject = new TableColumn<>("Subject");
         subject.setCellValueFactory(new PropertyValueFactory<>("subject"));

         TableColumn<Subject, Integer> id = new TableColumn<>("Subject Code");
         id.setCellValueFactory(new PropertyValueFactory<>("id"));

         TableColumn<Subject, Double> grade = new TableColumn<>("Grade");
         grade.setCellValueFactory(new PropertyValueFactory<>("grade"));

         TableColumn<Subject, Double> creditHours = new TableColumn<>("Credit Hours");
         creditHours.setCellValueFactory(new PropertyValueFactory<>("creditHours"));

         TableColumn<Subject, Day> day = new TableColumn<>("Day");
         day.setCellValueFactory(new PropertyValueFactory<>("day"));

         TableColumn<Subject, String> time = new TableColumn<>("Time");
         time.setCellValueFactory(new PropertyValueFactory<>("time"));

         //
         table.getColumns().addAll(subject, id, grade, creditHours, day, time);
         HBox hBox = new HBox(table);
         scene = new Scene(hBox);
     }

     public TableView<Subject> getTable() {
         return table;
     }
}
