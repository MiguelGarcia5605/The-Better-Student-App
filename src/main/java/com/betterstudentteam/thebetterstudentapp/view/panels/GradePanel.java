package com.betterstudentteam.thebetterstudentapp.view.panels;

import com.betterstudentteam.thebetterstudentapp.util.Display;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GradePanel extends VBox {

    private static final String GRADE_STRING = "Cumulative Grade: 97.6%";

    private Label mGrade;

    public GradePanel() {
        mGrade = new Label();
        mGrade.setText(GRADE_STRING);
        mGrade.getStyleClass().add("display-panel-label");
        this.getChildren().add(mGrade);
        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() * (1.0 / 2.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() * (1.0 / 2.0));
        this.setMaxWidth(Display.SCREEN_BOUNDS.getWidth() * (1.0 / 3.0));
        this.getStyleClass().add("display-panel");
    }
}
