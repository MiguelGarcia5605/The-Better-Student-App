package com.betterstudentteam.thebetterstudentapp.frontend.panels;

import com.betterstudentteam.thebetterstudentapp.backend.quote.QuoteService;
import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class QuotePanel extends VBox {

    private Label mDailyQuote;
    private QuoteService mQuoteService;

    public QuotePanel() {
        // Daily quote panel
        mQuoteService = new QuoteService();
        mDailyQuote = new Label();
        mDailyQuote.setText(mQuoteService.getQuoteOfTheDay().getText());
        mDailyQuote.setWrapText(true);
        mDailyQuote.setMaxWidth(Double.MAX_VALUE);
        mDailyQuote.getStyleClass().add("quote-label");
        this.getChildren().add(mDailyQuote);
        this.setPrefHeight(Display.SCREEN_BOUNDS.getHeight() / 5);
        this.setMaxWidth(Display.SCREEN_BOUNDS.getWidth() * (2.0 / 3.0));
        //this.setMaxWidth(Double.MAX_VALUE);
        this.setMaxHeight(Display.SCREEN_BOUNDS.getHeight() / 5);
        this.getStyleClass().add("quote-panel");
    }
}
