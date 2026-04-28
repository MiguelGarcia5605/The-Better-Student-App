package com.betterstudentteam.thebetterstudentapp.ToDoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoManager {

    private List<TodoItem> todos = new ArrayList<>();

    public TodoItem addTodo(String title, LocalDate dueDate) {

        TodoItem item = new TodoItem(UUID.randomUUID().toString(), title, dueDate);
        todos.add(item);
        return item;
    }

    public boolean deleteTodo(String id) {
        return todos.removeIf(t -> t.getId().equals(id));
    }

    public List<TodoItem> getAllTodos() {
        return new ArrayList<>(todos);
    }

    public List<TodoItem> getCompletedTodos() {
        return todos.stream()
                .filter(TodoItem::isCompleted)
                .toList();
    }

    public List<TodoItem> getIncompleteTodos() {
        return todos.stream()
                .filter(t -> !t.isCompleted())
                .toList();
    }

    public List<TodoItem> getOverdueTodos() {
        LocalDate today = LocalDate.now();
        return todos.stream()
                .filter(t -> !t.isCompleted() && !t.getDueDate().isBefore(today))
                .toList();
    }

    public List<TodoItem> getUpcomingTodos() {
        LocalDate today = LocalDate.now();
        return todos.stream()
                .filter(t -> !t.isCompleted() && !t.getDueDate().isBefore(today))
                .toList();
    }

}
