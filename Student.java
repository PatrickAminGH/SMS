package sms;

import javafx.scene.Scene;

import java.time.LocalDate;

public class Student extends Person implements Identifiable{
    private int id;
    private final GradesTable grades;
    private final SubjectTable subjectTable;
    private final ExamTable examTable;
    private final String password;
    private static int counter = 250610;
    Student(String name, String gender, String nationalId, String birthDate) {
        super(name, gender, nationalId, birthDate);
        subjectTable = new SubjectTable();
        examTable = new ExamTable();
        this.id = counter++;
        this.grades = new GradesTable();
        this.password = name + "@" + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(Subject subject) {
        subjectTable.getTable().getItems().add(subject);
    }

    public Scene getSubjectsTable() {
        return subjectTable.scene;
    }

    public void setExam(Subject subject, String time, String day) {
        examTable.getTable().getItems().add(new Exam(subject, time, day));
    }

    public Scene getExamsTable() {
        return examTable.scene;
    }

    public void setGrade(Subject subject, Double grade) {
        grades.getTable().getItems().add(new Grade(subject, grade));
    }

    public Scene getGrade() {
        return grades.scene;
    }

    public String getPassword() {
        return password;
    }
}
