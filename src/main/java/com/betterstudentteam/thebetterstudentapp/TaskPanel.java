package com.betterstudentteam.thebetterstudentapp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

import java.util.ArrayList;

public class TaskPanel extends VBox{
    private static final Screen SCREEN = Screen.getPrimary();
    private static final Rectangle2D SCREEN_BOUNDS = SCREEN.getVisualBounds();

    private ArrayList<CheckBox> mUserTaskList = new ArrayList<>();

    private HBox mDailyNewTaskContainer;
    private Label mDailyTasks;
    private TextField mDailyNewTaskField;
    private Button mDailyNewTaskButton;
    
    public TaskPanel() {
        // Daily Tasks panel
        mDailyTasks = new Label("Daily To-Do");
        mDailyTasks.getStyleClass().add("daily-tasks-label");
        mDailyNewTaskField = new TextField();
        mDailyNewTaskField.setPromptText("Add task...");
        mDailyNewTaskField.getStyleClass().add("task-field");
        mDailyNewTaskButton = new Button("+");
        mDailyNewTaskButton.getStyleClass().add("add-task-button");
        mDailyNewTaskContainer = new HBox(mDailyNewTaskButton, mDailyNewTaskField);
        mDailyNewTaskButton.getStyleClass().add("new-task-container");
        this.getChildren().add(mDailyTasks);
        this.setMinWidth((SCREEN_BOUNDS.getWidth() / 3 - 60));
        this.getChildren().add(mDailyNewTaskContainer);
        this.getStyleClass().add("vbox");

        EventHandler<ActionEvent> dailyEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                addDailyTask(mDailyNewTaskField.getText());
            }
        };

        mDailyNewTaskButton.setOnAction(dailyEvent);
    }

    public void addDailyTask(String taskName) {
        CheckBox task = new CheckBox(taskName);
        task.getStyleClass().add("task");
        mUserTaskList.add(task);
        this.getChildren().add(this.getChildren().size() - 1, task);
        mDailyNewTaskField.setText("");
    }
}
