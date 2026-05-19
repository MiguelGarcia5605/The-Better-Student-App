package com.betterstudentteam.thebetterstudentapp.backend;

import java.util.ArrayList;

public class Course {

    private String mName;
    private ArrayList<Assignment> mAssignmentArrayList = new ArrayList<Assignment>();

    public Course(String name) {
        setName(name);
    }

    public void addAssignment(Assignment assignment) {
        mAssignmentArrayList.add(assignment);
    }

    public void removeAssignment(Assignment assignment) {
        mAssignmentArrayList.remove(assignment);
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public ArrayList<Assignment> getAssignmentArrayList() {
        return mAssignmentArrayList;
    }
}
