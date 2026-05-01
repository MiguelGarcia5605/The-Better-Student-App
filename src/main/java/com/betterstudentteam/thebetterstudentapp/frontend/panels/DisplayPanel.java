package com.betterstudentteam.thebetterstudentapp.frontend.panels;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DisplayPanel extends VBox {
    private Label mLabel;

    public DisplayPanel(String text, double prefHeight, double maxHeight, double maxWidth) {
        mLabel = new Label(text);
        mLabel.getStyleClass().add("display-panel-label");
        this.getChildren().add(mLabel);
        this.setPrefHeight(prefHeight);
        this.setMaxHeight(maxHeight);
        this.setMaxWidth(maxWidth);
        this.getStyleClass().add("display-panel");
    }
}