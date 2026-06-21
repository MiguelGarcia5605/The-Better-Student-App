package com.betterstudentteam.thebetterstudentapp.frontend.course;

import atlantafx.base.controls.Card;
import atlantafx.base.controls.Tile;
import atlantafx.base.theme.Styles;
import com.betterstudentteam.thebetterstudentapp.backend.Course;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import javafx.scene.layout.VBox;

public class CourseOverview extends VBox {

    public CourseOverview() {
        this.setMaxWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setMaxHeight((Display.SCREEN_BOUNDS.getWidth() / 10.0) * 9.0);
        this.setPrefWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setPrefHeight((Display.SCREEN_BOUNDS.getWidth() / 10.0) * 9.0);
        this.setSpacing(15);
        this.getStyleClass().add("course_overview_panel");

        this.setOnMouseClicked(event -> addCourse(new Course("...")));
    }

    public void addCourse(Course course) {
        Card card = new Card();
        card.getStyleClass().add(Styles.INTERACTIVE);
        card.setHeader(new Tile(
                course.getName(),
                "MWF"
        ));
        this.getChildren().add(card);
    }
}
