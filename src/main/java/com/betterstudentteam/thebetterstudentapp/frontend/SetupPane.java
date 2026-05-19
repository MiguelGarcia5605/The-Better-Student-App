package com.betterstudentteam.thebetterstudentapp.frontend;

import com.betterstudentteam.thebetterstudentapp.backend.Course;
import com.betterstudentteam.thebetterstudentapp.backend.SaveManager;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SetupPane extends VBox {

    private Label mHeader;
    private SetupActionRow mSetupActionRow;

    private ArrayList<CourseSetupRow> mCourseSetupRowArrayList;

    public SetupPane() {
        mCourseSetupRowArrayList = new ArrayList<CourseSetupRow>();

        this.getStyleClass().add("pane_setup");

        mHeader = new Label("Setup Course");
        mHeader.getStyleClass().add("label_setup_header");
        this.getChildren().add(mHeader);

        mSetupActionRow = new SetupActionRow();
        this.getChildren().add(mSetupActionRow);

        mSetupActionRow.getAddCourseButton().setOnAction(event -> addCourseSetupRow());
        mSetupActionRow.getSaveCourseButton().setOnAction(event -> SaveManager.writeSave(getCourseArrayList()));
    }

    public void addCourseSetupRow() {
        CourseSetupRow newRow = new CourseSetupRow();
        newRow.getStyleClass().add("pane_setup_course-row");
        mCourseSetupRowArrayList.add(newRow);
        this.getChildren().add(newRow);
    }

    private ArrayList<Course> getCourseArrayList() {
        ArrayList<Course> courseArrayList = new ArrayList<Course>();

        for (CourseSetupRow setupRow : mCourseSetupRowArrayList) {
            courseArrayList.add(setupRow.getCourse());
        }
        return courseArrayList;
    }

}