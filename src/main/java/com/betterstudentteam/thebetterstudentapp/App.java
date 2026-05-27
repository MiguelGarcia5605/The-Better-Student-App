package com.betterstudentteam.thebetterstudentapp;

import atlantafx.base.theme.PrimerDark;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import com.betterstudentteam.thebetterstudentapp.frontend.scene.SceneManager;
import com.betterstudentteam.thebetterstudentapp.frontend.scene.Scenes;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage mStage;
    private static SceneManager mSceneManager;

    private static final String APP_NAME = "The Better Student App";

    @Override
    public void start(Stage stage) throws Exception {
        mStage = stage;
        mSceneManager = new SceneManager();

        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
        mStage.setTitle(APP_NAME);

        //rootNode.getStyleClass().add("pane_background");

        // Set Fullscreen
        mSceneManager.setScene(Scenes.HOME);
        mStage.setX(Display.SCREEN_BOUNDS.getMinX());
        mStage.setY(Display.SCREEN_BOUNDS.getMinY());
        mStage.setWidth(Display.SCREEN_BOUNDS.getWidth());
        mStage.setHeight(Display.SCREEN_BOUNDS.getHeight());
        mStage.show();
    }

    public static Stage getStage() {
        return mStage;
    }

    public static SceneManager getSceneManager() {
        return mSceneManager;
    }
}