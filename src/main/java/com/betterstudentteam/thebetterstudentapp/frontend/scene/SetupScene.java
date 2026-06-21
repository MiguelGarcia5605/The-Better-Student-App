package com.betterstudentteam.thebetterstudentapp.frontend.scene;

import com.betterstudentteam.thebetterstudentapp.frontend.AppToolbar;
import com.betterstudentteam.thebetterstudentapp.frontend.setup.SetupPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class SetupScene extends Scene {

    private static final BorderPane mBorderPane = new BorderPane();

    private SetupPane mSetupPane;

    public SetupScene() {
        super(mBorderPane);
        mSetupPane = new SetupPane();

        mBorderPane.setCenter(mSetupPane);
        this.getStylesheets().add("StyleSheet.css");
    }
}
