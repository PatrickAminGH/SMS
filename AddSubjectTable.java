package sms;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddSubjectTable {

    public TableView<Subject> table;
    public Button addSubjectBtn, processQueueBtn, removeSubjectBtn;
    public Scene scene;

    private final LinkedListQueue<Subject> waitingQueue;
    private final LinkedListQueue<Subject> subjectQueue;
    private final ListView<String> waitingQueueView;

    public AddSubjectTable(LinkedListQueue<Subject> sharedSubjects) {
        this.subjectQueue = sharedSubjects;
        this.waitingQueue = new LinkedListQueue<>();
        this.waitingQueueView = new ListView<>();

        // ===== Root =====
        StackPane root = new StackPane();
        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #142f54, #7d8c9c);"
        );

        // ===== Card =====
        VBox card = new VBox(15);
        card.setPadding(new Insets(25));
        card.setAlignment(Pos.CENTER);
        card.setPrefSize(950, 550);
        card.setStyle("-fx-background-color: white; -fx-background-radius: 16;");

        DropShadow shadow = new DropShadow(30, Color.rgb(0, 0, 0, 0.4));
        shadow.setOffsetY(8);
        card.setEffect(shadow);

        // ===== Table =====
        table = new TableView<>();
        table.setPrefHeight(400);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Subject, String> colSubject = new TableColumn<>("Subject");
        colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<Subject, Integer> colId = new TableColumn<>("Subject Code");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Subject, Integer> colGrade = new TableColumn<>("Grade");
        colGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));

        TableColumn<Subject, Integer> colCredit = new TableColumn<>("Credit Hours");
        colCredit.setCellValueFactory(new PropertyValueFactory<>("creditHours"));

        TableColumn<Subject, String> colDay = new TableColumn<>("Day");
        colDay.setCellValueFactory(new PropertyValueFactory<>("day"));

        TableColumn<Subject, String> colTime = new TableColumn<>("Time");
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        table.getColumns().addAll(
                colSubject, colId, colGrade, colCredit, colDay, colTime
        );

        table.setStyle(
                "-fx-border-color: #163055;" +
                        "-fx-border-radius: 8;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-width: 1.5;"
        );

        // ===== Waiting Queue =====
        Label waitingLabel = new Label("Waiting Queue");
        waitingLabel.setStyle(
                "-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #163055;"
        );

        waitingQueueView.setPrefWidth(220);
        waitingQueueView.setStyle(
                "-fx-border-color: #163055;" +
                        "-fx-border-radius: 8;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-width: 1.5;"
        );

        VBox queueBox = new VBox(8, waitingLabel, waitingQueueView);
        queueBox.setAlignment(Pos.TOP_CENTER);

        // ===== Buttons =====
        addSubjectBtn = new Button("Add Subject");
        processQueueBtn = new Button("Process Queue");
        removeSubjectBtn = new Button("Remove Subject");

        styleBtn(addSubjectBtn);
        styleBtn(processQueueBtn);
        styleBtn(removeSubjectBtn);

        HBox buttons = new HBox(15, addSubjectBtn, processQueueBtn, removeSubjectBtn);
        buttons.setAlignment(Pos.CENTER);

        // ===== Layout =====
        HBox content = new HBox(15, table, queueBox);
        content.setAlignment(Pos.CENTER);

        card.getChildren().addAll(content, buttons);
        root.getChildren().add(card);

        scene = new Scene(root, 1000, 650);

        // ===== Button Actions =====
        addSubjectBtn.setOnAction(e -> showAddSubjectForm());
        processQueueBtn.setOnAction(e -> processWaitingQueue());
        removeSubjectBtn.setOnAction(e -> showRemoveSubjectForm());

        // Load existing subjects
        for (Subject s : subjectQueue.toList()) {
            table.getItems().add(s);
        }
        refreshWaitingQueue();
    }

    // ================== ADD SUBJECT ==================
    private void showAddSubjectForm() {
        AddSubject addForm = new AddSubject();

        addForm.addSubjectButton.setOnAction(e -> {
            try {
                String name = addForm.subjectNameTextfield.getText();
                int grade = Integer.parseInt(addForm.subjectGradeTextfield.getText());
                int credit = Integer.parseInt(addForm.subjectCreditHourTextfield.getText());
                String day = addForm.subjectDayTextfield.getText();
                String time = addForm.subjectTimeTextfield.getText();

                // ID is auto-generated inside Subject class
                Subject subject = new Subject(name, grade, credit, day, time);

                addToWaitingQueue(subject);
                addForm.root.getScene().getWindow().hide();

            } catch (NumberFormatException ex) {
                new Alert(
                        Alert.AlertType.ERROR,
                        "Grade and Credit Hours must be numbers!"
                ).showAndWait();
            }
        });

        Stage stage = new Stage();
        stage.setTitle("Add Subject");
        stage.setScene(addForm.getScene());
        stage.show();
    }


    // ================== PROCESS QUEUE ==================
    private void processWaitingQueue() {
        if (!waitingQueue.isEmpty()) {
            Subject subject = waitingQueue.dequeue();
            subjectQueue.enqueue(subject);
            table.getItems().add(subject);
            refreshWaitingQueue();
        }
    }

    // ================== REMOVE SUBJECT ==================
    private void showRemoveSubjectForm() {
        Stage stage = new Stage();

        Label title = new Label("Remove Subject");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField idField = new TextField();
        idField.setPromptText("Enter Subject ID");

        Button removeBtn = new Button("Remove Subject");
        styleBtn(removeBtn);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(40));
        grid.setVgap(20);
        grid.setHgap(10);

        grid.add(title, 0, 0);
        GridPane.setHalignment(title, HPos.CENTER);
        grid.add(idField, 0, 1);
        grid.add(removeBtn, 0, 2);
        GridPane.setHalignment(removeBtn, HPos.CENTER);

        Scene scene = new Scene(new StackPane(grid), 400, 250);

        removeBtn.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());

                table.getItems().removeIf(s -> s.getId() == id);
                subjectQueue.remove(id);
                waitingQueue.remove(id);
                refreshWaitingQueue();
                stage.close();

            } catch (NumberFormatException ex) {
                new Alert(
                        Alert.AlertType.ERROR,
                        "Enter a valid numeric ID!"
                ).showAndWait();
            }
        });

        stage.setTitle("Remove Subject");
        stage.setScene(scene);
        stage.show();
    }

    // ================== HELPERS ==================
    private void refreshWaitingQueue() {
        waitingQueueView.getItems().clear();
        for (Subject s : waitingQueue.toList()) {
            waitingQueueView.getItems().add(
                    s.getId() + " - " + s.getSubject()
            );
        }
    }

    private void styleBtn(Button btn) {
        btn.setStyle(
                "-fx-background-color: #163055;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 20;"
        );
    }

    public void addToWaitingQueue(Subject subject) {
        if (subject != null) {
            waitingQueue.enqueue(subject);
            refreshWaitingQueue();
        }
    }
}
