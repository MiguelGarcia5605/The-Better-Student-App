package com.betterstudentteam.thebetterstudentapp.frontend.home;

import com.betterstudentteam.thebetterstudentapp.frontend.todo.TaskVBox;
import javafx.scene.layout.BorderPane;

public class HomePane extends BorderPane {

    private QuoteDisplay mQuoteDisplay;
    private TaskVBox mDailyTodoPanel;

    public HomePane() {
        mQuoteDisplay = new QuoteDisplay();
        this.setLeft(mQuoteDisplay);

        mDailyTodoPanel = new TaskVBox("Daily Todo");
        mDailyTodoPanel.getStyleClass().add("panel_daily-todo");
        this.setRight(mDailyTodoPanel);
    }
}
