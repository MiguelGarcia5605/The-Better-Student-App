package com.betterstudentteam.thebetterstudentapp.frontend.view;

import com.betterstudentteam.thebetterstudentapp.backend.assignment.Assignment;
import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.*;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CourseView extends BorderPane {
    VBox mLeftContainer;
    VBox mRightContainer;

    DisplayPanel mSchedulePanel;
    DisplayPanel mInstructorPanel;
    DisplayPanel mGradePanel;
    AssignmentListPanel mAssignmentListPanel;

    public CourseView(Course course, SaveManager saveManager) {
        mInstructorPanel = new DisplayPanel(
                "Instructor: " + course.getInstructor(),
                Display.SCREEN_BOUNDS.getHeight() * (1.0 / 2.0),
                Display.SCREEN_BOUNDS.getHeight() * (1.0 / 2.0),
                Display.SCREEN_BOUNDS.getWidth() * (1.0 / 3.0) - 60,
                "display-panel-label",
                "display-panel"
        );

        mGradePanel = new DisplayPanel(
                "Grade: " + course.getGrade() + "%",
                Display.SCREEN_BOUNDS.getHeight() * (1.0 / 2.0),
                Display.SCREEN_BOUNDS.getHeight() * (1.0 / 2.0),
                Display.SCREEN_BOUNDS.getWidth() * (1.0 / 3.0) - 60,
                "display-panel-label",
                "display-panel"
        );

        mSchedulePanel = new DisplayPanel(
                course.getMeetingDays().toString() + " " +
                        course.getStartTime() + " - " + course.getEndTime(),
                Display.SCREEN_BOUNDS.getHeight() * (1.0 / 4.0),
                Display.SCREEN_BOUNDS.getHeight() * (1.0 / 4.0),
                Display.SCREEN_BOUNDS.getWidth() * (2.0 / 3.0),
                "display-panel-label",
                "display-panel"
        );

        mAssignmentListPanel = new AssignmentListPanel(course, saveManager);

        for (Assignment assignment : course.getAssignmentList().getList()) {
            mAssignmentListPanel.displayAssignment(assignment);
        }

        mLeftContainer = new VBox();
        mRightContainer = new VBox();

        mLeftContainer.setPrefWidth(Display.SCREEN_BOUNDS.getWidth() * (2.0 / 3.0));
        mLeftContainer.setSpacing(10);

        mRightContainer.setPrefWidth(Display.SCREEN_BOUNDS.getWidth() * (1.0 / 3.0) - 40);
        mRightContainer.setSpacing(10);

        mLeftContainer.getChildren().add(mSchedulePanel);
        mLeftContainer.getChildren().add(mAssignmentListPanel);
        mRightContainer.getChildren().add(mInstructorPanel);
        mRightContainer.getChildren().add(mGradePanel);

        this.setLeft(mLeftContainer);
        this.setRight(mRightContainer);
        this.setPadding(new Insets(20));
        BorderPane.setMargin(mLeftContainer, new Insets(0, 10, 0, 0));
        BorderPane.setMargin(mRightContainer, new Insets(0, 0, 0, 10));
        this.getStyleClass().add("view-pane");
    }
}