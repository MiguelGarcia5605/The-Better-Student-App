package com.betterstudentteam.thebetterstudentapp.frontend;

import java.time.LocalDateTime;

public class Assignment {

    private String mName;
    private String mDescription;
    private LocalDateTime mDueDate;

    Assignment(String name) {
        setName(name);
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public LocalDateTime getDueDate() {
        return mDueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        mDueDate = dueDate;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}