package com.betterstudentteam.thebetterstudentapp.frontend.scene;

import com.betterstudentteam.thebetterstudentapp.frontend.AppToolbar;
import com.betterstudentteam.thebetterstudentapp.frontend.home.HomePane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class HomeScene extends Scene {

    private static final BorderPane mBorderPane = new BorderPane();

    private AppToolbar mAppToolbar;
    private HomePane mHomePane;

    public HomeScene() {
        super(mBorderPane);
        mAppToolbar = new AppToolbar();
        mHomePane = new HomePane();

        mBorderPane.setTop(mAppToolbar);
        mBorderPane.setCenter(mHomePane);
        this.getStylesheets().add("StyleSheet.css");
    }
}