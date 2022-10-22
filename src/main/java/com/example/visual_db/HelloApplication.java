package main.java.com.example.visual_db;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloApplication extends Application {

    private static Connection connection;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:students.db");
            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connectToDatabase();
        launch();
    }

    public static Student getStudent(int id) {
        Statement statement = null;
        Student res = null;
        try {
            statement = connection.createStatement();
            ResultSet temp = statement.executeQuery("select * from students where id=" + id);
            res = new Student(temp.getInt(1), temp.getString(2), temp.getString(3),
                    temp.getString(4), temp.getInt(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static boolean createStudent(Student student) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.execute("insert into students values (" + student.getId() + ",\"" + student.getSurname() + "\",\"" +
                    student.getName() + "\",\"" + student.getProfession() + "\"," + student.getAge() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static ArrayList<Student> readStudents() throws SQLException {   //метод для считывания всех студентов
        ArrayList<Student> students = new ArrayList<>();
        ResultSet res;
        Statement statement = null;
        statement = connection.createStatement();
        statement.execute("select * from students");
        res = statement.getResultSet();
        while (res.next()){
            int id = res.getInt("id");
            String surname = res.getString("surname");
            String name = res.getString("name");
            String profession = res.getString("profession");
            int age = res.getInt("age");
            students.add(new Student(id, surname, name, profession, age));
        }
        return students;
    }


  public static void deleteStudent(Student student) { //метод для удаления студента
      Statement statement = null;
      try {
          statement = connection.createStatement();
          statement.execute("delete from students where surname = (" + student.getSurname() +")");
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
}