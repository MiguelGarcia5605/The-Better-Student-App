package com.betterstudentteam.thebetterstudentapp.frontend.home;

import atlantafx.base.theme.Styles;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HomePane extends VBox {

    private Label mHeader;

    public HomePane() {
        mHeader = new Label("HOME");
        mHeader.getStyleClass().add(Styles.TITLE_1);
        this.getChildren().add(mHeader);
    }
}
