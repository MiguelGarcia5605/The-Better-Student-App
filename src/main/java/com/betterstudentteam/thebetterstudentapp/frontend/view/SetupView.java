package com.betterstudentteam.thebetterstudentapp.frontend.view;

import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.todo.TodoList;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.components.CourseFormRow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SetupView extends BorderPane {

    private VBox mCourseFormList;
    private Label mErrorLabel;
    private Button mAddCourseButton;
    private Button mSaveButton;

    public SetupView(BorderPane wrapper, ArrayList<Course> courseList, TodoList todoList, SaveManager saveManager) {

        Label mHeader = new Label("Course Setup");
        mHeader.getStyleClass().add("setup-label");

        mCourseFormList = new VBox();
        mCourseFormList.setSpacing(10);

        if (courseList.isEmpty()) {
            mCourseFormList.getChildren().add(new CourseFormRow(mCourseFormList));
        } else {
            for (Course course : courseList) {
                CourseFormRow row = new CourseFormRow(mCourseFormList);
                row.loadCourse(course);
                mCourseFormList.getChildren().add(row);
            }
        }

        ScrollPane scrollPane = new ScrollPane(mCourseFormList);
        scrollPane.setFitToWidth(true);
        scrollPane.getStyleClass().add("setup-scroll");

        mErrorLabel = new Label();
        mErrorLabel.getStyleClass().add("setup-error-label");
        mErrorLabel.setVisible(false);

        mAddCourseButton = new Button("+ Add Course");
        mAddCourseButton.getStyleClass().add("nav-button");

        mSaveButton = new Button("Save");
        mSaveButton.getStyleClass().add("save-button");

        mAddCourseButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mCourseFormList.getChildren().add(new CourseFormRow(mCourseFormList));
            }
        });

        mSaveButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                ArrayList<Course> newCourses = new ArrayList<>();

                for (var child : mCourseFormList.getChildren()) {
                    CourseFormRow row = (CourseFormRow) child;
                    Course course = row.getCourse();
                    if (course == null) {
                        mErrorLabel.setText("Please fill in all fields.");
                        mErrorLabel.setVisible(true);
                        return;
                    }
                    newCourses.add(course);
                }

                courseList.clear();
                courseList.addAll(newCourses);
                saveManager.save();
                wrapper.setCenter(new HomePageView(wrapper, courseList, todoList, saveManager));
            }
        });

        HBox mButtonRow = new HBox(mAddCourseButton, mSaveButton, mErrorLabel);
        mButtonRow.setSpacing(10);
        mButtonRow.getStyleClass().add("setup-button-row");

        this.setTop(mHeader);
        this.setCenter(scrollPane);
        this.setBottom(mButtonRow);
        this.getStyleClass().add("view-pane");
    }
}