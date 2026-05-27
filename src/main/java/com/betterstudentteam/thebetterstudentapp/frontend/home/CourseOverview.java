package com.betterstudentteam.thebetterstudentapp.frontend.home;

import com.betterstudentteam.thebetterstudentapp.backend.Display;
import javafx.scene.layout.VBox;

public class CourseOverview extends VBox {

    public CourseOverview() {
        this.setMaxWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setMaxHeight((Display.SCREEN_BOUNDS.getWidth() / 10.0) * 9.0);
        this.setPrefWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setPrefHeight((Display.SCREEN_BOUNDS.getWidth() / 10.0) * 9.0);
        this.getStyleClass().add("course_overview_panel");
    }
}
