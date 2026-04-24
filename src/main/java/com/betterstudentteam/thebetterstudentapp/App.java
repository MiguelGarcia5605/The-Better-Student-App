package com.betterstudentteam.thebetterstudentapp;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

        Scene scene = new Scene(new HomePageView());
        scene.getStylesheets().add("StyleSheet.css");

        primaryStage.setScene(scene);
        primaryStage.setX(SCREEN_BOUNDS.getMinX());
        primaryStage.setY(SCREEN_BOUNDS.getMinY());
        primaryStage.setWidth(SCREEN_BOUNDS.getWidth());
        primaryStage.setHeight(SCREEN_BOUNDS.getHeight());
        primaryStage.show();
    }
}