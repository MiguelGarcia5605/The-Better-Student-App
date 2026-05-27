package com.betterstudentteam.thebetterstudentapp.frontend.home;

import com.betterstudentteam.thebetterstudentapp.frontend.todo.TaskVBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HomePane extends BorderPane {

    private VBox mLeftContainer;
    private CourseOverview mCourseOverview;
    private QuoteDisplay mQuoteDisplay;
    private TaskVBox mDailyTodoPanel;

    public HomePane() {
        mLeftContainer = new VBox();
        mQuoteDisplay = new QuoteDisplay();
        mCourseOverview = new CourseOverview();

        mLeftContainer.getChildren().add(mQuoteDisplay);
        mLeftContainer.getChildren().add(mCourseOverview);
        this.setLeft(mLeftContainer);

        mDailyTodoPanel = new TaskVBox("Daily Todo");
        mDailyTodoPanel.getStyleClass().add("panel_daily-todo");
        this.setRight(mDailyTodoPanel);
    }
}
