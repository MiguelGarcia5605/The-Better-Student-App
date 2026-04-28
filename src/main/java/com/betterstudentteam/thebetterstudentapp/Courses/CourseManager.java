package com.betterstudentteam.thebetterstudentapp.Courses;

import com.betterstudentteam.thebetterstudentapp.Assignments.Assignment;
import com.betterstudentteam.thebetterstudentapp.Assignments.AssignmentManager;

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

//    ASssingments for a specific course
    public List<Assignment> getAssignmentForCourse(String courseId) {
        return assignmentManager.getAssignmentByCourse(courseId);
    }

//    Does this Course meet today?
    public boolean hasClassToday(Course course) {
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        return course.getMeetingDays().contains(today);
    }

}
