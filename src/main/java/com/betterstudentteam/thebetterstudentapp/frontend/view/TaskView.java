package com.betterstudentteam.thebetterstudentapp.frontend.view;

import com.betterstudentteam.thebetterstudentapp.backend.save.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.TaskPanel;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class TaskView extends BorderPane {

    private TaskPanel mAllTasksPanel;
    private TaskPanel mBacklogTasksPanel;
    private TaskPanel mDailyTasksPanel;

    public TaskView(SaveManager saveManager) {
        mDailyTasksPanel = new TaskPanel("Daily To-Do", saveManager.getDailyTodos(), saveManager);
        mBacklogTasksPanel = new TaskPanel("Backlog To-Do", saveManager.getBacklogTodos(), saveManager);
        mAllTasksPanel = new TaskPanel("All Tasks", saveManager.getAllTodos(), saveManager);

        this.setLeft(mAllTasksPanel);
        this.setCenter(mBacklogTasksPanel);
        this.setRight(mDailyTasksPanel);
        this.getStyleClass().add("view-pane");

        BorderPane.setMargin(mAllTasksPanel, new Insets(0, 20, 0, 20));
        BorderPane.setMargin(mBacklogTasksPanel, new Insets(0, 20, 0, 20));
        BorderPane.setMargin(mDailyTasksPanel, new Insets(0, 0, 0, 20));
    }
}