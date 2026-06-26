package com.betterstudentteam.thebetterstudentapp.frontend.components;

import com.betterstudentteam.thebetterstudentapp.App;
import com.betterstudentteam.thebetterstudentapp.backend.Course;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import com.betterstudentteam.thebetterstudentapp.frontend.scene.Scenes;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CourseList extends VBox {

    private static ArrayList<CourseCard> mCourseCardArrayList = new ArrayList<CourseCard>();

    public CourseList() {
        this.setMaxWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setMaxHeight((Display.SCREEN_BOUNDS.getWidth() / 10.0) * 9.0);
        this.setPrefWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setPrefHeight((Display.SCREEN_BOUNDS.getWidth() / 10.0) * 9.0);
        this.setSpacing(15);
        this.getStyleClass().add("course_overview_panel");

        this.setOnMouseClicked(event -> mouseOnClick(event));
    }

    private void mouseOnClick(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            CourseCard courseCard = new CourseCard();
            mCourseCardArrayList.add(courseCard);
            courseCard.setOnMouseClicked(e -> {
                if (e.getButton() == MouseButton.PRIMARY) {
                    // Change scene to course view
                    App.getSceneManager().setScene(Scenes.COURSE);
                } else if (e.getButton() == MouseButton.SECONDARY) {
                    this.getChildren().remove(courseCard);
                }
            });
            this.getChildren().add(courseCard);
        }
    }

    public static ArrayList<Course> getCourseArrayList() {
        ArrayList<Course> courseArrayList = new ArrayList<Course>();
        for (CourseCard courseCard: mCourseCardArrayList) {
            courseArrayList.add(courseCard.getCourse());
        }
        return courseArrayList;
    }
}
