package com.betterstudentteam.thebetterstudentapp.view.panels;

import com.betterstudentteam.thebetterstudentapp.util.Display;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CourseViewPanel extends VBox {

    public CourseViewPanel() {
        // Course view panel
        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setSpacing(10);
        this.getStyleClass().add("course-view-container");
    }

    public void addCourseCard(String course, String assignment, String grade) {
        Label courseLabel = new Label(course);
        Label assignmentLabel = new Label(assignment);
        Label gradeLabel = new Label(grade);

        courseLabel.getStyleClass().add("course-card-name");
        assignmentLabel.getStyleClass().add("course-card-assignment");
        gradeLabel.getStyleClass().add("course-card-assignment");

        VBox courseCard = new VBox(courseLabel, assignmentLabel, gradeLabel);
        courseCard.getStyleClass().add("course-card");

        this.getChildren().add(courseCard);
    }
}
