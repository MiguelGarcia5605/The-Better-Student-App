module com.betterstudentteam.thebetterstudentapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;


    opens com.betterstudentteam.thebetterstudentapp to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp;
    exports com.betterstudentteam.thebetterstudentapp.view;
    opens com.betterstudentteam.thebetterstudentapp.view to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp.view.panels;
    opens com.betterstudentteam.thebetterstudentapp.view.panels to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp.util;
    opens com.betterstudentteam.thebetterstudentapp.util to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp.attendance_and_grading;
    opens com.betterstudentteam.thebetterstudentapp.attendance_and_grading to javafx.fxml;
}