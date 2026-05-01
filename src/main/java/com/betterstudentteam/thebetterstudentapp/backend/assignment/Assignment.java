package com.betterstudentteam.thebetterstudentapp.backend.assignment;

import java.time.LocalDate;

/**
 * Represents a course assignment
 */
public class Assignment {

    private String mID; // the assignment identifier
    private String mType;
    private String mName;
    private LocalDate mDueDate;

    public Assignment(String ID, String type, String name, LocalDate dueDate) {
        mID = ID;
        mType = type;
        mName = name;
        mDueDate = dueDate;
    }

    public String getID() {
        return mID;
    }

    public String getType() {
        return mType;
    }

    public String getName() {
        return mName;
    }

    public LocalDate getDueDate() {
        return mDueDate;
    }


    public void setID(String ID) {
        mID = ID;
    }

    public void setType(String type){
        mType = type;
    }

    public void setName(String title) {
        mName = title;
    }

    public void setDueDate(LocalDate dueDate) {
        mDueDate = dueDate;
    }
}