module com.betterstudentteam.thebetterstudentapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    requires java.sql;
    requires tools.jackson.databind;

    opens com.betterstudentteam.thebetterstudentapp to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp;
    exports com.betterstudentteam.thebetterstudentapp.backend;
    opens com.betterstudentteam.thebetterstudentapp.backend to javafx.fxml;
}