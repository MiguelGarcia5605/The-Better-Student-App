package com.betterstudentteam.thebetterstudentapp.frontend.todo;

import javafx.scene.layout.BorderPane;

public class TodoPane extends BorderPane {

    private TaskVBox mAllTodoPanel;
    private TaskVBox mBacklogTodoPanel;
    private TaskVBox mDailyTodoPanel;

    public TodoPane() {
        mAllTodoPanel = new TaskVBox("All Todo");
        mAllTodoPanel.getStyleClass().add("panel_all-todo");
        this.setLeft(mAllTodoPanel);

        mBacklogTodoPanel = new TaskVBox("Backlog Todo");
        mBacklogTodoPanel.getStyleClass().add("panel_backlog-todo");
        this.setCenter(mBacklogTodoPanel);

        mDailyTodoPanel = new TaskVBox("Daily Todo");
        mDailyTodoPanel.getStyleClass().add("panel_daily-todo");
        this.setRight(mDailyTodoPanel);
    }
}