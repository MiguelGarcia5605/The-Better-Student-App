package com.betterstudentteam.thebetterstudentapp.frontend.view;

import com.betterstudentteam.thebetterstudentapp.backend.todo.TodoList;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.TaskPanel;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class TaskView extends BorderPane {

    private TaskPanel mAllTasksPanel;
    private TaskPanel mBacklogTasksPanel;
    private TaskPanel mDailyTasksPanel;

    private TodoList mDailyTodos;
    private TodoList mBacklogTodos;
    private TodoList mAllTodos;

    private SaveManager mSaveManager;

    public TaskView(SaveManager saveManager) {
        mSaveManager = saveManager;

        mDailyTodos = mSaveManager.getDailyTodos();
        mBacklogTodos = mSaveManager.getBacklogTodos();
        mAllTodos = mSaveManager.getAllTodos();

        mDailyTasksPanel = new TaskPanel("Daily To-Do", mDailyTodos, saveManager);
        mBacklogTasksPanel = new TaskPanel("Backlog To-Do", mBacklogTodos, saveManager);
        mAllTasksPanel = new TaskPanel("All Tasks", mAllTodos, saveManager);

        this.setLeft(mAllTasksPanel);
        this.setCenter(mBacklogTasksPanel);
        this.setRight(mDailyTasksPanel);
        this.getStyleClass().add("home-page-pane");

        BorderPane.setMargin(mAllTasksPanel, new Insets(0, 20, 0, 20));
        BorderPane.setMargin(mBacklogTasksPanel, new Insets(0, 20, 0, 20));
        BorderPane.setMargin(mDailyTasksPanel, new Insets(0, 0, 0, 20));
    }
}
