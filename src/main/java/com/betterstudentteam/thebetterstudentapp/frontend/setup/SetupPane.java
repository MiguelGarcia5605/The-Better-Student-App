package com.betterstudentteam.thebetterstudentapp.frontend.setup;

import atlantafx.base.theme.Styles;
import com.betterstudentteam.thebetterstudentapp.backend.Course;
import com.betterstudentteam.thebetterstudentapp.backend.SaveManager;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SetupPane extends VBox {

    private static final int COURSE_SETUP_ROW_MAX = 10;

    private Label mHeader;
    private SetupActionRow mSetupActionRow;

    private ArrayList<CourseSetupRow> mCourseSetupRowArrayList;

    public SetupPane() {
        mCourseSetupRowArrayList = new ArrayList<CourseSetupRow>();

        this.getStyleClass().add("pane_setup");

        mHeader = new Label("Setup Course");
        mHeader.getStyleClass().add(Styles.TITLE_1);
        this.getChildren().add(mHeader);

        mSetupActionRow = new SetupActionRow();
        this.getChildren().add(mSetupActionRow);

        mSetupActionRow.getAddCourseButton().setOnAction(event -> addCourseSetupRow());
        mSetupActionRow.getSaveCourseButton().setOnAction(event -> SaveManager.writeSave(getCourseArrayList()));
    }

    public void addCourseSetupRow() {
        if (mCourseSetupRowArrayList.size() >= COURSE_SETUP_ROW_MAX) return;

        CourseSetupRow newRow = new CourseSetupRow();

        // Set ghost text for first row
        if (mCourseSetupRowArrayList.isEmpty()) newRow.getNameTextField().setPromptText("Class name...");

        newRow.getStyleClass().add("pane_setup_course-row");
        mCourseSetupRowArrayList.add(newRow);
        int size = this.getChildren().size();
        this.getChildren().add(size - 1, newRow);
    }

    private ArrayList<Course> getCourseArrayList() {
        ArrayList<Course> courseArrayList = new ArrayList<Course>();

        for (CourseSetupRow setupRow : mCourseSetupRowArrayList) {
            courseArrayList.add(setupRow.getCourse());
        }
        return courseArrayList;
    }

}