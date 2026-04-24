package com.betterstudentteam.thebetterstudentapp;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application {

    private static final String APP_NAME = "The Better Student App";
    private static final String DAILY_QUOTE = "Be more than motivated, be more than driven, become literally obsessed to the point where people think you're fucking nuts.";

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

    private BorderPane mHomePagePane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        // Get user screen dimensions
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setTitle(APP_NAME);

        // Daily quote panel
        mDailyQuote = new Label();
        mDailyQuote.setText(DAILY_QUOTE);
        mDailyQuote.setWrapText(true);
        mDailyQuote.setMaxWidth(Double.MAX_VALUE);
        mDailyQuote.getStyleClass().add("quote-label");
        mDailyQuotePanel = new VBox(mDailyQuote);
        mDailyQuotePanel.setPrefHeight(bounds.getHeight() / 5);
        mDailyQuotePanel.setMaxWidth(bounds.getWidth() * (2.0 / 3.0));
        mDailyQuotePanel.setMaxHeight(bounds.getHeight() / 5);
        mDailyQuotePanel.getStyleClass().add("quote-container");

        // Course view panel
        mCourseViewPanel = new VBox();
        mCourseViewPanel.setPrefHeight(bounds.getHeight() * (3.0 / 4.0));
        mCourseViewPanel.setMaxHeight(bounds.getHeight() * (3.0 / 4.0));
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
        mDailyTasksPanel.setMinWidth((bounds.getWidth() / 3) - 40);
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

        mHomePagePane = new BorderPane();
        mHomePagePane.setLeft(mDailyQuoteAndCourseViewsContainer);
        mHomePagePane.setRight(mDailyTasksPanel);
        mHomePagePane.getStyleClass().add("home-page-pane");

        BorderPane.setMargin(mDailyTasksPanel, new Insets(0, 40, 0, 10));

        Scene scene = new Scene(mHomePagePane);
        scene.getStylesheets().add("StyleSheet.css");

        primaryStage.setScene(scene);
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.show();
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