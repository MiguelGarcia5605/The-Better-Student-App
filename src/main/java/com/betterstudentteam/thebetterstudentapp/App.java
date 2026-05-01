package com.betterstudentteam.thebetterstudentapp;

import atlantafx.base.theme.PrimerDark;
import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveManager;
import com.betterstudentteam.thebetterstudentapp.backend.todo.TodoList;
import com.betterstudentteam.thebetterstudentapp.frontend.components.NavBar;
import com.betterstudentteam.thebetterstudentapp.frontend.view.HomePageView;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application {
    private static final String APP_NAME = "The Better Student App";
    private static final Screen SCREEN = Screen.getPrimary();
    private static final Rectangle2D SCREEN_BOUNDS = SCREEN.getVisualBounds();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        primaryStage.setTitle(APP_NAME);

        // Create backend
        ArrayList<Course> courseList = new ArrayList<>();
        TodoList dailyTodos = new TodoList();
        TodoList backlogTodos = new TodoList();
        TodoList allTodos = new TodoList();
        SaveManager saveManager = new SaveManager(courseList, dailyTodos, backlogTodos, allTodos);

        // Load saved data
        saveManager.load();

        // Build wrapper
        BorderPane wrapper = new BorderPane();
        NavBar navBar = new NavBar(wrapper, courseList, dailyTodos, backlogTodos, allTodos, saveManager);
        wrapper.setCenter(new HomePageView(wrapper, courseList, dailyTodos, saveManager));
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