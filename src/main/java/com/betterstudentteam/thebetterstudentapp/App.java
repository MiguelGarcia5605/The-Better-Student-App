package com.betterstudentteam.thebetterstudentapp;

import atlantafx.base.theme.PrimerDark;
import com.betterstudentteam.thebetterstudentapp.backend.assignment.AssignmentList;
import com.betterstudentteam.thebetterstudentapp.backend.todo_list.TodoList;
import com.betterstudentteam.thebetterstudentapp.backend.util.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.view.HomePageView;
import com.betterstudentteam.thebetterstudentapp.frontend.components.NavBar;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application {
    private static final String APP_NAME = "The Better Student App";
    private static final Screen SCREEN = Screen.getPrimary();
    private static final Rectangle2D SCREEN_BOUNDS = SCREEN.getVisualBounds();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        primaryStage.setTitle(APP_NAME);

        // Create backend
        AssignmentList assignmentList = new AssignmentList();
        CourseManager courseManager = new CourseManager(assignmentList);
        UserSetupManager setupManager = new UserSetupManager(courseManager);
        TodoList dailyTodos = new TodoList();
        TodoList backlogTodos = new TodoList();
        TodoList allTodos = new TodoList();
        SaveManager saveManager = new SaveManager(courseManager, assignmentList, dailyTodos, backlogTodos, allTodos);

        // Load saved data
        saveManager.load();

        // Build wrapper
        BorderPane wrapper = new BorderPane();
        NavBar navBar = new NavBar(wrapper, courseManager, dailyTodos, backlogTodos, allTodos, setupManager, saveManager);
        wrapper.setCenter(new HomePageView(wrapper, courseManager, dailyTodos, saveManager));
        wrapper.setTop(navBar);

        Scene scene = new Scene(wrapper);
        scene.getStylesheets().add("StyleSheet.css");

        // Save on close
        primaryStage.setOnCloseRequest(e -> saveManager.save());

        primaryStage.setScene(scene);
        primaryStage.setX(SCREEN_BOUNDS.getMinX());
        primaryStage.setY(SCREEN_BOUNDS.getMinY());
        primaryStage.setWidth(SCREEN_BOUNDS.getWidth());
        primaryStage.setHeight(SCREEN_BOUNDS.getHeight());
        primaryStage.show();
    }
}