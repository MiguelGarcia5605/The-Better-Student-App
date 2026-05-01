package com.betterstudentteam.thebetterstudentapp.backend.todo_list;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoList {

    private List<Todo> mTodos = new ArrayList<>();

    public Todo addTodo(String title, LocalDate dueDate) {
        Todo item = new Todo(UUID.randomUUID().toString(), title, dueDate);
        mTodos.add(item);
        return item;
    }

    // There is probably a faster way to search this
    public void remove(String ID) {
        for (int i = 0; i < mTodos.size(); i++) {
            if (mTodos.get(i).getID().equals(ID)) {
                mTodos.remove(i);
                break;
            }
        }
    }

    public List<Todo> getList() {
        return mTodos;
    }

    public void add(Todo item) {
        mTodos.add(item);
    }

}