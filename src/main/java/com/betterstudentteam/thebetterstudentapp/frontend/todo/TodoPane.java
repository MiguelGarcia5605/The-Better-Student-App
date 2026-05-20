package com.betterstudentteam.thebetterstudentapp.frontend.todo;

import atlantafx.base.theme.Styles;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TodoPane extends VBox {

    private Label mHeader;

    public TodoPane() {
        mHeader = new Label("TODO");
        mHeader.getStyleClass().add(Styles.TITLE_1);
        this.getChildren().add(mHeader);
    }
}