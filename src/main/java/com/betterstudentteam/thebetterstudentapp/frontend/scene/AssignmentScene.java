package com.betterstudentteam.thebetterstudentapp.frontend.scene;

import com.betterstudentteam.thebetterstudentapp.frontend.components.AssignmentPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class AssignmentScene extends Scene {

    private static final BorderPane mBorderPane = new BorderPane();

    private AssignmentPane mAssignmentPane;

    public AssignmentScene() {
        super(mBorderPane);
        mAssignmentPane = new AssignmentPane();

        mBorderPane.setCenter(mAssignmentPane);
        this.getStylesheets().add("StyleSheet.css");
    }
}
