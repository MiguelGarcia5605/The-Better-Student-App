package com.betterstudentteam.thebetterstudentapp.view;

import com.betterstudentteam.thebetterstudentapp.view.panels.CourseViewPanel;
import com.betterstudentteam.thebetterstudentapp.view.panels.QuotePanel;
import com.betterstudentteam.thebetterstudentapp.view.panels.TaskPanel;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HomePageView extends BorderPane {

    private VBox mDailyQuoteAndCourseViewsContainer;

    private QuotePanel mQuotePanel;

    private CourseViewPanel mCourseViewPanel;

    private TaskPanel mTaskPanel;

    public HomePageView() {
        mQuotePanel = new QuotePanel();
        mCourseViewPanel = new CourseViewPanel();

        // Daily quote and course views container
        mDailyQuoteAndCourseViewsContainer = new VBox();
        mDailyQuoteAndCourseViewsContainer.getChildren().add(mQuotePanel);
        mDailyQuoteAndCourseViewsContainer.getChildren().add(mCourseViewPanel);
        mDailyQuoteAndCourseViewsContainer.getStyleClass().add("left-container");

        mTaskPanel = new TaskPanel("Daily To-Do");

        // Course card
        mCourseViewPanel.addCourseCard("ENG 110",
                "Next: Research paper due Friday, May 1st",
                "A - 99.76%");

        this.setLeft(mDailyQuoteAndCourseViewsContainer);
        this.setRight(mTaskPanel);
        this.getStyleClass().add("home-page-pane");

        BorderPane.setMargin(mTaskPanel, new Insets(0, 40, 0, 10));
    }

}