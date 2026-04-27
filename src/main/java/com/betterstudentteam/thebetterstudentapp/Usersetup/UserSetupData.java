package com.betterstudentteam.thebetterstudentapp.Usersetup;

import java.util.Map;

public class UserSetupData {

    private int numberOfCourses;
    private Map<String, Double> gradeWeights;
//    Ex: ( tests: 0.5, Quizzes: 0.3, Homework:, 0.2)

    private double attendanceWeight;
//    Ex: 0.1 meaning attendance is 10% of grade

    public UserSetupData(int numberOfCourses, Map<String, Double> gradeWeights, double attendanceWeight) {
        this.numberOfCourses = numberOfCourses;
        this.gradeWeights = gradeWeights;
        this.attendanceWeight = attendanceWeight;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }
    public Map<String, Double> getGradeWeights() {
        return gradeWeights;
    }
    public double getAttendanceWeight() {return attendanceWeight;}
}
