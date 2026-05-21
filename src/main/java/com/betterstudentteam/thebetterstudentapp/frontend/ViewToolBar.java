package com.betterstudentteam.thebetterstudentapp.frontend;

import com.betterstudentteam.thebetterstudentapp.frontend.home.HomePane;
import com.betterstudentteam.thebetterstudentapp.frontend.setup.SetupPane;
import com.betterstudentteam.thebetterstudentapp.frontend.todo.TodoPane;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;

public class ViewToolBar extends ToolBar {

    private BorderPane mRootNode;
    private HomePane mHomePaneInstance;
    private TodoPane mTodoPaneInstance;
    private SetupPane mSetupPaneInstance;

    public ViewToolBar(BorderPane rootNode, HomePane homePaneInstance, TodoPane todoPaneInstance, SetupPane setupPaneInstance) {
        super(new Button("Home"), new Separator(Orientation.VERTICAL), new Button("Todo"), new Separator(Orientation.VERTICAL), new Button("Setup"));
        mRootNode = rootNode;
        mHomePaneInstance = homePaneInstance;
        mTodoPaneInstance = todoPaneInstance;
        mSetupPaneInstance = setupPaneInstance;

        getHomeButton().setOnAction(event -> getRootNode().setCenter(mHomePaneInstance));
        getTodoButton().setOnAction(event -> getRootNode().setCenter(mTodoPaneInstance));
        getSetupButton().setOnAction(event -> getRootNode().setCenter(mSetupPaneInstance));
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

    public BorderPane getRootNode() {
        return mRootNode;
    }
}