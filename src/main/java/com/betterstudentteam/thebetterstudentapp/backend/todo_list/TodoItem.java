package com.betterstudentteam.thebetterstudentapp.backend.todo_list;

import java.time.LocalDate;

public class TodoItem {

    private String id;
    private String title;
    private LocalDate dueDate;
    private boolean completed;

    public TodoItem(String id, String title, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
