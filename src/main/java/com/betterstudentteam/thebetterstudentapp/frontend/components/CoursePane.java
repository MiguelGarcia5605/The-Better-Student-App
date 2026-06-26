package com.betterstudentteam.thebetterstudentapp.frontend.components;

import com.betterstudentteam.thebetterstudentapp.backend.Display;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CoursePane extends BorderPane {

    private VBox mLeftContainer;
    private TextArea mTextArea;
    private CourseAssignmentList mCourseAssignmentList;
    private AssignmentList mDailyList;

    public CoursePane() {
        mLeftContainer = new VBox();
        mTextArea = new TextArea();
        mCourseAssignmentList = new CourseAssignmentList();

        mTextArea.setMaxWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        mTextArea.setMaxHeight(Display.SCREEN_BOUNDS.getWidth() / 10.0);
        mTextArea.setPrefWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        mTextArea.setPrefHeight(Display.SCREEN_BOUNDS.getWidth() / 10.0);
        mTextArea.getStyleClass().add("text_area");
        mTextArea.setWrapText(true);

        mLeftContainer.getChildren().add(mTextArea);
        mLeftContainer.getChildren().add(mCourseAssignmentList);
        this.setLeft(mLeftContainer);

        mDailyList = new AssignmentList("Daily Todo");
        mDailyList.getStyleClass().add("panel_daily-todo");
        this.setRight(mDailyList);
    }
}
