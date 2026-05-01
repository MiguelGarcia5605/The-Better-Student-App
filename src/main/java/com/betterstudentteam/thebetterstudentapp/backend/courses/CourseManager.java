package com.betterstudentteam.thebetterstudentapp.backend.courses;

import com.betterstudentteam.thebetterstudentapp.backend.assignment.Assignment;
import com.betterstudentteam.thebetterstudentapp.backend.assignment.AssignmentList;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private List<Course> courses = new ArrayList<>();
    private AssignmentList assignmentList;

    public CourseManager(AssignmentList assignmentList) {
        this.assignmentList = assignmentList;
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
        return assignmentList.getAssignmentsByCourse(courseId);
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
        assignmentList.add(assignment);
    }

    public void deleteAssignment(String id) {
        assignmentList.deleteAssignment(id);
    }

}
