package com.betterstudentteam.thebetterstudentapp.backend.assignments;

import java.time.LocalDate;

public class Assignment {

    private String id;
    private String title;
    private String courseId;
    private LocalDate dueDate;
    private String type;   //This is for the homework, quizzes, and Tests
    private boolean completed;
    private String description;
    private Double gradeReceived; // will be null most times until actually graded

    public Assignment(String id, String title, String courseId, LocalDate dueDate, String type, String description) {
        this.id = id;
        this.title = title;
        this.courseId = courseId;
        this.dueDate = dueDate;
        this.type = type;
        this.description = description;
        this.completed = false;
        this.gradeReceived = null;
    }

//Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCourseId() {
        return courseId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getType() {
        return type;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getDescription() {
        return description;
    }



//    Setters

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type){
        this.type = type;
    }
}
