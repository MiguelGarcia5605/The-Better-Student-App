package com.betterstudentteam.thebetterstudentapp.frontend.todo;

import atlantafx.base.theme.Styles;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TodoPane extends BorderPane {

    private VBox mAllTodoPanel;
    private VBox mBacklogTodoPanel;
    private VBox mDailyTodoPanel;

    private Label mAllTodoHeader;
    private Label mBacklogTodoHeader;
    private Label mDailyTodoHeader;

    public TodoPane() {
        mAllTodoHeader = new Label("All Todo");
        mAllTodoHeader.getStyleClass().add(Styles.TITLE_1);

        mBacklogTodoHeader = new Label("Backlog Todo");
        mBacklogTodoHeader.getStyleClass().add(Styles.TITLE_1);

        mDailyTodoHeader = new Label("Daily Todo");
        mDailyTodoHeader.getStyleClass().add(Styles.TITLE_1);

        mAllTodoPanel = new VBox();
        mAllTodoPanel.getStyleClass().add("panel_all-todo");
        mAllTodoPanel.getChildren().add(mAllTodoHeader);
        mAllTodoPanel.setMinWidth(Display.SCREEN_BOUNDS.getWidth() / 3.0);
        this.setLeft(mAllTodoPanel);

        mBacklogTodoPanel = new VBox();
        mBacklogTodoPanel.getStyleClass().add("panel_backlog-todo");
        mBacklogTodoPanel.getChildren().add(mBacklogTodoHeader);
        mBacklogTodoPanel.setMinWidth(Display.SCREEN_BOUNDS.getWidth() / 3.0);
        this.setCenter(mBacklogTodoPanel);

        mDailyTodoPanel = new VBox();
        mDailyTodoPanel.getStyleClass().add("panel_daily-todo");
        mDailyTodoPanel.getChildren().add(mDailyTodoHeader);
        mDailyTodoPanel.setMinWidth(Display.SCREEN_BOUNDS.getWidth() / 3.0);
        this.setRight(mDailyTodoPanel);
    }
}