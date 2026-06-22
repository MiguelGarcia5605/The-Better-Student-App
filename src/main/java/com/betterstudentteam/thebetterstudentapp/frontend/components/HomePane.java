package com.betterstudentteam.thebetterstudentapp.frontend.components;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HomePane extends BorderPane {

    private VBox mLeftContainer;
    private CourseList mCourseList;
    private GreetingCard mGreetingCard;
    private AssignmentList mDailyList;

    public HomePane() {
        mLeftContainer = new VBox();
        mGreetingCard = new GreetingCard();
        mCourseList = new CourseList();

        mLeftContainer.getChildren().add(mGreetingCard);
        mLeftContainer.getChildren().add(mCourseList);
        this.setLeft(mLeftContainer);

        mDailyList = new AssignmentList("Daily Todo");
        mDailyList.getStyleClass().add("panel_daily-todo");
        this.setRight(mDailyList);
    }
}
