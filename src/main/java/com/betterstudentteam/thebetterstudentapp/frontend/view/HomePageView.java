package com.betterstudentteam.thebetterstudentapp.frontend.view;

import com.betterstudentteam.thebetterstudentapp.backend.assignment.Assignment;
import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.todo_list.TodoManager;
import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import com.betterstudentteam.thebetterstudentapp.backend.util.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.CourseViewPanel;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.QuotePanel;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.TaskPanel;
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
                    "Grade: " + course.getmGrade() + "%"
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