package com.betterstudentteam.thebetterstudentapp.frontend.components;

import com.betterstudentteam.thebetterstudentapp.App;
import com.betterstudentteam.thebetterstudentapp.backend.Course;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import javafx.scene.Node;
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

        this.setOnMouseClicked(event -> addCourse());
    }

    private void addCourse() {
        CourseCard courseCard = new CourseCard();
        mCourseCardArrayList.add(courseCard);
        this.getChildren().add(courseCard);
    }

    public static ArrayList<Course> getCourseArrayList() {
        ArrayList<Course> courseArrayList = new ArrayList<Course>();
        for (CourseCard courseCard: mCourseCardArrayList) {
            courseArrayList.add(courseCard.getCourse());
        }
        return courseArrayList;
    }
}
