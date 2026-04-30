package com.betterstudentteam.thebetterstudentapp.frontend.panels;

import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AttendancePanel extends VBox {

    private Label mAttendance;

    public AttendancePanel(String text) {
        mAttendance = new Label(text);
        mAttendance.getStyleClass().add("display-panel-label");
        this.getChildren().add(mAttendance);
        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() * (1.0 / 2.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() * (1.0 / 2.0));
        this.setMaxWidth(Display.SCREEN_BOUNDS.getWidth() * (1.0 / 3.0));
        this.getStyleClass().add("display-panel");
    }
}
