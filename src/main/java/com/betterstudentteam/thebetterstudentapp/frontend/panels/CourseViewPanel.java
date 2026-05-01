package com.betterstudentteam.thebetterstudentapp.frontend.panels;

import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.view.CourseView;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CourseViewPanel extends VBox {

    private BorderPane mWrapper;
    private CourseManager mCourseManager;
    private SaveManager mSaveManager;

    public CourseViewPanel(BorderPane wrapper, CourseManager courseManager, SaveManager saveManager) {
        mWrapper = wrapper;
        mCourseManager = courseManager;
        mSaveManager = saveManager;

        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setSpacing(10);
        this.getStyleClass().add("card-list-panel");
    }

    public void addCourseCard(Course course, String assignment, String grade) {
        Label courseLabel = new Label(course.getName());
        Label assignmentLabel = new Label(assignment);
        Label gradeLabel = new Label(grade);

        courseLabel.getStyleClass().add("course-card-name");
        assignmentLabel.getStyleClass().add("course-card-detail");
        gradeLabel.getStyleClass().add("course-card-detail");

        VBox courseCard = new VBox(courseLabel, assignmentLabel, gradeLabel);
        courseCard.getStyleClass().add("course-card");
        courseCard.setStyle("-fx-cursor: hand;");

        courseCard.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                mWrapper.setCenter(new CourseView(course, mCourseManager, mSaveManager));
            }
        });

        this.getChildren().add(courseCard);
    }
}