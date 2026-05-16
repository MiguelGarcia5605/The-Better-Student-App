package com.betterstudentteam.thebetterstudentapp.frontend;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SetupCourseRow extends HBox {

    private TextField mNameTextField;

    public SetupCourseRow() {
        mNameTextField = new TextField();
        this.getChildren().add(mNameTextField);
    }
}