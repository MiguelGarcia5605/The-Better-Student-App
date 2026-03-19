module com.betterstudentteam.thebetterstudentapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;


    opens com.betterstudentteam.thebetterstudentapp to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp;
}