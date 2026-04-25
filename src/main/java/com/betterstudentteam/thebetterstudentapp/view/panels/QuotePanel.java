package com.betterstudentteam.thebetterstudentapp.view.panels;

import com.betterstudentteam.thebetterstudentapp.util.Display;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class QuotePanel extends VBox {

    private static final String DAILY_QUOTE = "Be more than motivated, be more than driven, become literally obsessed to the point where people think you're fucking nuts.";

    private Label mDailyQuote;

    public QuotePanel() {
        // Daily quote panel
        mDailyQuote = new Label();
        mDailyQuote.setText(DAILY_QUOTE);
        mDailyQuote.setWrapText(true);
        mDailyQuote.setMaxWidth(Double.MAX_VALUE);
        mDailyQuote.getStyleClass().add("quote-label");
        this.getChildren().add(mDailyQuote);
        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() / 5);
        this.setMaxWidth(Display.SCREEN_BOUNDS.getWidth() * (2.0 / 3.0));
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() / 5);
        this.getStyleClass().add("quote-container");
    }
}
