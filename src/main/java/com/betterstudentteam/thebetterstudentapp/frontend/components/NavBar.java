package com.betterstudentteam.thebetterstudentapp.frontend.components;

import atlantafx.base.theme.CupertinoLight;
import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.view.HomePageView;
import com.betterstudentteam.thebetterstudentapp.frontend.view.TaskView;
import com.betterstudentteam.thebetterstudentapp.frontend.view.SetupView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class NavBar extends HBox {

    private Button mHomeButton;
    private Button mTaskButton;
    private Button mSetupButton;

    private Button mStyleModeButton;

    private BorderPane mWrapper;
    private SaveManager mSaveManager;

    public NavBar(BorderPane wrapper, SaveManager saveManager) {
        mHomeButton = new Button("Home");
        mTaskButton = new Button("Tasks");
        mSetupButton = new Button("Setup");

        mStyleModeButton = new Button("[-]");
        mStyleModeButton.getStyleClass().add("style-mode-button");

        mWrapper = wrapper;
        mSaveManager = saveManager;

        mHomeButton.getStyleClass().add("nav-button");
        mTaskButton.getStyleClass().add("nav-button");
        mSetupButton.getStyleClass().add("nav-button");

        mHomeButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mWrapper.setCenter(new HomePageView(mWrapper, mSaveManager));
            }
        });

        mTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mWrapper.setCenter(new TaskView(mSaveManager));
            }
        });

        mSetupButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mWrapper.setCenter(new SetupView(mWrapper, mSaveManager));
            }
        });

        mStyleModeButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (Application.getUserAgentStylesheet().equals(new PrimerDark().getUserAgentStylesheet())) {
                    Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
                } else {
                    Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());
                }
            }
        });

        this.getChildren().addAll(mHomeButton, mTaskButton, mSetupButton, mStyleModeButton);
        this.getStyleClass().add("nav-bar");
        this.setSpacing(10);
    }
}