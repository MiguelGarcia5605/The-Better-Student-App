package com.betterstudentteam.thebetterstudentapp.frontend.todo;

import atlantafx.base.theme.Styles;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Task extends HBox {

    private CheckBox mCheckBox;
    private TextField mTextField;

    public Task() {
        mCheckBox = new CheckBox();
        mCheckBox.getStyleClass().add(Styles.LARGE);
        this.getChildren().add(mCheckBox);

        mTextField = new TextField();
        mTextField.getStyleClass().addAll(Styles.SMALL, Styles.ROUNDED);
        this.getChildren().add(mTextField);
    }
}
