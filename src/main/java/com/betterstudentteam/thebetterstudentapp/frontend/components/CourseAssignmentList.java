package com.betterstudentteam.thebetterstudentapp.frontend.components;

import com.betterstudentteam.thebetterstudentapp.backend.Display;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CourseAssignmentList extends VBox {

    private static ArrayList<AssignmentCard> mAssignmentCard = new ArrayList<AssignmentCard>();

    public CourseAssignmentList() {
        this.setMaxWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setMaxHeight((Display.SCREEN_BOUNDS.getWidth() / 10.0) * 9.0);
        this.setPrefWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setPrefHeight((Display.SCREEN_BOUNDS.getWidth() / 10.0) * 9.0);
        this.setSpacing(15);
        this.getStyleClass().add("course_assignment_overview_panel");
    }
}
