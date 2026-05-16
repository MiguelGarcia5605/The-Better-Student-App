package com.betterstudentteam.thebetterstudentapp.frontend;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SetupPane extends VBox {

    private Label mHeader;
    private Button mAddCourseButton;

    public SetupPane() {
        this.getStyleClass().add("pane_setup");

        mHeader = new Label("Setup Course");
        mHeader.getStyleClass().add("label_setup_header");
        this.getChildren().add(mHeader);

        mAddCourseButton = new Button("Add Course");
        mAddCourseButton.getStyleClass().add("button_setup_add-course");
        this.getChildren().add(mAddCourseButton);

    }
}