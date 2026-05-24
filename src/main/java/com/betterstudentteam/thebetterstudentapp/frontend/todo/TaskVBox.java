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

    // Something in this set on mouse click logic is causing an error !!
    private void addNewTask() {
        if (mTaskArrayList.size() < MAX_TASK_AMOUNT) {
            Task task = new Task();
            mTaskArrayList.add(task);
            this.getChildren().add(task);
            task.getCheckBox().setOnMouseClicked(event -> moveTaskToTop(task));
        }
    }

    private void changeCursor() {
        getScene().setCursor(Cursor.HAND);
    }

    public void moveTaskToTop(Task task) {
        if (task.getTextField().getText().isBlank() || hasDuplicateTasks(mTaskArrayList, task)) {
            task.getCheckBox().setSelected(false);
            return;
        }

        // remove task from arrays
        this.getChildren().remove(task);
        mTaskArrayList.remove(task);

        // disable and move to top
        task.setDisable(true);
        mTaskArrayList.addFirst(task);

        // value shouldnt be hard coded
        this.getChildren().add(2, task);

    }

    private boolean hasDuplicateTasks(ArrayList<Task> arrayList, Task task) {
        int count = 0;
        for (Task currentTask : arrayList) {
            if (task.equals(currentTask)) {
                count++;
            }
        }

        if (count > 1) {
            return true;
        }
        return false;
    }
}