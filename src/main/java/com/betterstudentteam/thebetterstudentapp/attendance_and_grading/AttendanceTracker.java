package com.betterstudentteam.thebetterstudentapp.attendance_and_grading;

class Course {
    String name;
    int attended;
    int total;

    public Course(String name, int attended, int total) {
        this.name = name;
        this.attended = attended;
        this.total = total;
    }

    public double getPercentage() {
        if (total == 0) return 0;
        return (attended * 100.0) / total;
    }

    public String getFraction() {
        return attended + "/" + total;
    }
}

