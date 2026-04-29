package com.betterstudentteam.thebetterstudentapp.view;

import com.betterstudentteam.thebetterstudentapp.user_setup.CourseSetupRequest;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CourseFormRow extends HBox {

    private TextField mCourseName;
    private TextField mInstructor;
    private ListView<DayOfWeek> mMeetingDays;
    private ComboBox<String> mStartTime;
    private ComboBox<String> mEndTime;

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("H:mm");

    public CourseFormRow() {
        mCourseName = new TextField();
        mCourseName.setPromptText("Course Name");
        mCourseName.getStyleClass().add("setup-field");

        mInstructor = new TextField();
        mInstructor.setPromptText("Instructor");
        mInstructor.getStyleClass().add("setup-field");

        mMeetingDays = new ListView<>(FXCollections.observableArrayList(DayOfWeek.values()));
        mMeetingDays.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        mMeetingDays.setPrefHeight(180);
        mMeetingDays.setPrefWidth(150);
        mMeetingDays.getStyleClass().add("setup-list");

        mStartTime = new ComboBox<>(FXCollections.observableArrayList(generateTimeOptions()));
        mStartTime.setPromptText("Start Time");
        mStartTime.getStyleClass().add("setup-dropdown");

        mEndTime = new ComboBox<>(FXCollections.observableArrayList(generateTimeOptions()));
        mEndTime.setPromptText("End Time");
        mEndTime.getStyleClass().add("setup-dropdown");

        this.getChildren().addAll(mCourseName, mInstructor, mMeetingDays, mStartTime, mEndTime);
        this.setSpacing(10);
        this.getStyleClass().add("setup-form-row");
    }

    private List<String> generateTimeOptions() {
        List<String> times = new ArrayList<>();
        for (int hour = 7; hour <= 22; hour++) {
            times.add(hour + ":00");
            times.add(hour + ":30");
        }
        return times;
    }

    public CourseSetupRequest getRequest() {
        if (mCourseName.getText().isEmpty() ||
                mInstructor.getText().isEmpty() ||
                mMeetingDays.getSelectionModel().getSelectedItems().isEmpty() ||
                mStartTime.getValue() == null ||
                mEndTime.getValue() == null) {
            return null;
        }

        List<DayOfWeek> selectedDays = new ArrayList<>(
                mMeetingDays.getSelectionModel().getSelectedItems()
        );

        LocalTime startTime = LocalTime.parse(mStartTime.getValue(), TIME_FORMATTER);
        LocalTime endTime = LocalTime.parse(mEndTime.getValue(), TIME_FORMATTER);

        return new CourseSetupRequest(
                mCourseName.getText(),
                mInstructor.getText(),
                selectedDays,
                startTime,
                endTime
        );
    }
}