package com.betterstudentteam.thebetterstudentapp.backend.assignments;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AssignmentManager {

    private final List<Assignment> assignments = new ArrayList<>();

//    Creating Assignment
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

//    Read the assignments
    public List<Assignment> getAllAssignments() {
        return new ArrayList<>(assignments);
    }

//    Read assignment by ID, had to look this up because im not sure what everything means
    public Assignment getAllAssignmentById(String id) {
        return assignments.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

//    UPDATE: mark assignment completed
    public boolean markCompleted(String id) {
        Assignment a = getAllAssignmentById(id);
        if (a != null) {
            a.setCompleted(true);
            return true;
        }
        return false;

    }

//    UPDATE: edit assignment
    public boolean updateAssignment(String id, Assignment updated) {
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getId().equals(id)) {
                assignments.set(i, updated);
                return true;
            }
        }
        return false;
    }

//    Update certain Assignment Fields , (Ex: change duedate, change desrciption)
    public boolean updateAssignmentFields(String id, String title, LocalDate dueDate, String description, String type) {
        Assignment a = getAllAssignmentById(id);
        if (a == null ) return false;

        if (title != null) a.setTitle(title);
        if (dueDate != null) a.setDueDate(dueDate);
        if (description != null) a.setDescription(description);
        if (type != null) a.setType(type);

        return true;
    }
//    DELETE Assignments
    public boolean deleteAssignment(String id) {
        return assignments.removeIf(a -> a.getId().equals(id));
    }

//    FILTER: by course
    public List<Assignment> getAssignmentsByCourse(String courseId) {
        return assignments.stream()
                .filter(a -> a.getCourseId().equals(courseId))
                .collect(Collectors.toList());
    }

//    Filter: overdue Assignments
    public List<Assignment> getOverdueAssignments() {
        LocalDate today = LocalDate.now();
        return assignments.stream()
                .filter(a -> !a.isCompleted() && a.getDueDate().isBefore(today))
                .collect(Collectors.toList());
    }

//    FILTER: upcoming Assignments
    public List<Assignment> getUpcomingAssignments() {
        LocalDate today = LocalDate.now();
        return assignments.stream()
                .filter(a -> a.getDueDate().isAfter(today))
                .collect(Collectors.toList());
    }

//    SORT: by due date
    public List<Assignment> getSortedByDueDate() {
        return assignments.stream()
                .sorted(Comparator.comparing(Assignment::getDueDate))
                .collect(Collectors.toList());
    }

//    MARK as Not Completed
    public boolean markIncomplete(String id) {
    Assignment a = getAllAssignmentById(id);
    if (a != null) {
        a.setCompleted(false);
        return true;
    }
    return false;}

//    Generate unique ID's for each assignment so n one override each other
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

//    Search for ID to find certain Assignements
    public List<Assignment> search(String keyword) {
        return assignments.stream().filter(a -> a.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}
