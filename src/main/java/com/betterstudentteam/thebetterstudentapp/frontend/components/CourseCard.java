package com.betterstudentteam.thebetterstudentapp.frontend.components;

import atlantafx.base.controls.Card;
import atlantafx.base.theme.Styles;
import atlantafx.base.theme.Tweaks;
import com.betterstudentteam.thebetterstudentapp.backend.Course;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.awt.*;

public class CourseCard extends Card {
    private BorderPane mCapsule;
    private TextField mClassTextField;
    private TextField mProfessorTextField;
    private MenuButton mMenuButton;

    public CourseCard() {
        mCapsule = new BorderPane();
        mClassTextField = new TextField();
        mProfessorTextField = new TextField();
        mMenuButton = new MenuButton();

        mClassTextField.getStyleClass().add("course_card_text_field");
        mClassTextField.setPromptText("Class...");
        mClassTextField.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 30));
        mClassTextField.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));

        mProfessorTextField.getStyleClass().add("course_card_text_field");
        mProfessorTextField.setPromptText("Professor...");
        mProfessorTextField.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 15));

        mCapsule.setCenter(mClassTextField);
        mCapsule.setRight(mMenuButton);

        mMenuButton.setText("MWF");
        mMenuButton.getItems().addAll(new MenuItem("MWF"), new MenuItem("TuTH"), new MenuItem("MW"));
        mMenuButton.setPopupSide(Side.LEFT);
        mMenuButton.setPadding(new Insets(0));
        mMenuButton.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        mMenuButton.getStyleClass().addAll(Tweaks.NO_ARROW, Styles.ACCENT);

        this.getStyleClass().add(Styles.INTERACTIVE);

        this.setHeader(mCapsule);
        this.setSubHeader(mProfessorTextField);
    }

    public Course getCourse() {
        Course course = new Course(mClassTextField.getText());
        course.setProfessorName(mProfessorTextField.getText());
        course.setMeetingDays(mMenuButton.getText());
        return course;
    }
}
