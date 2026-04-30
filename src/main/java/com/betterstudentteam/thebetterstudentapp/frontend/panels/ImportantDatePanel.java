package com.betterstudentteam.thebetterstudentapp.frontend.panels;

import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ImportantDatePanel extends VBox {

    private Label mDate;

    public ImportantDatePanel(String text) {
        mDate = new Label(text);
        mDate.getStyleClass().add("display-panel-label");
        this.getChildren().add(mDate);
        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() * (1.0 / 6.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() * (1.0 / 6.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() / 5);
        this.getStyleClass().add("display-panel");
    }
}
