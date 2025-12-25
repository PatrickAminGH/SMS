package sms;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Toggle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        LinkedList<Student> students = new LinkedList<>();
        LinkedList<Subject> subjects = new LinkedList<>();
        subjects.add(new Subject("Math", 100, 3, "sunday", "1:30"));
        students.add(new Student("Patrick", "Male", "4343243242", "13/07/2006"));
        students.search(250610).data.setSubject(subjects.search(101).data);
        students.search(250610).data.setExam(subjects.search(101).data, "1:00", "Wednesday");
        students.search(250610).data.setGrade(subjects.search(101).data, 95.0);
        Login login = new Login();
        stage.setScene(login.scene);
        stage.setTitle("Login");
        stage.show();

        login.loginBtn.setOnAction(_ -> {
            try {
                int id = Integer.parseInt(login.id.getText());
                String password = login.password.getText();
                if (id == 2406232 ||
                        id == 2406241 ||
                        id == 2406003 ||
                        id == 2406238
                ) {
                    if (password.equals("Admin@" + id)) {
                        Admin admin = new Admin();
                        stage.hide();
                        stage.setScene(admin.scene);
                        stage.setTitle("Admin Panel");
                        stage.show();

                        admin.nextButton.setOnAction(_ -> {
                            Toggle selected = admin.group.getSelectedToggle();
                            if (selected != null) {
                                String action = selected.getUserData().toString();
                                switch (action) {
                                    case "ADD_STUDENT":
                                        AddStudent addStudent = new AddStudent();
                                        stage.hide();
                                        stage.setScene(addStudent.scene);
                                        stage.setTitle("Add Student");
                                        stage.show();
                                        addStudent.addBtn.setOnAction(_ -> {
                                            try {
                                                String firstName = addStudent.firstName.getText();
                                                String lastName = addStudent.lastName.getText();
                                                String nationalId = addStudent.nationalId.getText();
                                                Long.parseLong(nationalId);
                                                String gender = addStudent.gender.getValue();
                                                String birthData = addStudent.birthDate.getValue().toString();

                                                students.add(new Student(firstName + " " + lastName, gender, nationalId, birthData));
                                                stage.hide();
                                                stage.setScene(admin.scene);
                                                stage.setTitle("Admin Panel");
                                                stage.show();
                                            } catch (Exception exception) {
                                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                                alert.setTitle("Error");
                                                alert.setHeaderText(null);
                                                alert.setContentText("Something Went Wrong");
                                                alert.showAndWait();
                                            }
                                        });
                                        addStudent.backBtn.setOnAction(_-> {
                                            stage.hide();
                                            stage.setScene(admin.scene);
                                            stage.setTitle("Admin Panel");
                                            stage.show();
                                        });
                                        break;
                                    case "REMOVE_STUDENT":
                                        RemoveStudent removeStudent = new RemoveStudent();
                                        stage.hide();
                                        stage.setScene(removeStudent.scene);
                                        stage.setTitle("Remove Student");
                                        stage.show();
                                        removeStudent.removeBtn.setOnAction(_ -> {
                                            try {
                                                int studentId = Integer.parseInt(removeStudent.studentIdField.getText());
                                                students.remove(studentId);
                                                stage.hide();
                                                stage.setScene(admin.scene);
                                                stage.setTitle("Admin Panel");
                                                stage.show();
                                            } catch (Exception exception) {
                                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                                alert.setTitle("Error");
                                                alert.setHeaderText(null);
                                                alert.setContentText("Something Went Wrong");
                                                alert.showAndWait();
                                            }

                                        });
                                        break;
                                    case "ADD_SUBJECT":
                                        AddSubject addSubject = new AddSubject();
                                        stage.hide();
                                        stage.setScene(addSubject.getScene());
                                        stage.setTitle("Add Subject");
                                        stage.show();
                                        addSubject.addSubjectButton.setOnAction(_ -> {
                                            try {
                                                String subject = addSubject.subjectNameTextfield.getText();
                                                int grade = Integer.parseInt(addSubject.subjectGradeTextfield.getText());
                                                int creditHours = Integer.parseInt(addSubject.subjectCreditHourTextfield.getText());
                                                String day = addSubject.subjectDayTextfield.getText();
                                                String time = addSubject.subjectTimeTextfield.getText();
                                                subjects.add(new Subject(subject, grade, creditHours, day, time));
                                                stage.hide();
                                                stage.setScene(admin.scene);
                                                stage.setTitle("Admin Panel");
                                                stage.show();
                                            } catch (Exception exception) {
                                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                                alert.setTitle("Error");
                                                alert.setHeaderText(null);
                                                alert.setContentText("Something Went Wrong");
                                                alert.showAndWait();
                                            }
                                        });
                                        break;
                                    case "REMOVE_SUBJECT":
                                        RemoveSubject removeSubject = new RemoveSubject();
                                        stage.hide();
                                        stage.setScene(removeSubject.scene);
                                        stage.setTitle("Remove Student");
                                        stage.show();
                                        removeSubject.removeBtn.setOnAction(_ -> {
                                            try {
                                                int subjectId = Integer.parseInt(removeSubject.subjectIdField.getText());
                                                students.remove(subjectId);
                                                stage.hide();
                                                stage.setScene(admin.scene);
                                                stage.setTitle("Admin Panel");
                                                stage.show();
                                            } catch (Exception exception) {
                                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                                alert.setTitle("Error");
                                                alert.setHeaderText(null);
                                                alert.setContentText("Something Went Wrong");
                                                alert.showAndWait();
                                            }
                                        });
                                        break;
                                    case "SET_GRADES":
                                        AddGrades addGrades = new AddGrades();
                                        stage.hide();
                                        stage.setScene(addGrades.getScene());
                                        stage.setTitle("Set Grades");
                                        stage.show();
                                        addGrades.addGradeButton.setOnAction(_ -> {
                                            try {
                                                int studentId = Integer.parseInt(addGrades.studentIDTextfield.getText());
                                                int subjectId = Integer.parseInt(addGrades.subjectIDTextfield.getText());
                                                double grade = Double.parseDouble(addGrades.subjectGradeTextfield.getText());
                                                students.search(studentId).data.setGrade(subjects.search(subjectId).data, grade);
                                                students.remove(subjectId);
                                                stage.hide();
                                                stage.setScene(admin.scene);
                                                stage.setTitle("Admin Panel");
                                                stage.show();
                                            } catch (Exception exception) {
                                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                                alert.setTitle("Error");
                                                alert.setHeaderText(null);
                                                alert.setContentText("Something Went Wrong");
                                                alert.showAndWait();
                                            }
                                        });
                                        break;
                                    case "CREATE_EXAM_TABLE":
                                        AddExam addExam = new AddExam();
                                        stage.hide();
                                        stage.setScene(addExam.getScene());
                                        stage.setTitle("Add Exam");
                                        stage.show();
                                        addExam.addExamBtn.setOnAction(_-> {
                                            try {
                                                int stuId = Integer.parseInt(addExam.studentId.getText());
                                                int subId = Integer.parseInt(addExam.subjectId.getText());
                                                String examDay = addExam.day.getText();
                                                String examTime = addExam.time.getText();
                                                students.search(stuId).data.setExam(subjects.search(subId).data, examTime, examDay);
                                                stage.hide();
                                                stage.setScene(admin.scene);
                                                stage.setTitle("Admin Panel");
                                                stage.show();
                                            } catch (Exception exception) {
                                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                                alert.setTitle("Error");
                                                alert.setHeaderText(null);
                                                alert.setContentText("Something Went Wrong");
                                                alert.showAndWait();
                                            }
                                        });
                                        break;
                                    case "CREATE_SUBJECT_TABLE" :
                                        LinkedListQueue<Subject> sharedSubjects = new LinkedListQueue<>();
                                        AddSubjectTable addSubjectTable = new AddSubjectTable(sharedSubjects);
                                        stage.setTitle("Subjects Manager");
                                        stage.hide();
                                        stage.setScene(addSubjectTable.scene);
                                        stage.show();
                                }
                            }
                        });
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Password Is Wrong");
                        alert.showAndWait();
                    }
                } else {
                    Node<Student> student = students.search(id);
                    if (student != null) {
                        if (student.data.getPassword().equals(password)) {
                            StudentScene studentScene = new StudentScene();
                            stage.hide();
                            stage.setScene(studentScene.scene);
                            stage.setTitle("Home");
                            stage.show();
                            studentScene.nextButton.setOnAction(_ -> {
                                Toggle selected = studentScene.group.getSelectedToggle();
                                if (selected != null) {
                                    String action = selected.getUserData().toString();
                                    switch (action) {
                                        case "PERSONAL_INFORMATION":
                                            StudentProfileScene studentProfileScene = new StudentProfileScene(student.data);
                                            stage.hide();
                                            stage.setScene(studentProfileScene.scene);
                                            stage.setTitle("Personal Information");
                                            stage.show();
                                            studentProfileScene.backBtn.setOnAction(_-> {
                                                stage.hide();
                                                stage.setScene(studentScene.scene);
                                                stage.setTitle("Home");
                                                stage.show();
                                            });
                                            break;
                                        case "SUBJECTS_TABLE":
                                            Stage subjectsTableStage = new Stage();
                                            subjectsTableStage.setScene(student.data.getSubjectsTable());
                                            subjectsTableStage.setTitle("Subjects Table");
                                            subjectsTableStage.show();
                                            break;
                                        case "EXAMS_TABLE":
                                            Stage examsTableStage = new Stage();
                                            examsTableStage.setScene(student.data.getExamsTable());
                                            examsTableStage.setTitle("Exams Table");
                                            examsTableStage.show();
                                            break;
                                        case "GRADES":
                                            Stage gradesTableStage = new Stage();
                                            gradesTableStage.setScene(student.data.getGrade());
                                            gradesTableStage.setTitle("Grades");
                                            gradesTableStage.show();
                                            break;
                                    }
                                }
                            });
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setHeaderText(null);
                            alert.setContentText("Password Is Wrong");
                            alert.showAndWait();
                        }
                    }
                }
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Something Went Wrong");
                alert.showAndWait();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
