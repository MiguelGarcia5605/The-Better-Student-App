// USE CODE IN VIEWCONTROLLER  courseManager.getAllCourses();
//  courseDetailsManager.loadCourseDetails(courseId);
//

package com.betterstudentteam.thebetterstudentapp.courses;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;


public class Course {

    private String id;
    private String name;
    private String instructor;
    private List<DayOfWeek> meetingDays;
    private LocalTime startTime;
    private LocalTime endTime;

    private double currentGrade;  // this is calculated from Assignments

    public Course(String id, String name, String instructor, List<DayOfWeek> meetingDays, LocalTime startTime, LocalTime endTime) {

        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.meetingDays = meetingDays;
        this.startTime = startTime;
        this.endTime = endTime;

        this.currentGrade = 0.0; // placeholder until Grade Calculator is merged

    }

//    Getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getInstructor() {
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
    public double getCurrentGrade() {
        return currentGrade;
    }

//    Setters
    public void setCurrentGrade(double currentGrade) {
        this.currentGrade = currentGrade;
    }

    
}
