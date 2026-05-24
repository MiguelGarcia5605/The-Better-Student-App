package com.betterstudentteam.thebetterstudentapp.frontend.todo;

import atlantafx.base.theme.Styles;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class TaskVBox extends VBox {

    private Label mHeader;
    private Separator mSeperator;
    private ArrayList<Task> mTaskArrayList;

    private final int MAX_TASK_AMOUNT = 12;

    public TaskVBox(String name) {
        mTaskArrayList = new ArrayList<Task>();

        mHeader = new Label(name);
        mHeader.getStyleClass().add(Styles.TITLE_1);
        this.getChildren().add(mHeader);

        mSeperator = new Separator(Orientation.HORIZONTAL);
        this.getChildren().add(mSeperator);

        this.setMinWidth(Display.SCREEN_BOUNDS.getWidth() / 3.0);
        this.setOnMouseClicked(event -> addNewTask());
        this.setOnMouseEntered(event -> changeCursor());
    }

    private void addNewTask() {
        if (mTaskArrayList.size() < MAX_TASK_AMOUNT) {
            Task task = new Task();
            task.getCheckBox().setOnMouseClicked(event -> moveTaskToTop(task));
            mTaskArrayList.add(task);
            this.getChildren().add(task);
        }
    }

    private void changeCursor() {
        getScene().setCursor(Cursor.HAND);
    }

    public void moveTaskToTop(Task task) {
        // remove task from arrays
        mTaskArrayList.remove(task);
        this.getChildren().remove(task);

        mTaskArrayList.addFirst(task);
        this.getChildren().add(2, task);
    }
}