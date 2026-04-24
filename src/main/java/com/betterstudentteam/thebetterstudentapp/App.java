package com.betterstudentteam.thebetterstudentapp;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application {

    private ArrayList<CheckBox> mUserTasks = new ArrayList<>();
    private VBox mDailyTaskBox;
    private VBox mQuoteContainer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setTitle("The Better Student App");

        Label dailyToDoHeader = new Label("Daily To-Do");
        mDailyTaskBox = new VBox(dailyToDoHeader);
        mDailyTaskBox.getStyleClass().add("vbox");

        for (CheckBox task: mUserTasks) {
            mDailyTaskBox.getChildren().add(task);
        }


        Label textArea = new Label();
        textArea.setWrapText(true);
        textArea.setText("Be more than motivated, be more than driven, become literally obsessed to the point where people think you're fucking nuts.");
        textArea.setMaxWidth(Double.MAX_VALUE);

        textArea.getStyleClass().add("quote-label");
        mQuoteContainer = new VBox(textArea);
        mQuoteContainer.setAlignment(Pos.TOP_CENTER);
        mQuoteContainer.setMaxHeight(bounds.getHeight() / 8);
        mQuoteContainer.getStyleClass().add("quote-container");
        mQuoteContainer.setMaxWidth(bounds.getWidth() * (2.0 / 3.0));

        TextField textInput = new TextField();
        textInput.setPromptText("Add task...");
        textInput.getStyleClass().add("task-field");

        Button addTaskButton = new Button("+");
        addTaskButton.getStyleClass().add("add-task-button");
        mDailyTaskBox.getChildren().add(addTaskButton);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                CheckBox task = createDailyTask(textInput.getText());
                mUserTasks.add(task);
                mDailyTaskBox.getChildren().add(mDailyTaskBox.getChildren().size() - 1, task);
                textInput.setText("");
            }
        };

        addTaskButton.setOnAction(event);

        HBox addTaskRow = new HBox(addTaskButton, textInput);
        mDailyTaskBox.getChildren().add(addTaskRow);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(mDailyTaskBox);
        borderPane.setLeft(mQuoteContainer);
        mDailyTaskBox.setMinWidth(bounds.getWidth()/3);
        Scene scene = new Scene(borderPane);

        scene.getStylesheets().add("StyleSheet.css");

        primaryStage.setScene(scene);
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.show();
    }

    private CheckBox createDailyTask(String taskName) {
        CheckBox task = new CheckBox(taskName);
        //task.getStyleClass().add("task");
        return task;
    }
}