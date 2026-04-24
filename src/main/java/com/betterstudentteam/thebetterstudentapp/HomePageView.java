package com.betterstudentteam.thebetterstudentapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

import java.util.ArrayList;

public class HomePageView extends BorderPane {
    private static final String DAILY_QUOTE = "Be more than motivated, be more than driven, become literally obsessed to the point where people think you're fucking nuts.";
    private static final Screen SCREEN = Screen.getPrimary();
    private static final Rectangle2D SCREEN_BOUNDS = SCREEN.getVisualBounds();

    private ArrayList<CheckBox> mUserTaskList = new ArrayList<>();

    private VBox mDailyTasksPanel;
    private VBox mDailyQuoteAndCourseViewsContainer;
    private VBox mCourseViewPanel;
    private VBox mDailyQuotePanel;

    private HBox mNewTaskContainer;

    private Label mDailyQuote;
    private Label mDailyTasks;

    private TextField mNewTaskField;

    private Button mNewTaskButton;

    public HomePageView() {
        // Daily quote panel
        mDailyQuote = new Label();
        mDailyQuote.setText(DAILY_QUOTE);
        mDailyQuote.setWrapText(true);
        mDailyQuote.setMaxWidth(Double.MAX_VALUE);
        mDailyQuote.getStyleClass().add("quote-label");
        mDailyQuotePanel = new VBox(mDailyQuote);
        mDailyQuotePanel.setPrefHeight(SCREEN_BOUNDS.getHeight() / 5);
        mDailyQuotePanel.setMaxWidth(SCREEN_BOUNDS.getWidth() * (2.0 / 3.0));
        mDailyQuotePanel.setMaxHeight(SCREEN_BOUNDS.getHeight() / 5);
        mDailyQuotePanel.getStyleClass().add("quote-container");

        // Course view panel
        mCourseViewPanel = new VBox();
        mCourseViewPanel.setPrefHeight(SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        mCourseViewPanel.setMaxHeight(SCREEN_BOUNDS.getHeight() * (3.0 / 4.0));
        mCourseViewPanel.getStyleClass().add("course-view-container");

        // Daily quote and course views container
        mDailyQuoteAndCourseViewsContainer = new VBox();
        mDailyQuoteAndCourseViewsContainer.getChildren().add(mDailyQuotePanel);
        mDailyQuoteAndCourseViewsContainer.getChildren().add(mCourseViewPanel);
        mDailyQuoteAndCourseViewsContainer.getStyleClass().add("left-container");

        // Daily Tasks panel
        mDailyTasks = new Label("Daily To-Do");
        mDailyTasks.getStyleClass().add("daily-tasks-label");
        mNewTaskField = new TextField();
        mNewTaskField.setPromptText("Add task...");
        mNewTaskField.getStyleClass().add("task-field");
        mNewTaskButton = new Button("+");
        mNewTaskButton.getStyleClass().add("add-task-button");
        mNewTaskContainer = new HBox(mNewTaskButton, mNewTaskField);
        mNewTaskButton.getStyleClass().add("new-task-container");
        mDailyTasksPanel = new VBox(mDailyTasks);
        mDailyTasksPanel.setMinWidth((SCREEN_BOUNDS.getWidth() / 3) - 40);
        mDailyTasksPanel.getChildren().add(mNewTaskContainer);
        mDailyTasksPanel.getStyleClass().add("vbox");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                addDailyTask(mNewTaskField.getText());
            }
        };

        mNewTaskButton.setOnAction(event);

        // Course card
        addCourseCard("ENG 110",
                "Next: Research paper due Friday, May 1st",
                "A - 99.76%");

        this.setLeft(mDailyQuoteAndCourseViewsContainer);
        this.setRight(mDailyTasksPanel);
        this.getStyleClass().add("home-page-pane");

        BorderPane.setMargin(mDailyTasksPanel, new Insets(0, 40, 0, 10));
    }

    private void addDailyTask(String taskName) {
        CheckBox task = new CheckBox(taskName);
        task.getStyleClass().add("task");
        mUserTaskList.add(task);
        mDailyTasksPanel.getChildren().add(mDailyTasksPanel.getChildren().size() - 1, task);
        mNewTaskField.setText("");
    }

    private void addCourseCard(String course, String assignment, String grade) {
        Label courseLabel = new Label(course);
        Label assignmentLabel = new Label(assignment);
        Label gradeLabel = new Label(grade);

        courseLabel.getStyleClass().add("course-card-name");
        assignmentLabel.getStyleClass().add("course-card-assignment");
        gradeLabel.getStyleClass().add("course-card-assignment");

        VBox courseCard = new VBox(courseLabel, assignmentLabel, gradeLabel);
        courseCard.getStyleClass().add("course-card");

        mCourseViewPanel.getChildren().add(courseCard);
    }

}