package com.betterstudentteam.thebetterstudentapp.frontend.components;

import atlantafx.base.controls.Card;
import atlantafx.base.controls.Tile;
import atlantafx.base.theme.Styles;
import com.betterstudentteam.thebetterstudentapp.backend.Course;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import javafx.scene.layout.VBox;

public class CourseList extends VBox {

    public CourseList() {
        this.setMaxWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setMaxHeight((Display.SCREEN_BOUNDS.getWidth() / 10.0) * 9.0);
        this.setPrefWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setPrefHeight((Display.SCREEN_BOUNDS.getWidth() / 10.0) * 9.0);
        this.setSpacing(15);
        this.getStyleClass().add("course_overview_panel");

        this.setOnMouseClicked(event -> this.getChildren().add(new CourseCard()));
    }
}
