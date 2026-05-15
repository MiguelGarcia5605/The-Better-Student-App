package com.betterstudentteam.thebetterstudentapp.backend;

import java.util.ArrayList;

public class Course {

    private String mName;
    private ArrayList<Assignment> mAssignmentList = new ArrayList<Assignment>();

    Course(String name) {
        setName(name);
    }

    public void addAssignment(Assignment assignment) {
        mAssignmentList.add(assignment);
    }

    public void removeAssignment(Assignment assignment) {
        mAssignmentList.remove(assignment);
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
