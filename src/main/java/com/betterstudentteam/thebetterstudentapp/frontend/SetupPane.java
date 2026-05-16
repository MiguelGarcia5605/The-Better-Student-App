package com.betterstudentteam.thebetterstudentapp.frontend;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SetupPane extends VBox {

    private Label mHeader;
    private SaveSetupRow mSaveSetupRow;
    private SetupCourseRow mSetupCourseRow;

    public SetupPane() {
        this.getStyleClass().add("pane_setup");

        mHeader = new Label("Setup Course");
        mHeader.getStyleClass().add("label_setup_header");
        this.getChildren().add(mHeader);

        mSetupCourseRow = new SetupCourseRow();
        mSetupCourseRow.getStyleClass().add("pane_setup_course-row");
        this.getChildren().add(mSetupCourseRow);

        mSaveSetupRow = new SaveSetupRow();
        this.getChildren().add(mSaveSetupRow);
    }
}