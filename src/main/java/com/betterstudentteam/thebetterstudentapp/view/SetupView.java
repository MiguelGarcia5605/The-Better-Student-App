package com.betterstudentteam.thebetterstudentapp.view;

import com.betterstudentteam.thebetterstudentapp.courses.CourseManager;
import com.betterstudentteam.thebetterstudentapp.todo_list.TodoManager;
import com.betterstudentteam.thebetterstudentapp.user_setup.CourseSetupRequest;
import com.betterstudentteam.thebetterstudentapp.user_setup.UserSetupData;
import com.betterstudentteam.thebetterstudentapp.user_setup.UserSetupManager;
import com.betterstudentteam.thebetterstudentapp.util.SaveManager;
import com.betterstudentteam.thebetterstudentapp.view.HomePageView;
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

        // Header
        Label mHeader = new Label("Course Setup");
        mHeader.getStyleClass().add("setup-label");

        // Form list inside scroll pane
        mCourseFormList = new VBox();
        mCourseFormList.setSpacing(10);
        mCourseFormList.getChildren().add(new CourseFormRow());

        ScrollPane scrollPane = new ScrollPane(mCourseFormList);
        scrollPane.setFitToWidth(true);
        scrollPane.getStyleClass().add("setup-scroll");

        // Error label
        mErrorLabel = new Label();
        mErrorLabel.getStyleClass().add("setup-error-label");
        mErrorLabel.setVisible(false);

        // Buttons
        mAddCourseButton = new Button("+ Add Course");
        mAddCourseButton.getStyleClass().add("nav-button");

        mSaveButton = new Button("Save");
        mSaveButton.getStyleClass().add("save-button");

        mAddCourseButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mCourseFormList.getChildren().add(new CourseFormRow());
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

                UserSetupData setupData = new UserSetupData(
                        courseRequests.size(),
                        new HashMap<>(),
                        0.0
                );

                setupManager.initializeUserCourses(setupData, courseRequests);
                saveManager.save();
                wrapper.setCenter(new HomePageView(courseManager, todoManager, saveManager));
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