package com.betterstudentteam.thebetterstudentapp.courses;

public class CourseDetailsManager {

    private CourseManager courseManager;

    public CourseDetailsManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public CourseDetailsData loadCourseDetails(String courseId) {

        Course course = courseManager.getCourseById(courseId);

        return new CourseDetailsData(course, courseManager.getAssignmentForCourse(courseId), courseManager.hasClassToday(course));

    }
}
