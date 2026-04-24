package com.betterstudentteam.thebetterstudentapp;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class QuotePanel extends VBox {

    private static final String DAILY_QUOTE = "Be more than motivated, be more than driven, become literally obsessed to the point where people think you're fucking nuts.";
    private static final Screen SCREEN = Screen.getPrimary();
    private static final Rectangle2D SCREEN_BOUNDS = SCREEN.getVisualBounds();

    private Label mDailyQuote;

    public QuotePanel() {
        // Daily quote panel
        mDailyQuote = new Label();
        mDailyQuote.setText(DAILY_QUOTE);
        mDailyQuote.setWrapText(true);
        mDailyQuote.setMaxWidth(Double.MAX_VALUE);
        mDailyQuote.getStyleClass().add("quote-label");
        this.getChildren().add(mDailyQuote);
        this.setPrefHeight(SCREEN_BOUNDS.getHeight() / 5);
        this.setMaxWidth(SCREEN_BOUNDS.getWidth() * (2.0 / 3.0));
        this.setMaxHeight(SCREEN_BOUNDS.getHeight() / 5);
        this.getStyleClass().add("quote-container");
    }
}
