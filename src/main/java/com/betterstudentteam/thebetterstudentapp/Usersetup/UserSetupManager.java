package com.betterstudentteam.thebetterstudentapp.Usersetup;

import com.betterstudentteam.thebetterstudentapp.Courses.Course;
import com.betterstudentteam.thebetterstudentapp.Courses.CourseManager;

import java.util.List;
import java.util.UUID;

public class UserSetupManager {

    private CourseManager courseManager;

    public UserSetupManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public void initializeUserCourses(UserSetupData setupData, List<CourseSetupRequest> courseSetupRequests) {

        for (courseSetupRequests req : courseRequests) {

            Course course = new Course( UUID.randomUUID().toString(), req.getName(), req.getInstructor(), req.getMeetingDays(), req.getStartTime(), req.getEndTime() );

            courseManager.addCourse(course);
        }
    }
}
