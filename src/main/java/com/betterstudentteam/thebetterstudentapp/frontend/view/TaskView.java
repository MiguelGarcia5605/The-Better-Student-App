package com.betterstudentteam.thebetterstudentapp.frontend.view;

import com.betterstudentteam.thebetterstudentapp.backend.save.SaveHandler;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.TaskPanel;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class TaskView extends BorderPane {

    private TaskPanel mAllTasksPanel;
    private TaskPanel mBacklogTasksPanel;
    private TaskPanel mDailyTasksPanel;

    public TaskView(SaveHandler saveHandler) {
        mDailyTasksPanel = new TaskPanel("Daily To-Do", saveHandler.getDailyTodos(), saveHandler);
        mBacklogTasksPanel = new TaskPanel("Backlog To-Do", saveHandler.getBacklogTodos(), saveHandler);
        mAllTasksPanel = new TaskPanel("All Tasks", saveHandler.getAllTodos(), saveHandler);

        this.setLeft(mAllTasksPanel);
        this.setCenter(mBacklogTasksPanel);
        this.setRight(mDailyTasksPanel);
        this.getStyleClass().add("view-pane");

        BorderPane.setMargin(mAllTasksPanel, new Insets(0, 20, 0, 20));
        BorderPane.setMargin(mBacklogTasksPanel, new Insets(0, 20, 0, 20));
        BorderPane.setMargin(mDailyTasksPanel, new Insets(0, 0, 0, 20));
    }
}