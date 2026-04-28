package com.betterstudentteam.thebetterstudentapp.view.panels;

import com.betterstudentteam.thebetterstudentapp.util.Display;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AttendancePanel extends VBox {

    private static final String ATTENDANCE_STRING = "0/0 Classes Attended";

    private Label mAttendance;

    public AttendancePanel() {
        mAttendance = new Label();
        mAttendance.setText(ATTENDANCE_STRING);
        mAttendance.getStyleClass().add("display-panel-label");
        this.getChildren().add(mAttendance);
        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() * (1.0 / 2.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() * (1.0 / 2.0));
        this.setMaxWidth(Display.SCREEN_BOUNDS.getWidth() * (1.0 / 3.0));
        this.getStyleClass().add("display-panel");
    }
}
