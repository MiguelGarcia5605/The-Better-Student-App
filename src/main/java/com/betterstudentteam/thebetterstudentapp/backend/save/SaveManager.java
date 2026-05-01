package com.betterstudentteam.thebetterstudentapp.backend.save;

import com.betterstudentteam.thebetterstudentapp.backend.assignment.Assignment;
import com.betterstudentteam.thebetterstudentapp.backend.assignment.AssignmentList;
import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.todo.Todo;
import com.betterstudentteam.thebetterstudentapp.backend.todo.TodoList;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SaveManager {

    private static final String SAVE_FILE = System.getProperty("user.home") + "/betterstudent_data.txt";

    private ArrayList<Course> mCourseList;

    private TodoList mDailyTodos;
    private TodoList mBacklogTodos;
    private TodoList mAllTodos;

    public SaveManager(ArrayList<Course> courseList, TodoList dailyTodos, TodoList backlogTodos, TodoList allTodos) {
        mCourseList = courseList;
        mDailyTodos = dailyTodos;
        mBacklogTodos = backlogTodos;
        mAllTodos = allTodos;
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {

            // Write courses and their relevant assignments to save file
            for (Course course : mCourseList) {
                StringBuilder days = new StringBuilder();
                for (DayOfWeek day : course.getMeetingDays()) {
                    if (!days.isEmpty()) days.append(",");
                    days.append(day.name());
                }

                writer.write("COURSE|" +
                        course.getID() + "|" +
                        course.getName() + "|" +
                        course.getInstructor() + "|" +
                        days + "|" +
                        course.getStartTime() + "|" +
                        course.getEndTime() + "|" +
                        course.getGrade());
                writer.newLine();

                for (Assignment assignment : course.getAssignmentList().getList()) {
                    writer.write("ASSIGNMENT|" +
                            assignment.getID() + "|" +
                            assignment.getName() + "|" +
                            assignment.getType() + "|" +
                            assignment.getDueDate());
                    writer.newLine();
                }
            }

            // Write daily tasks to save file
            for (Todo todo : mDailyTodos.getList()) {
                writer.write("TASK_DAILY" + "|" + todo.getID() + "|" + todo.getTitle() + "|" + todo.getDueDate());
                writer.newLine();
            }

            // Write backlog tasks to save file
            for (Todo todo : mBacklogTodos.getList()) {
                writer.write("TASK_BACKLOG" + "|" + todo.getID() + "|" + todo.getTitle() + "|" + todo.getDueDate());
                writer.newLine();
            }

            // Write all tasks to save file
            for (Todo todo : mAllTodos.getList()) {
                writer.write("TASK_ALL" + "|" + todo.getID() + "|" + todo.getTitle() + "|" + todo.getDueDate());
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
            Course currentCourse = null;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts[0].equals("COURSE")) {
                    List<DayOfWeek> days = new ArrayList<>();
                    for (String day : parts[4].split(",")) {
                        days.add(DayOfWeek.valueOf(day));
                    }

                    currentCourse = new Course(
                            parts[1],
                            parts[2],
                            parts[3],
                            days,
                            LocalTime.parse(parts[5]),
                            LocalTime.parse(parts[6]),
                            Double.parseDouble(parts[7])
                    );
                    mCourseList.add(currentCourse);

                } else if (parts[0].equals("ASSIGNMENT")) {
                    if (currentCourse != null) {
                        currentCourse.getAssignmentList().add(new Assignment(
                                parts[1],
                                parts[2],
                                parts[3],
                                LocalDate.parse(parts[4])
                        ));
                    }

                } else if (parts[0].equals("TASK_DAILY")) {
                    mDailyTodos.add(new Todo(
                            parts[1],
                            parts[2],
                            LocalDate.parse(parts[3])
                    ));

                } else if (parts[0].equals("TASK_BACKLOG")) {
                    mBacklogTodos.add(new Todo(
                            parts[1],
                            parts[2],
                            LocalDate.parse(parts[3])
                    ));

                } else if (parts[0].equals("TASK_ALL")) {
                    mAllTodos.add(new Todo(
                            parts[1],
                            parts[2],
                            LocalDate.parse(parts[3])
                    ));
                }
            }

        } catch (IOException e) {
            System.err.println("Failed to load data: " + e.getMessage());
        }
    }
}