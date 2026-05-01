module com.betterstudentteam.thebetterstudentapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;
    requires java.sql;


    opens com.betterstudentteam.thebetterstudentapp to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp;
    exports com.betterstudentteam.thebetterstudentapp.frontend.view;
    opens com.betterstudentteam.thebetterstudentapp.frontend.view to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp.frontend.panels;
    opens com.betterstudentteam.thebetterstudentapp.frontend.panels to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp.backend.util;
    opens com.betterstudentteam.thebetterstudentapp.backend.util to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp.frontend.components;
    opens com.betterstudentteam.thebetterstudentapp.frontend.components to javafx.fxml;
    exports com.betterstudentteam.thebetterstudentapp.backend.save;
    opens com.betterstudentteam.thebetterstudentapp.backend.save to javafx.fxml;
}