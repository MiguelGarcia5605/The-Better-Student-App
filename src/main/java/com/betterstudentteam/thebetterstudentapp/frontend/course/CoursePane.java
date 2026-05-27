package com.betterstudentteam.thebetterstudentapp.frontend.course;

import com.betterstudentteam.thebetterstudentapp.backend.Course;
import com.betterstudentteam.thebetterstudentapp.frontend.todo.TaskVBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CoursePane extends BorderPane {

    private Course mCourse;

    private VBox mLeftContainer;
    private TextArea mTextArea;
    private CourseAssignmentView mCourseAssignmentView;

    private TaskVBox mDailyTodoPanel;

    public CoursePane(Course course) {
        mLeftContainer = new VBox();
        mTextArea = new TextArea();
        mTextArea.setPromptText("Enter course notes...");
        mCourseAssignmentView = new CourseAssignmentView();

        mLeftContainer.getChildren().addAll(mCourseAssignmentView, mTextArea);
        this.setLeft(mLeftContainer);

        mDailyTodoPanel = new TaskVBox("Daily Todo");
        mDailyTodoPanel.getStyleClass().add("panel_daily-todo");
        this.setRight(mDailyTodoPanel);
    }
}
