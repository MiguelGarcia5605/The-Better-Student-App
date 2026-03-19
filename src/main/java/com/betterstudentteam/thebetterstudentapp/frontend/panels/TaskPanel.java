package com.betterstudentteam.thebetterstudentapp.frontend.panels;

import com.betterstudentteam.thebetterstudentapp.backend.todo.Todo;
import com.betterstudentteam.thebetterstudentapp.backend.todo.TodoList;
import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.time.LocalDate;
import java.util.ArrayList;

public class TaskPanel extends VBox {
    private ArrayList<CheckBox> mUserTaskList = new ArrayList<>();

    private HBox mNewTaskContainer;
    private Label mTasks;
    private TextField mNewTaskField;
    private Button mNewTaskButton;

    private SaveHandler mSaveHandler;
    private TodoList mTodoList;

    public TaskPanel(String title, TodoList todoList, SaveHandler saveHandler) {
        mSaveHandler = saveHandler;
        mTodoList = todoList;

        mTasks = new Label(title);
        mTasks.getStyleClass().add("daily-tasks-label");
        mNewTaskField = new TextField();
        mNewTaskField.setPromptText("Add task...");
        mNewTaskField.getStyleClass().add("task-field");
        mNewTaskButton = new Button("+");
        mNewTaskButton.getStyleClass().add("add-task-button");
        mNewTaskContainer = new HBox(mNewTaskButton, mNewTaskField);
        mNewTaskButton.getStyleClass().add("new-task-container");
        this.getChildren().add(mTasks);
        this.setMinWidth((Display.SCREEN_BOUNDS.getWidth() / 3 - 60));
        this.getChildren().add(mNewTaskContainer);
        this.getStyleClass().add("task-panel");

        mNewTaskField.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.ENTER) {
                    addTask(mNewTaskField.getText());
                }
            }
        });

        for (Todo item : todoList.getList()) {
            CheckBox task = new CheckBox(item.getTitle());
            task.getStyleClass().add("task");
            mUserTaskList.add(task);
            this.getChildren().add(this.getChildren().size() - 1, task);

            task.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    if (task.isSelected()) {
                        mTodoList.remove(item.getID());
                        mUserTaskList.remove(task);
                        TaskPanel.this.getChildren().remove(task);
                        mSaveHandler.save();
                    }
                }
            });
        }

        mNewTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                addTask(mNewTaskField.getText());
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
        mNewTaskField.setText("");

        task.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (task.isSelected()) {
                    mTodoList.remove(item.getID());
                    mUserTaskList.remove(task);
                    TaskPanel.this.getChildren().remove(task);
                    mSaveHandler.save();
                }
            }
        });

        mSaveHandler.save();
    }
}