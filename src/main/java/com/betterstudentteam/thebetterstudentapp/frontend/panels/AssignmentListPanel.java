package com.betterstudentteam.thebetterstudentapp.frontend.panels;

import com.betterstudentteam.thebetterstudentapp.backend.assignment.Assignment;
import com.betterstudentteam.thebetterstudentapp.backend.assignment.AssignmentList;
import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveManager;
import com.betterstudentteam.thebetterstudentapp.backend.util.ID;
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
    private Course mCourse;
    private SaveManager mSaveManager;

    public AssignmentListPanel(Course course, SaveManager saveManager) {
        mCourse = course;
        mSaveManager = saveManager;

        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        this.setSpacing(10);
        this.getStyleClass().add("card-list-panel");

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
                ID.generateID(),
                name,
                dueDate
        );

        mCourse.getAssignmentList().add(assignment);
        displayAssignment(assignment);
        mAssignmentNameField.clear();
        mAssignmentDueDateField.clear();
        mSaveManager.save();
    }

    public void displayAssignment(Assignment assignment) {
        Label nameLabel = new Label(assignment.getName());
        Label dueDateLabel = new Label(assignment.getDueDate().toString());

        nameLabel.getStyleClass().add("course-card-detail");
        dueDateLabel.getStyleClass().add("course-card-detail");

        Button deleteButton = new Button("✕");
        deleteButton.getStyleClass().add("delete-button");

        VBox info = new VBox(nameLabel, dueDateLabel);
        HBox assignmentCard = new HBox(info, deleteButton);
        assignmentCard.getStyleClass().add("course-card");

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mCourse.getAssignmentList().remove(assignment.getID());
                AssignmentListPanel.this.getChildren().remove(assignmentCard);
                mSaveManager.save();
            }
        });

        this.getChildren().add(this.getChildren().size() - 2, assignmentCard);
    }
}