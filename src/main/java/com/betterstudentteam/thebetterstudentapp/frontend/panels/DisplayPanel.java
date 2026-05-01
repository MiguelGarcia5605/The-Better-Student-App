package com.betterstudentteam.thebetterstudentapp.frontend.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class DisplayPanel extends VBox {
    private Label mLabel;

    public DisplayPanel(String text, double prefHeight, double maxHeight, double maxWidth, String textCSS, String panelCSS) {
        mLabel = new Label(text);
        mLabel.getStyleClass().add(textCSS);
        mLabel.setMaxWidth(Double.MAX_VALUE);
        mLabel.setMaxHeight(Double.MAX_VALUE);
        mLabel.setWrapText(true);

        VBox.setVgrow(mLabel, Priority.ALWAYS);
        this.setFillWidth(true);
        mLabel.setAlignment(Pos.CENTER);

        this.getChildren().add(mLabel);
        this.setPrefHeight(prefHeight);
        this.setMaxHeight(maxHeight);
        this.setMaxWidth(maxWidth);
        this.getStyleClass().add(panelCSS);
    }
}