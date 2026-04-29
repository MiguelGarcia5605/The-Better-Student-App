package com.betterstudentteam.thebetterstudentapp.view.navigation;

import com.betterstudentteam.thebetterstudentapp.courses.CourseManager;
import com.betterstudentteam.thebetterstudentapp.todo_list.TodoManager;
import com.betterstudentteam.thebetterstudentapp.user_setup.UserSetupManager;
import com.betterstudentteam.thebetterstudentapp.util.SaveManager;
import com.betterstudentteam.thebetterstudentapp.view.HomePageView;
import com.betterstudentteam.thebetterstudentapp.view.TaskView;
import com.betterstudentteam.thebetterstudentapp.view.SetupView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class NavBar extends HBox {

    private Button mHomeButton;
    private Button mTaskButton;
    private Button mSetupButton;

    private TodoManager mDailyTodos;
    private TodoManager mBacklogTodos;
    private TodoManager mAllTodos;

    public NavBar(BorderPane wrapper, CourseManager courseManager, TodoManager dailyTodos, TodoManager backlogTodos, TodoManager allTodos, UserSetupManager setupManager, SaveManager saveManager) {
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
                wrapper.setCenter(new HomePageView(courseManager, dailyTodos, saveManager));
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