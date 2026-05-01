package com.betterstudentteam.thebetterstudentapp.frontend.components;

import com.betterstudentteam.thebetterstudentapp.backend.todo_list.TodoList;
import com.betterstudentteam.thebetterstudentapp.backend.util.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.view.HomePageView;
import com.betterstudentteam.thebetterstudentapp.frontend.view.TaskView;
import com.betterstudentteam.thebetterstudentapp.frontend.view.SetupView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class NavBar extends HBox {

    private Button mHomeButton;
    private Button mTaskButton;
    private Button mSetupButton;

    private TodoList mDailyTodos;
    private TodoList mBacklogTodos;
    private TodoList mAllTodos;

    public NavBar(BorderPane wrapper, CourseManager courseManager, TodoList dailyTodos, TodoList backlogTodos, TodoList allTodos, UserSetupManager setupManager, SaveManager saveManager) {
        mHomeButton = new Button("Home");
        mTaskButton = new Button("Tasks");
        mSetupButton = new Button("Setup");

        mDailyTodos = dailyTodos;
        mBacklogTodos = backlogTodos;
        mAllTodos = allTodos;

        mHomeButton.getStyleClass().add("nav-button");
        mTaskButton.getStyleClass().add("nav-button");
        mSetupButton.getStyleClass().add("nav-button");

        mHomeButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                wrapper.setCenter(new HomePageView(wrapper, courseManager, dailyTodos, saveManager));
            }
        });

        mTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                wrapper.setCenter(new TaskView(dailyTodos, backlogTodos, allTodos, saveManager));
            }
        });

        mSetupButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                wrapper.setCenter(new SetupView(wrapper, courseManager, dailyTodos, setupManager, saveManager));
            }
        });

        this.getChildren().addAll(mHomeButton, mTaskButton, mSetupButton);
        this.getStyleClass().add("nav-bar");
        this.setSpacing(10);
    }
}