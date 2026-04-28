package com.betterstudentteam.thebetterstudentapp.Courses;

import com.betterstudentteam.thebetterstudentapp.Assignments.Assignment;
import java.util.List;

public class CourseDetailsData {

    private Course course;
    private List<Assignment> assignments;
    private boolean hasClassToday;

    public CourseDetailsData(Course course, List<Assignment> assignments, boolean hasClassToday) {

        this.course = course;
        this.assignments = assignments;
        this.hasClassToday = hasClassToday;
    }

    public Course getCourse() {
        return course;
    }
    public List<Assignments> getAssignments() {
        return assignments;
    }
    public boolean isHasClassToday() {
        return hasClassToday;
    }

}
