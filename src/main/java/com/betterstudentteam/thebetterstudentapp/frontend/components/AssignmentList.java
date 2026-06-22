package com.betterstudentteam.thebetterstudentapp.frontend.components;

import atlantafx.base.theme.Styles;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AssignmentList extends VBox {

    private Label mHeader;
    private Separator mSeperator;

    public AssignmentList(String name) {
        mHeader = new Label(name);
        mHeader.getStyleClass().add(Styles.TITLE_1);
        this.getChildren().add(mHeader);

        mSeperator = new Separator(Orientation.HORIZONTAL);
        this.getChildren().add(mSeperator);

        this.setMinWidth(Display.SCREEN_BOUNDS.getWidth() / 3.0);
        this.setMaxWidth(Display.SCREEN_BOUNDS.getWidth() / 3.0);
        this.setMinHeight(Display.SCREEN_BOUNDS.getHeight());
    }
}