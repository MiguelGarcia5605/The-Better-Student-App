
// PLACE THIS CODE IN VIEWCONTROLLER: userSetupManager.initializeUserCourses(setupData, courseRequests);
package com.betterstudentteam.thebetterstudentapp.backend.user_setup;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;


public class CourseSetupRequest {

private  String name;
private String instructor;
private List<DayOfWeek> meetingDays;
private LocalTime startTime;
private LocalTime endTime;

public CourseSetupRequest(String name, String instructor, List<DayOfWeek> meetingDays, LocalTime startTime, LocalTime endTime) {
    this.name = name;
    this.instructor = instructor;
    this.meetingDays = meetingDays;
    this.startTime = startTime;
    this.endTime = endTime;
}

public String getName() {
    return name;
}
public  String getInstructor() {
    return instructor;
}
public List<DayOfWeek> getMeetingDays() {
    return meetingDays;
}
public LocalTime getStartTime() {
    return startTime;
}
public LocalTime getEndTime() {
    return endTime;
}

}

