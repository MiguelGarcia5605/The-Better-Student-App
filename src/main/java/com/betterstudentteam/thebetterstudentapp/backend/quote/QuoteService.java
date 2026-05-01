package com.betterstudentteam.thebetterstudentapp.backend.daily_quote;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuoteService {

    private static List<Quote> mQuotes = new ArrayList<>();

    // Could be more efficient way to store quotes
    public QuoteService() {
        mQuotes.add(new Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"));
        mQuotes.add(new Quote("Success is not final, failure is not fatal.", "Winston Churchill"));
        mQuotes.add(new Quote("The future depends on what you do today.", "Mahatma Gandhi"));
        mQuotes.add(new Quote("I can do all things through Christ who strengthens me.", "Phillipians 4:13"));
        mQuotes.add(new Quote("In the middle of difficulty lies opportunity.", "Albert Einstein"));
        mQuotes.add(new Quote(" Do what is right, not what is easy nor what is popular.", " Anonymous"));
        mQuotes.add(new Quote("If you are not willing to risk the usual, you will have to settle for the ordinary.", " Jim Rohn"));
    }

    public List<Quote> getQuotes() {
        return mQuotes;
    }

    public Quote getQuoteOfTheDay() {
        int index = LocalDate.now().getDayOfYear() % mQuotes.size();
        return mQuotes.get(index);
    }
}