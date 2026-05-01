package com.betterstudentteam.thebetterstudentapp.backend.course;

import com.betterstudentteam.thebetterstudentapp.backend.assignment.AssignmentList;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;


public class Course {
    private AssignmentList mAssignments = new AssignmentList();

    private String mID;
    private String mName;
    private String mInstructor;
    private List<DayOfWeek> mMeetingDays;
    private LocalTime mStartTime;
    private LocalTime mEndTime;

    private double mGrade;

    public Course(String ID, String name, String instructor, List<DayOfWeek> meetingDays, LocalTime startTime, LocalTime endTime, double grade) {
        mID = ID;
        mName = name;
        mInstructor = instructor;
        mMeetingDays = meetingDays;
        mStartTime = startTime;
        mEndTime = endTime;
        mGrade = grade;
    }

    public String getID() {
        return mID;
    }
    public String getName() {
        return mName;
    }
    public String getInstructor() {
        return mInstructor;
    }
    public List<DayOfWeek> getMeetingDays() {
        return mMeetingDays;
    }
    public LocalTime getStartTime() {
        return mStartTime;
    }
    public LocalTime getEndTime() {
        return mEndTime;
    }
    public double getGrade() {
        return mGrade;
    }

    public void setID(String ID) {mID = ID;}
    public void setName(String name) {
        mName = name;
    }
    public void setInstructor(String instructor) {
        mInstructor = instructor;
    }
    public void setMeetingDays(List<DayOfWeek> meetingDays) {
        mMeetingDays = meetingDays;
    }
    public void setStartTime(LocalTime startTime) {
        mStartTime = startTime;
    }
    public void setEndTime(LocalTime endTime) {
        mEndTime = endTime;
    }
    public void setGrade(double grade) {
        mGrade = grade;
    }
}