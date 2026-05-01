package com.betterstudentteam.thebetterstudentapp.frontend.panels;

import com.betterstudentteam.thebetterstudentapp.backend.todo.Todo;
import com.betterstudentteam.thebetterstudentapp.backend.todo.TodoList;
import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskPanel extends VBox {
    private ArrayList<CheckBox> mUserTaskList = new ArrayList<>();

    private HBox mDailyNewTaskContainer;
    private Label mDailyTasks;
    private TextField mDailyNewTaskField;
    private Button mDailyNewTaskButton;

    private SaveManager mSaveManager;
    private TodoList mTodoList;

    public TaskPanel(String title, TodoList todoList, SaveManager saveManager) {
        mSaveManager = saveManager;
        mTodoList = todoList;

        mDailyTasks = new Label(title);
        mDailyTasks.getStyleClass().add("daily-tasks-label");
        mDailyNewTaskField = new TextField();
        mDailyNewTaskField.setPromptText("Add task...");
        mDailyNewTaskField.getStyleClass().add("task-field");
        mDailyNewTaskButton = new Button("+");
        mDailyNewTaskButton.getStyleClass().add("add-task-button");
        mDailyNewTaskContainer = new HBox(mDailyNewTaskButton, mDailyNewTaskField);
        mDailyNewTaskButton.getStyleClass().add("new-task-container");
        this.getChildren().add(mDailyTasks);
        this.setMinWidth((Display.SCREEN_BOUNDS.getWidth() / 3 - 60));
        this.getChildren().add(mDailyNewTaskContainer);
        this.getStyleClass().add("task-panel");

        for (Todo item : todoList.getList()) {
            CheckBox task = new CheckBox(item.getTitle());
            task.setSelected(item.isCompleted());
            task.getStyleClass().add("task");
            mUserTaskList.add(task);
            this.getChildren().add(this.getChildren().size() - 1, task);
            wireDeleteOnCheck(task, item.getId());
        }

        mDailyNewTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addTask(mDailyNewTaskField.getText());
            }
        });
    }

    public void addTask(String taskName) {
        if (taskName.isEmpty()) return;
        Todo item = mTodoList.addTodo(taskName, LocalDate.now());
        CheckBox task = new CheckBox(taskName);
        task.getStyleClass().add("task");
        mUserTaskList.add(task);
        this.getChildren().add(this.getChildren().size() - 1, task);
        mDailyNewTaskField.setText("");
        wireDeleteOnCheck(task, item.getId());
        mSaveManager.save();
    }

    private void wireDeleteOnCheck(CheckBox task, String id) {
        task.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (task.isSelected()) {
                    mTodoList.deleteTodo(id);
                    mUserTaskList.remove(task);
                    TaskPanel.this.getChildren().remove(task);
                    mSaveManager.save();
                }
            }
        });
    }
}