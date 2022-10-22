module com.example.visual_db {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.visual_db to javafx.fxml;
    exports com.example.visual_db;
}