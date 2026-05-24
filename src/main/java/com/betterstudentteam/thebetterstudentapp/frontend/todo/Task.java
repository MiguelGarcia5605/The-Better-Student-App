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
        mCheckBox.getStyleClass().add("task_check-box");
        this.getChildren().add(mCheckBox);

        mTextField = new TextField();
        mTextField.getStyleClass().addAll(Styles.ROUNDED, "task_text-field");
        this.getChildren().add(mTextField);

        this.getStyleClass().add("task");
    }

    public TextField getTextField() {
        return mTextField;
    }

    public CheckBox getCheckBox() {
        return mCheckBox;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Task) {
            Task task = (Task) obj;
            if (task.getTextField().getText() == null && this.getTextField().getText() == null)  {
                return true;
            } else if (task.getTextField().getText().equals(this.getTextField().getText())) {
                return true;
            }
        }
        return false;
    }
}
