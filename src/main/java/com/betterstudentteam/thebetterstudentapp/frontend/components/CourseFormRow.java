package com.betterstudentteam.thebetterstudentapp.frontend.components;

import com.betterstudentteam.thebetterstudentapp.backend.course.Course;
import com.betterstudentteam.thebetterstudentapp.backend.util.ID;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CourseFormRow extends HBox {

    private TextField mCourseName;
    private TextField mInstructor;
    private ListView<DayOfWeek> mMeetingDays;
    private Button mDaysButton;
    private Popup mDaysPopup;
    private TextField mStartTime;
    private TextField mEndTime;
    private TextField mGrade;
    private Button mDeleteButton;

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");
    private static final DayOfWeek[] MEETING_TIME_SELECTION = {
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY
    };

    public CourseFormRow(VBox parentList) {
        mCourseName = new TextField();
        mCourseName.setPromptText("Course Name");
        mCourseName.getStyleClass().add("setup-field");

        mInstructor = new TextField();
        mInstructor.setPromptText("Instructor");
        mInstructor.getStyleClass().add("setup-field");

        mDaysButton = new Button("Day(s)");
        mDaysButton.getStyleClass().add("setup-field");

        mMeetingDays = new ListView<>(FXCollections.observableArrayList(MEETING_TIME_SELECTION));
        mMeetingDays.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        mMeetingDays.setPrefHeight(180);
        mMeetingDays.setPrefWidth(150);
        mMeetingDays.getStyleClass().add("setup-list");

        mMeetingDays.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            List<DayOfWeek> selected = mMeetingDays.getSelectionModel().getSelectedItems();
            if (selected.isEmpty()) {
                mDaysButton.setText("Day(s)");
            } else {
                StringBuilder sb = new StringBuilder();
                for (DayOfWeek day : selected) {
                    if (sb.length() > 0) sb.append(", ");
                    sb.append(day.name().substring(0, 3));
                }
                mDaysButton.setText(sb.toString());
            }
        });

        mDaysPopup = new Popup();
        mDaysPopup.setAutoHide(true);
        VBox popupContent = new VBox(mMeetingDays);
        popupContent.getStyleClass().add("setup-form-row");
        mDaysPopup.getContent().add(popupContent);

        mDaysButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if (mDaysPopup.isShowing()) {
                    mDaysPopup.hide();
                } else {
                    mDaysPopup.show(mDaysButton,
                            mDaysButton.localToScreen(0, 0).getX(),
                            mDaysButton.localToScreen(0, 0).getY() + mDaysButton.getHeight()
                    );
                }
            }
        });

        mStartTime = new TextField();
        mStartTime.setPromptText("Start time");
        mStartTime.getStyleClass().add("setup-field");

        mEndTime = new TextField();
        mEndTime.setPromptText("End time");
        mEndTime.getStyleClass().add("setup-field");

        mGrade = new TextField();
        mGrade.setPromptText("Grade");
        mGrade.getStyleClass().add("setup-field");

        mDeleteButton = new Button("✕");
        mDeleteButton.getStyleClass().add("delete-button");
        mDeleteButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                parentList.getChildren().remove(CourseFormRow.this);
            }
        });

        this.getChildren().addAll(mCourseName, mInstructor, mDaysButton, mStartTime, mEndTime, mGrade, mDeleteButton);
        this.setSpacing(10);
        this.getStyleClass().add("setup-form-row");
    }

    public void loadCourse(Course course) {
        mCourseName.setText(course.getName());
        mInstructor.setText(course.getInstructor());
        mStartTime.setText(course.getStartTime().format(TIME_FORMATTER));
        mEndTime.setText(course.getEndTime().format(TIME_FORMATTER));
        mGrade.setText(Double.toString(course.getGrade()));
        for (DayOfWeek day : course.getMeetingDays()) {
            mMeetingDays.getSelectionModel().select(day.ordinal());
        }
    }

    public Course getCourse() {
        if (mCourseName.getText().isEmpty() ||
                mInstructor.getText().isEmpty() ||
                mMeetingDays.getSelectionModel().getSelectedItems().isEmpty() ||
                mStartTime.getText().isEmpty() ||
                mEndTime.getText().isEmpty() ||
                mGrade.getText().isEmpty()) {
            return null;
        }

        LocalTime startTime;
        LocalTime endTime;
        try {
            startTime = LocalTime.parse(mStartTime.getText(), TIME_FORMATTER);
            endTime = LocalTime.parse(mEndTime.getText(), TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            return null;
        }

        return new Course(
                ID.generateID(),
                mCourseName.getText(),
                mInstructor.getText(),
                new ArrayList<>(mMeetingDays.getSelectionModel().getSelectedItems()),
                startTime,
                endTime,
                Double.parseDouble(mGrade.getText())
        );
    }
}