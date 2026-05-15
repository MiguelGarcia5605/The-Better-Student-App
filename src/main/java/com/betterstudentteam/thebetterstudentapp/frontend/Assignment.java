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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Assignment) {
            Assignment assignment = (Assignment) obj;
            boolean equivalentCondition = mName.equals(assignment.getName()) && mDescription.equals(assignment.getDescription()) && mDueDate.equals(assignment.getDueDate());

            return equivalentCondition;
        }
        return false;
    }
}