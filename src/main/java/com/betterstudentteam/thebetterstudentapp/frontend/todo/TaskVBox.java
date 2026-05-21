package com.betterstudentteam.thebetterstudentapp.frontend.todo;

import atlantafx.base.theme.Styles;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class TaskVBox extends VBox {

    private Label mHeader;
    private Separator mSeperator;

    public TaskVBox(String name) {
        mHeader = new Label(name);
        mHeader.getStyleClass().add(Styles.TITLE_1);
        this.getChildren().add(mHeader);

        mSeperator = new Separator(Orientation.HORIZONTAL);
        this.getChildren().add(mSeperator);

        this.setMinWidth(Display.SCREEN_BOUNDS.getWidth() / 3.0);
        this.setOnMouseClicked(event -> addTask());
        this.setOnMouseEntered(event -> changeCursor());
    }

    private void addTask() {
        this.getChildren().add(new Task());
    }

    private void changeCursor() {
        getScene().setCursor(Cursor.HAND);
    }
}