package com.betterstudentteam.thebetterstudentapp.frontend;

public class Course {

    private String mName;

    Course(String name) {
        setName(name);
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
