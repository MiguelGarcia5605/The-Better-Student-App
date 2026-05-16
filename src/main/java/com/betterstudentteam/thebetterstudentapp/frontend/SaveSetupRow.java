package com.betterstudentteam.thebetterstudentapp.frontend;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class SaveSetupRow extends HBox {

    private Button mAddCourseButton;
    private Button mSaveCourseButton;

    public SaveSetupRow() {
        mAddCourseButton = new Button("Add Course");
        mAddCourseButton.getStyleClass().add("button_setup_add-course");
        this.getChildren().add(mAddCourseButton);

        mSaveCourseButton = new Button("Save Course");
        mSaveCourseButton.getStyleClass().add("button_setup_save-course");
        this.getChildren().add(mSaveCourseButton);

    }
}
