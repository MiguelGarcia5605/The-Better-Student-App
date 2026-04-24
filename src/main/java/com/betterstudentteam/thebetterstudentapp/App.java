package com.betterstudentteam.thebetterstudentapp;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

    private ArrayList<CheckBox> mUserTaskList = new ArrayList<>();
    private VBox mDailyTasksContainer;
    private VBox mDailyQuoteAndCourseViewContainer;
    private VBox mQuoteContainer;
    private VBox mCourseViewContainer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setTitle("The Better Student App");

        Label dailyToDoHeader = new Label("Daily To-Do");
        mDailyTasksContainer = new VBox(dailyToDoHeader);
        mDailyTasksContainer.getStyleClass().add("vbox");

        Label textArea = new Label();
        textArea.setWrapText(true);
        textArea.setText("Be more than motivated, be more than driven, become literally obsessed to the point where people think you're fucking nuts.");
        textArea.setMaxWidth(Double.MAX_VALUE);

        mCourseViewContainer = new VBox();
        mCourseViewContainer.setAlignment(Pos.BOTTOM_LEFT);
        mCourseViewContainer.setPrefHeight(bounds.getHeight() * (3.0 / 4.0));
        mCourseViewContainer.setMaxHeight(bounds.getHeight() * (3.0 / 4.0));
        mCourseViewContainer.getStyleClass().add("course-view-container");

        textArea.getStyleClass().add("quote-label");
        mQuoteContainer = new VBox(textArea);
        mQuoteContainer.setAlignment(Pos.TOP_CENTER);
        mQuoteContainer.setPrefHeight(bounds.getHeight() / 5);
        mQuoteContainer.setMaxHeight(bounds.getHeight() / 5);
        mQuoteContainer.getStyleClass().add("quote-container");
        mQuoteContainer.setMaxWidth(bounds.getWidth() * (2.0 / 3.0));

        mDailyQuoteAndCourseViewContainer = new VBox();
        mDailyQuoteAndCourseViewContainer.getChildren().add(mQuoteContainer);
        mDailyQuoteAndCourseViewContainer.getChildren().add(mCourseViewContainer);
        mDailyQuoteAndCourseViewContainer.setAlignment(Pos.TOP_LEFT);
        mDailyQuoteAndCourseViewContainer.setSpacing(10);

        TextField textInput = new TextField();
        textInput.setPromptText("Add task...");
        textInput.getStyleClass().add("task-field");

        Button addTaskButton = new Button("+");
        addTaskButton.getStyleClass().add("add-task-button");
        mDailyTasksContainer.getChildren().add(addTaskButton);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                CheckBox task = createDailyTask(textInput.getText());
                mUserTaskList.add(task);
                mDailyTasksContainer.getChildren().add(mDailyTasksContainer.getChildren().size() - 1, task);
                textInput.setText("");
            }
        };

        addTaskButton.setOnAction(event);

        HBox addTaskRow = new HBox(addTaskButton, textInput);
        mDailyTasksContainer.getChildren().add(addTaskRow);

        // course card example
        Label courseLabel = new Label("ENG 110");
        Label assignmentLabel = new Label("Next: Research paper due Friday, May 1st");
        Label gradeLabel = new Label("A - 99.76%");

        courseLabel.getStyleClass().add("course-card-name");
        assignmentLabel.getStyleClass().add("course-card-assignment");
        gradeLabel.getStyleClass().add("course-card-assignment");

        VBox courseCard = new VBox(courseLabel, assignmentLabel, gradeLabel);
        courseCard.getStyleClass().add("course-card");

        mCourseViewContainer.getChildren().add(courseCard);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(mDailyTasksContainer);
        borderPane.setLeft(mDailyQuoteAndCourseViewContainer);
        borderPane.setPadding(new Insets(20));
        BorderPane.setMargin(mDailyTasksContainer, new Insets(0, 40, 0, 10));
        mDailyTasksContainer.setMinWidth((bounds.getWidth() / 3) - 40);
        Scene scene = new Scene(borderPane);

        scene.getStylesheets().add("StyleSheet.css");

        primaryStage.setScene(scene);
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.show();
    }

    private CheckBox createDailyTask(String taskName) {
        CheckBox task = new CheckBox(taskName);
        task.getStyleClass().add("task");
        return task;
    }
}