package com.betterstudentteam.thebetterstudentapp.frontend;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SetupPane extends VBox {

    private Label mHeader;

    public SetupPane() {
        this.getStyleClass().add("pane_setup");

        mHeader = new Label("Setup Course");
        this.getChildren().add(mHeader);
    }
}