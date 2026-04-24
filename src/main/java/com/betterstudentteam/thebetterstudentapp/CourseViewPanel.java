package com.betterstudentteam.thebetterstudentapp;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class CourseViewPanel extends VBox {

    private static final Screen SCREEN = Screen.getPrimary();
    private static final Rectangle2D SCREEN_BOUNDS = SCREEN.getVisualBounds();

    public CourseViewPanel() {
        // Course view panel
        this.setPrefHeight(SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setMaxHeight(SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
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
