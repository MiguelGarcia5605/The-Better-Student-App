package com.betterstudentteam.thebetterstudentapp.frontend.view;

import com.betterstudentteam.thebetterstudentapp.backend.todo_list.TodoList;
import com.betterstudentteam.thebetterstudentapp.backend.util.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.TaskPanel;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class TaskView extends BorderPane {

    private TaskPanel mAllTasksPanel;
    private TaskPanel mBacklogTasksPanel;
    private TaskPanel mDailyTasksPanel;

    public TaskView(TodoList dailyTodos, TodoList backlogTodos, TodoList allTodos, SaveManager saveManager) {
        mDailyTasksPanel = new TaskPanel("Daily To-Do", dailyTodos, saveManager);
        mBacklogTasksPanel = new TaskPanel("Backlog To-Do", backlogTodos, saveManager);
        mAllTasksPanel = new TaskPanel("All Tasks", allTodos, saveManager);

        this.setLeft(mAllTasksPanel);
        this.setCenter(mBacklogTasksPanel);
        this.setRight(mDailyTasksPanel);
        this.getStyleClass().add("home-page-pane");

        BorderPane.setMargin(mAllTasksPanel, new Insets(0, 20, 0, 20));
        BorderPane.setMargin(mBacklogTasksPanel, new Insets(0, 20, 0, 20));
        BorderPane.setMargin(mDailyTasksPanel, new Insets(0, 0, 0, 20));
    }
}
