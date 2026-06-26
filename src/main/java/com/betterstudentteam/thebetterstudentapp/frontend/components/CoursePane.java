package com.betterstudentteam.thebetterstudentapp.frontend.components;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CoursePane extends BorderPane {

    private VBox mLeftContainer;

    private AssignmentList mDailyList;

    public CoursePane() {
        mLeftContainer = new VBox();

        //mLeftContainer.getChildren().add();
        //mLeftContainer.getChildren().add();
        this.setLeft(mLeftContainer);

        mDailyList = new AssignmentList("Daily Todo");
        mDailyList.getStyleClass().add("panel_daily-todo");
        this.setRight(mDailyList);
    }
}
