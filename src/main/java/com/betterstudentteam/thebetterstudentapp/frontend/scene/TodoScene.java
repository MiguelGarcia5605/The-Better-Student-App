package com.betterstudentteam.thebetterstudentapp.frontend.scene;

import com.betterstudentteam.thebetterstudentapp.frontend.AppToolbar;
import com.betterstudentteam.thebetterstudentapp.frontend.todo.TodoPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class TodoScene extends Scene {

    private static final BorderPane mBorderPane = new BorderPane();

    private TodoPane mTodoPane;

    public TodoScene() {
        super(mBorderPane);
        mTodoPane = new TodoPane();

        mBorderPane.setCenter(mTodoPane);
        this.getStylesheets().add("StyleSheet.css");
    }
}
