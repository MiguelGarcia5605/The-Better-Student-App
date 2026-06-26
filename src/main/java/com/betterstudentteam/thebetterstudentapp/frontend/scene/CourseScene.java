package com.betterstudentteam.thebetterstudentapp.frontend.scene;

import com.betterstudentteam.thebetterstudentapp.frontend.components.CoursePane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class CourseScene extends Scene {

    private static final BorderPane mBorderPane = new BorderPane();

    private CoursePane mCoursePane;

    public CourseScene() {
        super(mBorderPane);
        mCoursePane = new CoursePane();

        mBorderPane.setCenter(mCoursePane);
        this.getStylesheets().add("StyleSheet.css");
    }
}
