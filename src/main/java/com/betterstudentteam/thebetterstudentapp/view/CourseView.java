package com.betterstudentteam.thebetterstudentapp.view;

import com.betterstudentteam.thebetterstudentapp.util.Display;
import com.betterstudentteam.thebetterstudentapp.view.panels.AssignmentListPanel;
import com.betterstudentteam.thebetterstudentapp.view.panels.AttendancePanel;
import com.betterstudentteam.thebetterstudentapp.view.panels.GradePanel;
import com.betterstudentteam.thebetterstudentapp.view.panels.ImportantDatePanel;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CourseView extends BorderPane {
    VBox mLeftContainer;
    VBox mRightContainer;

    ImportantDatePanel mImportantDatePanel;
    AttendancePanel mAttendancePanel;
    AssignmentListPanel mAssignmentListPanel;
    GradePanel mGradePanel;

    public CourseView() {
        mImportantDatePanel = new ImportantDatePanel();
        mAttendancePanel = new AttendancePanel();
        mAssignmentListPanel = new AssignmentListPanel();
        mGradePanel = new GradePanel();

        mAssignmentListPanel.addAssignment("Code", "April 16, 2026");

        mLeftContainer = new VBox();
        mRightContainer = new VBox();

        mLeftContainer.setPrefWidth(Display.SCREEN_BOUNDS.getWidth() * (2.0 / 3.0));
        mLeftContainer.setSpacing(10);

        mRightContainer.setPrefWidth(Display.SCREEN_BOUNDS.getWidth() * (1.0 / 3.0));
        mRightContainer.setSpacing(10);

        mLeftContainer.getChildren().add(mImportantDatePanel);
        mLeftContainer.getChildren().add(mAssignmentListPanel);
        mRightContainer.getChildren().add(mAttendancePanel);
        mRightContainer.getChildren().add(mGradePanel);

        this.setLeft(mLeftContainer);
        this.setRight(mRightContainer);
        this.setPadding(new Insets(20));
        BorderPane.setMargin(mRightContainer, new Insets(0, 20, 0, 10));
        this.getStyleClass().add("home-page-pane");
    }
}