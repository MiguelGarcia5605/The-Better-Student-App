package com.betterstudentteam.thebetterstudentapp.courses;

import com.betterstudentteam.thebetterstudentapp.assignments.Assignment;
import com.betterstudentteam.thebetterstudentapp.assignments.AssignmentManager;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private List<Course> courses = new ArrayList<>();
    private AssignmentManager assignmentManager;

    public CourseManager(AssignmentManager assignmentManager) {
        this.assignmentManager = assignmentManager;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    public Course getCourseById(String id) {
        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

//    Assingments for a specific course
    public List<Assignment> getAssignmentForCourse(String courseId) {
        return assignmentManager.getAssignmentsByCourse(courseId);
    }

//    Does this Course meet today?
    public boolean hasClassToday(Course course) {
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        return course.getMeetingDays().contains(today);
    }

    public void clearCourses() {
        courses.clear();
    }

    public void addAssignment(Assignment assignment) {
        assignmentManager.addAssignment(assignment);
    }

    public void deleteAssignment(String id) {
        assignmentManager.deleteAssignment(id);
    }

}
