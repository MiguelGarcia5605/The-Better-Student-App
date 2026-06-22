package com.betterstudentteam.thebetterstudentapp.frontend.components;

import javafx.scene.layout.BorderPane;

public class AssignmentPane extends BorderPane {

    private AssignmentList mSomedayList;
    private AssignmentList mBacklogList;
    private AssignmentList mDailyList;

    public AssignmentPane() {
        mSomedayList = new AssignmentList("Someday");
        mSomedayList.getStyleClass().add("panel_all-todo");
        this.setLeft(mSomedayList);

        mBacklogList = new AssignmentList("Backlog");
        mBacklogList.getStyleClass().add("panel_backlog-todo");
        this.setCenter(mBacklogList);

        mDailyList = new AssignmentList("Daily");
        mDailyList.getStyleClass().add("panel_daily-todo");
        this.setRight(mDailyList);
    }
}