package com.betterstudentteam.thebetterstudentapp.frontend.setup;

import com.betterstudentteam.thebetterstudentapp.backend.Course;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CourseSetupRow extends HBox {

    private TextField mNameTextField;

    public CourseSetupRow() {
        mNameTextField = new TextField();
        this.getChildren().add(mNameTextField);
    }

    public Course getCourse() {
        return new Course(mNameTextField.getText());
    }

    public TextField getNameTextField() {
        return mNameTextField;
    }
}