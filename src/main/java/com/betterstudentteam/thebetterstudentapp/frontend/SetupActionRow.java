package com.betterstudentteam.thebetterstudentapp.frontend;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class SetupActionRow extends HBox {

    private Button mAddCourseButton;
    private Button mSaveCourseButton;

    public SetupActionRow() {
        mAddCourseButton = new Button("Add Course");
        mAddCourseButton.getStyleClass().add("button_setup_add-course");
        this.getChildren().add(mAddCourseButton);

        mSaveCourseButton = new Button("Save Course");
        mSaveCourseButton.getStyleClass().add("button_setup_save-course");
        this.getChildren().add(mSaveCourseButton);
    }

    public Button getAddCourseButton() {
        return mAddCourseButton;
    }

    public Button getSaveCourseButton() {
        return mSaveCourseButton;
    }
}
