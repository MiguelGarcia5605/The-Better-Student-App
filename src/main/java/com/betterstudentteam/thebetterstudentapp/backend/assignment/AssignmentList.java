package com.betterstudentteam.thebetterstudentapp.backend.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a list of assignments
 */
public class AssignmentList {

    private final List<Assignment> mAssignments = new ArrayList<>();

    public void add(Assignment assignment) {
        mAssignments.add(assignment);
    }

    public List<Assignment> getList() {
        return new ArrayList<>(mAssignments);
    }

    // There is probably a faster way to search this
    public void remove(String ID) {
        for (int i = 0; i < mAssignments.size(); i++) {
            if (mAssignments.get(i).getID().equals(ID)) {
                mAssignments.remove(i);
                break;
            }
        }
    }

    // Generate unique ID's for each assignment so n one override each other
    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}