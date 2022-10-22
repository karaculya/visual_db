package main.java.com.example.visual_db;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField professionField;
    @FXML
    private TextField ageField;
    @FXML
    private TableView studentsTable;
    @FXML
    private TextField surField;
    @FXML
    private Label statusLabel;

    public void initializeStudentsTable() {
        TableColumn idColumn = new TableColumn("Номер");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn surnameColumn = new TableColumn("Фамилия");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        TableColumn nameColumn = new TableColumn("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn professionColumn = new TableColumn("Профессия");
        professionColumn.setCellValueFactory(new PropertyValueFactory<>("profession"));
        TableColumn ageColumn = new TableColumn("Возраст");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        studentsTable.getColumns().addAll(idColumn,surnameColumn,nameColumn,professionColumn,ageColumn);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onButtonOneClick() {
        int id = Integer.parseInt(idField.getText());
        int age = Integer.parseInt(ageField.getText());
        Student student = new Student(id, surnameField.getText(),
                nameField.getText(), professionField.getText(), age);
        boolean isWell = HelloApplication.createStudent(student);
        if (isWell)
            statusLabel.setText("Успешно");
        else
            statusLabel.setText("Неуспешно");
    }

    @FXML
    protected void Button2() throws SQLException {
        if (studentsTable.getColumns().size() == 0)
            initializeStudentsTable();
        studentsTable.getItems().clear();
        ArrayList<Student> students = HelloApplication.readStudents();
        for (Student temp: students)
            studentsTable.getItems().add(temp);
    }


    @FXML
    protected void Button3() {
        Student student = new Student(Integer.parseInt(idField.getText()),
                surField.getText(), nameField.getText(), professionField.getText(),
                Integer.parseInt(ageField.getText()));
        HelloApplication.deleteStudent(student);
    }

}