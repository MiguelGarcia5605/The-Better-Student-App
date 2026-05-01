package com.betterstudentteam.thebetterstudentapp.backend.util;

import com.betterstudentteam.thebetterstudentapp.backend.assignment.Assignment;
import com.betterstudentteam.thebetterstudentapp.backend.assignment.AssignmentList;
import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.todo_list.Todo;
import com.betterstudentteam.thebetterstudentapp.backend.todo_list.TodoList;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {

    private static final String SAVE_FILE = System.getProperty("user.home") + "/betterstudent_data.txt";

    private CourseManager mCourseManager;
    private AssignmentList mAssignmentList;
    private TodoList mTodoList;

    private TodoList mDailyTodos;
    private TodoList mBacklogTodos;
    private TodoList mAllTodos;

    public SaveManager(CourseManager courseManager, AssignmentList assignmentList, TodoList dailyTodos, TodoList backlogTodos, TodoList allTodos) {
        mCourseManager = courseManager;
        mAssignmentList = assignmentList;
        mDailyTodos = dailyTodos;
        mBacklogTodos = backlogTodos;
        mAllTodos = allTodos;
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {

            // Save courses
            for (Course course : mCourseManager.getAllCourses()) {
                StringBuilder days = new StringBuilder();
                for (DayOfWeek day : course.getMeetingDays()) {
                    if (days.length() > 0) days.append(",");
                    days.append(day.name());
                }
                writer.write("COURSE|" +
                        course.getId() + "|" +
                        course.getName() + "|" +
                        course.getInstructor() + "|" +
                        days + "|" +
                        course.getStartTime() + "|" +
                        course.getEndTime());
                writer.newLine();
            }

            // Save assignments
            for (Assignment assignment : mAssignmentList.getList()) {
                writer.write("ASSIGNMENT|" +
                        assignment.getmID() + "|" +
                        assignment.getCourseId() + "|" +
                        assignment.getTitle() + "|" +
                        assignment.getDueDate() + "|" +
                        assignment.getType() + "|" +
                        assignment.getDescription() + "|" +
                        assignment.isCompleted());
                writer.newLine();
            }

            // Daily tasks
            for (Todo todo : mDailyTodos.getList()) {
                writer.write("TASK_DAILY|" + todo.getId() + "|" + todo.getTitle() + "|" + todo.getDueDate() + "|" + todo.isCompleted());
                writer.newLine();
            }

            // Backlog tasks
            for (Todo todo : mBacklogTodos.getList()) {
                writer.write("TASK_BACKLOG|" + todo.getId() + "|" + todo.getTitle() + "|" + todo.getDueDate() + "|" + todo.isCompleted());
                writer.newLine();
            }

            // All tasks
            for (Todo todo : mAllTodos.getList()) {
                writer.write("TASK_ALL|" + todo.getId() + "|" + todo.getTitle() + "|" + todo.getDueDate() + "|" + todo.isCompleted());
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Failed to save data: " + e.getMessage());
        }
    }

    public void load() {
        File file = new File(SAVE_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts[0].equals("COURSE")) {
                    String id = parts[1];
                    String name = parts[2];
                    String instructor = parts[3];

                    List<DayOfWeek> days = new ArrayList<>();
                    for (String day : parts[4].split(",")) {
                        days.add(DayOfWeek.valueOf(day));
                    }

                    LocalTime startTime = LocalTime.parse(parts[5]);
                    LocalTime endTime = LocalTime.parse(parts[6]);

                    mCourseManager.addCourse(new Course(id, name, instructor, days, startTime, endTime));

                } else if (parts[0].equals("ASSIGNMENT")) {
                    String id = parts[1];
                    String courseId = parts[2];
                    String title = parts[3];
                    LocalDate dueDate = LocalDate.parse(parts[4]);
                    String type = parts[5];
                    String description = parts[6];
                    boolean completed = Boolean.parseBoolean(parts[7]);

                    Assignment assignment = new Assignment(id, title, courseId, dueDate, type, description);
                    assignment.setCompleted(completed);
                    mAssignmentList.add(assignment);

                } else if (parts[0].equals("TASK_DAILY")) {
                    Todo todo = new Todo(parts[1], parts[2], LocalDate.parse(parts[3]));
                    todo.setCompleted(Boolean.parseBoolean(parts[4]));
                    mDailyTodos.add(todo);

                } else if (parts[0].equals("TASK_BACKLOG")) {
                    Todo todo = new Todo(parts[1], parts[2], LocalDate.parse(parts[3]));
                    todo.setCompleted(Boolean.parseBoolean(parts[4]));
                    mBacklogTodos.add(todo);

                } else if (parts[0].equals("TASK_ALL")) {
                    Todo todo = new Todo(parts[1], parts[2], LocalDate.parse(parts[3]));
                    todo.setCompleted(Boolean.parseBoolean(parts[4]));
                    mAllTodos.add(todo);
                }
            }

        } catch (IOException e) {
            System.err.println("Failed to load data: " + e.getMessage());
        }
    }
}