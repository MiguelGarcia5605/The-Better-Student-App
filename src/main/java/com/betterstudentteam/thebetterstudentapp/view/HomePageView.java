package com.betterstudentteam.thebetterstudentapp.view;

import com.betterstudentteam.thebetterstudentapp.assignments.Assignment;
import com.betterstudentteam.thebetterstudentapp.courses.Course;
import com.betterstudentteam.thebetterstudentapp.courses.CourseManager;
import com.betterstudentteam.thebetterstudentapp.todo_list.TodoManager;
import com.betterstudentteam.thebetterstudentapp.util.Display;
import com.betterstudentteam.thebetterstudentapp.util.SaveManager;
import com.betterstudentteam.thebetterstudentapp.view.panels.CourseViewPanel;
import com.betterstudentteam.thebetterstudentapp.view.panels.QuotePanel;
import com.betterstudentteam.thebetterstudentapp.view.panels.TaskPanel;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class HomePageView extends BorderPane {

    private VBox mDailyQuoteAndCourseViewsContainer;
    private QuotePanel mQuotePanel;
    private CourseViewPanel mCourseViewPanel;
    private TaskPanel mTaskPanel;

    public HomePageView(BorderPane wrapper, CourseManager courseManager, TodoManager todoManager, SaveManager saveManager) {
        mQuotePanel = new QuotePanel();
        mCourseViewPanel = new CourseViewPanel(wrapper, courseManager, saveManager);

        for (Course course : courseManager.getAllCourses()) {
            String nextAssignment = "No upcoming assignments";
            List<Assignment> assignments = courseManager.getAssignmentForCourse(course.getId());
            if (!assignments.isEmpty()) {
                nextAssignment = "Next: " + assignments.getFirst().getTitle()
                        + " - " + assignments.getFirst().getDueDate();
            }
            mCourseViewPanel.addCourseCard(
                    course,
                    nextAssignment,
                    "Grade: " + course.getCurrentGrade() + "%"
            );
        }

        mDailyQuoteAndCourseViewsContainer = new VBox();
        mDailyQuoteAndCourseViewsContainer.getChildren().add(mQuotePanel);
        mDailyQuoteAndCourseViewsContainer.getChildren().add(mCourseViewPanel);
        mDailyQuoteAndCourseViewsContainer.getStyleClass().add("left-container");

        mDailyQuoteAndCourseViewsContainer.setMaxWidth(Double.MAX_VALUE);
        mDailyQuoteAndCourseViewsContainer.setPrefWidth(Display.SCREEN_BOUNDS.getWidth() * (2.0 / 3.0));

        mQuotePanel.setMaxWidth(Double.MAX_VALUE);
        mCourseViewPanel.setMaxWidth(Double.MAX_VALUE);

        mTaskPanel = new TaskPanel("Daily To-Do", todoManager, saveManager);

        this.setLeft(mDailyQuoteAndCourseViewsContainer);
        this.setRight(mTaskPanel);
        this.getStyleClass().add("home-page-pane");

        BorderPane.setMargin(mTaskPanel, new Insets(0, 40, 0, 10));
    }
}