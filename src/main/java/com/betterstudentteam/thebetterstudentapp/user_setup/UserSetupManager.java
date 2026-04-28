package com.betterstudentteam.thebetterstudentapp.user_setup;

import com.betterstudentteam.thebetterstudentapp.courses.Course;
import com.betterstudentteam.thebetterstudentapp.courses.CourseManager;
import com.betterstudentteam.thebetterstudentapp.user_setup.CourseSetupRequest;

import java.util.List;
import java.util.UUID;

public class UserSetupManager {

    private CourseManager courseManager;

    public UserSetupManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    public void initializeUserCourses(UserSetupData setupData, List<CourseSetupRequest> courseSetupRequests) {

        for (CourseSetupRequest req : courseSetupRequests) {

            Course course = new Course( UUID.randomUUID().toString(), req.getName(), req.getInstructor(), req.getMeetingDays(), req.getStartTime(), req.getEndTime() );

            courseManager.addCourse(course);
        }
    }
}
