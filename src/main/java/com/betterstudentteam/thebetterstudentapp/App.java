package com.betterstudentteam.thebetterstudentapp;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setTitle("The Better Student App");

        Label dailyToDoHeader = new Label("Daily To-Do");

        CheckBox task = new CheckBox("Create Chart");
        VBox vBox = new VBox(dailyToDoHeader, task);
        BorderPane borderPane = new BorderPane();
        borderPane.setRight(vBox);
        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.show();
    }
}