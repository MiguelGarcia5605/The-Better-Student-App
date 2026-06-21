package com.betterstudentteam.thebetterstudentapp.frontend.todo;

import javafx.scene.layout.BorderPane;

public class TodoPane extends BorderPane {

    // This todo list should be a "someday" list
    // Update names
    private TaskVBox mAllTodoPanel;

    private TaskVBox mBacklogTodoPanel;
    private TaskVBox mDailyTodoPanel;

    public TodoPane() {
        mAllTodoPanel = new TaskVBox("Someday");
        mAllTodoPanel.getStyleClass().add("panel_all-todo");
        this.setLeft(mAllTodoPanel);

        mBacklogTodoPanel = new TaskVBox("Backlog");
        mBacklogTodoPanel.getStyleClass().add("panel_backlog-todo");
        this.setCenter(mBacklogTodoPanel);

        mDailyTodoPanel = new TaskVBox("Daily");
        mDailyTodoPanel.getStyleClass().add("panel_daily-todo");
        this.setRight(mDailyTodoPanel);
    }
}