package com.betterstudentteam.thebetterstudentapp.frontend.view;

import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.todo_list.TodoManager;
import com.betterstudentteam.thebetterstudentapp.backend.user_setup.CourseSetupRequest;
import com.betterstudentteam.thebetterstudentapp.backend.user_setup.UserSetupData;
import com.betterstudentteam.thebetterstudentapp.backend.user_setup.UserSetupManager;
import com.betterstudentteam.thebetterstudentapp.backend.util.SaveManager;
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
import java.util.HashMap;
import java.util.List;

public class SetupView extends BorderPane {

    private VBox mCourseFormList;
    private Label mErrorLabel;
    private Button mAddCourseButton;
    private Button mSaveButton;

    public SetupView(BorderPane wrapper, CourseManager courseManager, TodoManager todoManager, UserSetupManager setupManager, SaveManager saveManager) {

        Label mHeader = new Label("Course Setup");
        mHeader.getStyleClass().add("setup-label");

        mCourseFormList = new VBox();
        mCourseFormList.setSpacing(10);

        // Load existing courses into form rows
        List<Course> existingCourses = courseManager.getAllCourses();
        if (existingCourses.isEmpty()) {
            mCourseFormList.getChildren().add(new CourseFormRow(mCourseFormList));
        } else {
            for (Course course : existingCourses) {
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
                List<CourseSetupRequest> courseRequests = new ArrayList<>();

                for (var child : mCourseFormList.getChildren()) {
                    CourseFormRow row = (CourseFormRow) child;
                    CourseSetupRequest request = row.getRequest();
                    if (request == null) {
                        mErrorLabel.setText("Please fill in all fields.");
                        mErrorLabel.setVisible(true);
                        return;
                    }
                    courseRequests.add(request);
                }

                // Clear existing courses before re-adding
                courseManager.clearCourses();

                UserSetupData setupData = new UserSetupData(
                        courseRequests.size(),
                        new HashMap<>(),
                        0.0
                );

                setupManager.initializeUserCourses(setupData, courseRequests);
                saveManager.save();
                wrapper.setCenter(new HomePageView(wrapper, courseManager, todoManager, saveManager));
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