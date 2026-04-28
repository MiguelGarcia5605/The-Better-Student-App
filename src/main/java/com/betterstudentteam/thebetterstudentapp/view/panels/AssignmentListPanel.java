package com.betterstudentteam.thebetterstudentapp.view.panels;

import com.betterstudentteam.thebetterstudentapp.util.Display;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AssignmentListPanel extends VBox {

    public AssignmentListPanel() {
        // Course view panel
        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setSpacing(10);
        this.getStyleClass().add("card-list-panel");
    }

    public void addAssignment(String name, String dueDate) {
        Label nameLabel = new Label(name);
        Label dueDateLabel = new Label(dueDate);

        nameLabel.getStyleClass().add("course-card-assignment");
        dueDateLabel.getStyleClass().add("course-card-assignment");

        VBox assignment = new VBox(nameLabel, dueDateLabel);
        assignment.getStyleClass().add("course-card");

        this.getChildren().add(assignment);
    }
}
