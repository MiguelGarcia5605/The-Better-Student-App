package com.betterstudentteam.thebetterstudentapp.frontend;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;

public class ViewToolBar extends ToolBar {

    public ViewToolBar() {
        super(new Button("Home"), new Separator(Orientation.VERTICAL), new Button("Todo"), new Separator(Orientation.VERTICAL), new Button("Setup"));
    }
}
