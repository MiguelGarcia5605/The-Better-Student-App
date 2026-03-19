package com.betterstudentteam.thebetterstudentapp.backend.todo;

import java.time.LocalDate;

public class Todo {
    private String mID;
    private String mTitle;
    private LocalDate mDueDate;

    public Todo(String ID, String title, LocalDate dueDate) {
        mID = ID;
        mTitle = title;
        mDueDate = dueDate;
    }

    public String getID() {
        return mID;
    }
    public String getTitle() {
        return mTitle;
    }
    public LocalDate getDueDate() {
        return mDueDate;
    }

    public void setID(String ID) {mID = ID;}
    public void setTitle(String title) {
        mTitle = title;
    }
    public void setDueDate(LocalDate dueDate) {
        mDueDate = dueDate;
    }

}