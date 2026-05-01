package com.betterstudentteam.thebetterstudentapp.backend.save;

import com.betterstudentteam.thebetterstudentapp.backend.assignment.Assignment;
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

    private static final String SAVE_FILE_PATH = System.getProperty("user.home") + "/save.txt";
    private static final String REGEX = "|";

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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE_PATH))) {
            // Use BufferedWriter to write to txt file

            // Write courses and their relevant assignments to save file
            for (Course course : mCourseList) {

                // Get course meeting days
                StringBuilder meetingDays = new StringBuilder();
                for (DayOfWeek day : course.getMeetingDays()) {
                    if (!meetingDays.isEmpty())  {
                        meetingDays.append(",");
                    }
                    meetingDays.append(day.name());
                }

                // Write course data to file
                writer.write("COURSE" + REGEX +
                        course.getID() + REGEX +
                        course.getName() + REGEX +
                        course.getInstructor() + REGEX +
                        meetingDays + REGEX +
                        course.getStartTime() + REGEX +
                        course.getEndTime() + REGEX +
                        course.getGrade());
                writer.newLine();

                // Write assignments data to file
                for (Assignment assignment : course.getAssignmentList().getList()) {
                    writer.write("ASSIGNMENT" + REGEX +
                            assignment.getID() + REGEX +
                            assignment.getName() + REGEX +
                            assignment.getDueDate());
                    writer.newLine();
                }
            }

            // Write daily tasks to save file
            for (Todo todo : mDailyTodos.getList()) {
                writer.write("TASK_DAILY" + REGEX +
                        todo.getID() + REGEX +
                        todo.getTitle() + REGEX +
                        todo.getDueDate());
                writer.newLine();
            }

            // Write backlog tasks to save file
            for (Todo todo : mBacklogTodos.getList()) {
                writer.write("TASK_BACKLOG" + REGEX +
                        todo.getID() + REGEX +
                        todo.getTitle() + REGEX +
                        todo.getDueDate());
                writer.newLine();
            }

            // Write all tasks to save file
            for (Todo todo : mAllTodos.getList()) {
                writer.write("TASK_ALL" + REGEX +
                        todo.getID() + REGEX +
                        todo.getTitle() + REGEX +
                        todo.getDueDate());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save data.");
        }
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE_PATH))) {
            // Use BufferedReader to read txt file
            Course currentCourse = null;

            while (true) {
                String currentLine = reader.readLine();

                // Stop when reached end of file
                if (currentLine == null) {
                    break;
                }

                /*    '//' escapes the '|' character here   */
                String[] currentLineParts = currentLine.split("\\" + REGEX);

                /* Read data based on the first part of each line */

                // COURSE|ID|NAME|INSTRUCTOR|MEETING_DAYS|START_TIME|END_TIME|GRADE
                if (currentLineParts[0].equals("COURSE")) {
                    List<DayOfWeek> meetingDays = new ArrayList<>();
                    for (String day : currentLineParts[4].split(",")) {
                        meetingDays.add(DayOfWeek.valueOf(day));
                    }

                    currentCourse = new Course(
                            currentLineParts[1],
                            currentLineParts[2],
                            currentLineParts[3],
                            meetingDays,
                            LocalTime.parse(currentLineParts[5]),
                            LocalTime.parse(currentLineParts[6]),
                            Double.parseDouble(currentLineParts[7])
                    );
                    mCourseList.add(currentCourse);

                // ASSIGNMENT|ID|NAME|DUE_DATE
                } else if (currentLineParts[0].equals("ASSIGNMENT")) {
                    // Could cause nullpointerexception... but shouldn't *hoping*
                    currentCourse.getAssignmentList().add(new Assignment(
                            currentLineParts[1],
                            currentLineParts[2],
                            LocalDate.parse(currentLineParts[3])
                    ));

                // TASK_DAILY|ID|NAME|DUE_DATE
                } else if (currentLineParts[0].equals("TASK_DAILY")) {
                    mDailyTodos.add(new Todo(
                            currentLineParts[1],
                            currentLineParts[2],
                            LocalDate.parse(currentLineParts[3])
                    ));

                // TASK_BACKLOG|ID|NAME|DUE_DATE
                } else if (currentLineParts[0].equals("TASK_BACKLOG")) {
                    mBacklogTodos.add(new Todo(
                            currentLineParts[1],
                            currentLineParts[2],
                            LocalDate.parse(currentLineParts[3])
                    ));

                // TASK_ALL|ID|NAME|DUE_DATE
                } else if (currentLineParts[0].equals("TASK_ALL")) {
                    mAllTodos.add(new Todo(
                            currentLineParts[1],
                            currentLineParts[2],
                            LocalDate.parse(currentLineParts[3])
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load data: " + e.getMessage());
        }
    }

    public ArrayList<Course> getCourseList() {
        return mCourseList;
    }

    public TodoList getDailyTodos() {
        return mDailyTodos;
    }

    public TodoList getBacklogTodos() {
        return mBacklogTodos;
    }

    public TodoList getAllTodos() {
        return mAllTodos;
    }
}