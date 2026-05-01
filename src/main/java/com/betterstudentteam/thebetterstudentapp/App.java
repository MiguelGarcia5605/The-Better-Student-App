package com.betterstudentteam.thebetterstudentapp;

import atlantafx.base.theme.PrimerDark;
import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveHandler;
import com.betterstudentteam.thebetterstudentapp.backend.todo.TodoList;
import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import com.betterstudentteam.thebetterstudentapp.frontend.components.NavBar;
import com.betterstudentteam.thebetterstudentapp.frontend.view.HomePageView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.ArrayList;

public class App extends Application {
    private static final String APP_NAME = "The Better Student App";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        primaryStage.setTitle(APP_NAME);

        ArrayList<Course> courseList = new ArrayList<>();
        TodoList dailyTodos = new TodoList();
        TodoList backlogTodos = new TodoList();
        TodoList allTodos = new TodoList();
        SaveHandler saveHandler = new SaveHandler(courseList, dailyTodos, backlogTodos, allTodos);

        saveHandler.load();

        BorderPane wrapper = new BorderPane();
        NavBar navBar = new NavBar(wrapper, saveHandler);
        wrapper.setCenter(new HomePageView(wrapper, saveHandler));
        wrapper.setTop(navBar);

        Scene scene = new Scene(wrapper);
        scene.getStylesheets().add("StyleSheet.css");

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent e) {
                saveHandler.save();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setX(Display.SCREEN_BOUNDS.getMinX());
        primaryStage.setY(Display.SCREEN_BOUNDS.getMinY());
        primaryStage.setWidth(Display.SCREEN_BOUNDS.getWidth());
        primaryStage.setHeight(Display.SCREEN_BOUNDS.getHeight());
        primaryStage.show();
    }
}