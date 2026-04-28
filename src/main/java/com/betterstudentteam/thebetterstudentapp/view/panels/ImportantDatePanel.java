package com.betterstudentteam.thebetterstudentapp.view.panels;

import com.betterstudentteam.thebetterstudentapp.util.Display;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ImportantDatePanel extends VBox {

    private static final String IMPORTANT_DATE = "01/01 : Essay Due";

    private Label mDate;

    public ImportantDatePanel() {
        mDate = new Label();
        mDate.setText(IMPORTANT_DATE);
        mDate.getStyleClass().add("display-panel-label");
        this.getChildren().add(mDate);
        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() * (1.0 / 6.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() * (1.0 / 6.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() / 5);
        this.getStyleClass().add("display-panel");
    }
}
