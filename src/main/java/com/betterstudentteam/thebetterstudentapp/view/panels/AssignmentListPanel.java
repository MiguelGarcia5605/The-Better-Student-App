package com.betterstudentteam.thebetterstudentapp.view.panels;

import com.betterstudentteam.thebetterstudentapp.assignments.Assignment;
import com.betterstudentteam.thebetterstudentapp.assignments.AssignmentManager;
import com.betterstudentteam.thebetterstudentapp.courses.CourseManager;
import com.betterstudentteam.thebetterstudentapp.util.Display;
import com.betterstudentteam.thebetterstudentapp.util.SaveManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AssignmentListPanel extends VBox {

    private Label mErrorLabel;
    private TextField mAssignmentNameField;
    private TextField mAssignmentDueDateField;
    private Button mAddAssignmentButton;
    private String mCourseId;
    private CourseManager mCourseManager;
    private SaveManager mSaveManager;

    public AssignmentListPanel(String courseId, CourseManager courseManager, SaveManager saveManager) {
        mCourseId = courseId;
        mCourseManager = courseManager;
        mSaveManager = saveManager;

        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setSpacing(10);
        this.getStyleClass().add("card-list-panel");

        // Add assignment form
        mAssignmentNameField = new TextField();
        mAssignmentNameField.setPromptText("Assignment name");
        mAssignmentNameField.getStyleClass().add("task-field");

        mAssignmentDueDateField = new TextField();
        mAssignmentDueDateField.setPromptText("Due date (e.g. 2026-05-01)");
        mAssignmentDueDateField.getStyleClass().add("task-field");

        mAddAssignmentButton = new Button("+");
        mAddAssignmentButton.getStyleClass().add("add-task-button");

        mErrorLabel = new Label();
        mErrorLabel.getStyleClass().add("setup-error-label");
        mErrorLabel.setVisible(false);

        HBox addAssignmentRow = new HBox(mAddAssignmentButton, mAssignmentNameField, mAssignmentDueDateField);
        addAssignmentRow.setSpacing(10);

        this.getChildren().add(addAssignmentRow);
        this.getChildren().add(mErrorLabel);

        mAddAssignmentButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addAssignment();
            }
        });
    }

    private void addAssignment() {
        String name = mAssignmentNameField.getText();
        String dueDateText = mAssignmentDueDateField.getText();

        if (name.isEmpty() || dueDateText.isEmpty()) {
            mErrorLabel.setText("Please fill in all fields.");
            mErrorLabel.setVisible(true);
            return;
        }

        LocalDate dueDate;
        try {
            dueDate = LocalDate.parse(dueDateText);
        } catch (DateTimeParseException e) {
            mErrorLabel.setText("Invalid date format. Use YYYY-MM-DD.");
            mErrorLabel.setVisible(true);
            return;
        }

        mErrorLabel.setVisible(false);

        Assignment assignment = new Assignment(
                AssignmentManager.generateId(),
                name,
                mCourseId,
                dueDate,
                "Homework",
                ""
        );

        mCourseManager.addAssignment(assignment);
        displayAssignment(name, dueDateText);
        mAssignmentNameField.clear();
        mAssignmentDueDateField.clear();
        mSaveManager.save();
    }

    public void displayAssignment(String name, String dueDate) {
        Label nameLabel = new Label(name);
        Label dueDateLabel = new Label(dueDate);

        nameLabel.getStyleClass().add("course-card-detail");
        dueDateLabel.getStyleClass().add("course-card-detail");

        VBox assignment = new VBox(nameLabel, dueDateLabel);
        assignment.getStyleClass().add("course-card");

        this.getChildren().add(this.getChildren().size() - 2, assignment);
    }
}