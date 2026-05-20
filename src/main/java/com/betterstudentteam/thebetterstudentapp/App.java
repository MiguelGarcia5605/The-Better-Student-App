package com.betterstudentteam.thebetterstudentapp;

import atlantafx.base.theme.PrimerDark;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import com.betterstudentteam.thebetterstudentapp.frontend.home.HomePane;
import com.betterstudentteam.thebetterstudentapp.frontend.ViewToolBar;
import com.betterstudentteam.thebetterstudentapp.frontend.setup.SetupPane;
import com.betterstudentteam.thebetterstudentapp.frontend.todo.TodoPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
    private static final String APP_NAME = "The Better Student App";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        primaryStage.setTitle(APP_NAME);

        HomePane homePane = new HomePane();
        TodoPane todoPane = new TodoPane();
        SetupPane setupPane = new SetupPane();

        BorderPane rootNode = new BorderPane(setupPane);
        ViewToolBar viewToolBar = new ViewToolBar(rootNode, homePane, todoPane, setupPane);
        rootNode.setTop(viewToolBar);
        rootNode.getStyleClass().add("pane_background");

        Scene scene = new Scene(rootNode);
        scene.getStylesheets().add("StyleSheet.css");

        // Set Fullscreen
        primaryStage.setScene(scene);
        primaryStage.setX(Display.SCREEN_BOUNDS.getMinX());
        primaryStage.setY(Display.SCREEN_BOUNDS.getMinY());
        primaryStage.setWidth(Display.SCREEN_BOUNDS.getWidth());
        primaryStage.setHeight(Display.SCREEN_BOUNDS.getHeight());
        primaryStage.show();
    }
}