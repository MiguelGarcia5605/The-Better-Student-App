package com.betterstudentteam.thebetterstudentapp.frontend.scene;

import com.betterstudentteam.thebetterstudentapp.frontend.AppToolbar;
import com.betterstudentteam.thebetterstudentapp.frontend.setup.SetupPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class SetupScene extends Scene {

    private static final BorderPane mBorderPane = new BorderPane();

    private AppToolbar mAppToolbar;
    private SetupPane mSetupPane;

    public SetupScene() {
        super(mBorderPane);
        mAppToolbar = new AppToolbar();
        mSetupPane = new SetupPane();

        mBorderPane.setTop(mAppToolbar);
        mBorderPane.setCenter(mSetupPane);
        this.getStylesheets().add("StyleSheet.css");
    }
}
