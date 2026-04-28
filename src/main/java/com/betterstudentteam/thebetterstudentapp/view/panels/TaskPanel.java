package com.betterstudentteam.thebetterstudentapp.view.panels;

import com.betterstudentteam.thebetterstudentapp.util.Display;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class TaskPanel extends VBox{
    private ArrayList<CheckBox> mUserTaskList = new ArrayList<>();

    private HBox mDailyNewTaskContainer;
    private Label mDailyTasks;
    private TextField mDailyNewTaskField;
    private Button mDailyNewTaskButton;
    
    public TaskPanel(String title) {
        // Daily Tasks panel
        mDailyTasks = new Label(title);
        mDailyTasks.getStyleClass().add("daily-tasks-label");
        mDailyNewTaskField = new TextField();
        mDailyNewTaskField.setPromptText("Add task...");
        mDailyNewTaskField.getStyleClass().add("task-field");
        mDailyNewTaskButton = new Button("+");
        mDailyNewTaskButton.getStyleClass().add("add-task-button");
        mDailyNewTaskContainer = new HBox(mDailyNewTaskButton, mDailyNewTaskField);
        mDailyNewTaskButton.getStyleClass().add("new-task-container");
        this.getChildren().add(mDailyTasks);
        this.setMinWidth((Display.SCREEN_BOUNDS.getWidth() / 3 - 60));
        this.getChildren().add(mDailyNewTaskContainer);
        this.getStyleClass().add("task-panel");

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
