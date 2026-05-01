package com.betterstudentteam.thebetterstudentapp.backend.quote;

public class Quote {
    private String mText;
    private String mAuthor;

    public Quote(String text, String author) {
        mText = text;
        mAuthor = author;
    }

    public String getText() { return  mText;}
    public String getAuthor() { return mAuthor; }

    public void setText( String text) { mText = text;}
    public void setAuthors(String author) { mAuthor = author; }
}