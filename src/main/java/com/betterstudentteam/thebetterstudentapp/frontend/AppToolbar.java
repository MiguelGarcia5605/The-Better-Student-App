package com.betterstudentteam.thebetterstudentapp.frontend;

import com.betterstudentteam.thebetterstudentapp.App;
import com.betterstudentteam.thebetterstudentapp.frontend.scene.Scenes;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;

public class AppToolbar extends ToolBar {

    public AppToolbar() {
        super(new Button("Home"), new Separator(Orientation.VERTICAL), new Button("Todo"), new Separator(Orientation.VERTICAL), new Button("Setup"));

        getHomeButton().setOnAction(event -> App.getSceneManager().setScene(Scenes.HOME));
        getTodoButton().setOnAction(event -> App.getSceneManager().setScene(Scenes.TODO));
        getSetupButton().setOnAction(event -> App.getSceneManager().setScene(Scenes.SETUP));
    }

    public Button getHomeButton() {
        return (Button) this.getItems().get(0);
    }

    public Button getTodoButton() {
        return (Button) this.getItems().get(2);
    }

    public Button getSetupButton() {
        return (Button) this.getItems().get(4);
    }
}