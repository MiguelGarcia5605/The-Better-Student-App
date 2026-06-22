package com.betterstudentteam.thebetterstudentapp.frontend.components;

import atlantafx.base.theme.Styles;
import com.betterstudentteam.thebetterstudentapp.backend.Display;
import com.betterstudentteam.thebetterstudentapp.backend.QuoteManager;
import javafx.scene.control.Label;

public class GreetingCard extends Label {

    public GreetingCard() {
        this.setText(QuoteManager.getTimeRelativeGreeting() + ", " + "Miguel");
        this.getStyleClass().addAll(Styles.TITLE_1, Styles.TEXT_BOLDER, Styles.TEXT_ITALIC);
        this.getStyleClass().add("quote_label");
        this.setMaxWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setMaxHeight(Display.SCREEN_BOUNDS.getWidth() / 10.0);
        this.setPrefWidth((Display.SCREEN_BOUNDS.getWidth() / 3.0) * 2.0);
        this.setPrefHeight(Display.SCREEN_BOUNDS.getWidth() / 10.0);
        this.setWrapText(true);
    }
}