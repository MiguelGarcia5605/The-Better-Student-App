package com.betterstudentteam.thebetterstudentapp.view;

import com.betterstudentteam.thebetterstudentapp.view.panels.TaskPanel;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class TaskView extends BorderPane {

    private TaskPanel mAllTasksPanel;
    private TaskPanel mBacklogTasksPanel;
    private TaskPanel mDailyTasksPanel;

    public TaskView() {
        mDailyTasksPanel = new TaskPanel("Daily To-Do");
        mBacklogTasksPanel = new TaskPanel("Backlog To-Do");
        mAllTasksPanel = new TaskPanel("All Tasks");

        this.setLeft(mAllTasksPanel);
        this.setCenter(mBacklogTasksPanel);
        this.setRight(mDailyTasksPanel);
        this.getStyleClass().add("home-page-pane");

        BorderPane.setMargin(mAllTasksPanel, new Insets(0, 20, 0, 20));
        BorderPane.setMargin(mBacklogTasksPanel, new Insets(0, 20, 0, 20));
        BorderPane.setMargin(mDailyTasksPanel, new Insets(0, 0, 0, 20));
    }
}
