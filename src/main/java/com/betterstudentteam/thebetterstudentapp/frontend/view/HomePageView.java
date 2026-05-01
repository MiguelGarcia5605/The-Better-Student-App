package com.betterstudentteam.thebetterstudentapp.frontend.view;

import com.betterstudentteam.thebetterstudentapp.backend.assignment.Assignment;
import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.quote.QuoteService;
import com.betterstudentteam.thebetterstudentapp.backend.util.Display;
import com.betterstudentteam.thebetterstudentapp.backend.save.SaveManager;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.CourseViewPanel;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.DisplayPanel;
import com.betterstudentteam.thebetterstudentapp.frontend.panels.TaskPanel;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class HomePageView extends BorderPane {

    private VBox mDailyQuoteAndCourseViewsContainer;
    private DisplayPanel mQuotePanel;
    private CourseViewPanel mCourseViewPanel;
    private TaskPanel mTaskPanel;

    public HomePageView(BorderPane wrapper, SaveManager saveManager) {
        mQuotePanel = new DisplayPanel(
                new QuoteService().getQuoteOfTheDay().getText(),
                Display.SCREEN_BOUNDS.getHeight() / 5,
                Display.SCREEN_BOUNDS.getHeight() / 5,
                Double.MAX_VALUE,
                "quote-label",
                "display-panel"
        );

        mCourseViewPanel = new CourseViewPanel(wrapper, saveManager);

        for (Course course : saveManager.getCourseList()) {
            String nextAssignment = "No upcoming assignments";
            if (!course.getAssignmentList().getList().isEmpty()) {
                Assignment first = course.getAssignmentList().getList().getFirst();
                nextAssignment = "Next: " + first.getName() + " - " + first.getDueDate();
            }
            mCourseViewPanel.addCourseCard(
                    course,
                    nextAssignment,
                    "Grade: " + course.getGrade() + "%"
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

        mTaskPanel = new TaskPanel("Daily To-Do", saveManager.getDailyTodos(), saveManager);

        this.setLeft(mDailyQuoteAndCourseViewsContainer);
        this.setRight(mTaskPanel);
        this.getStyleClass().add("view-pane");

        BorderPane.setMargin(mTaskPanel, new Insets(0, 40, 0, 10));
    }
}