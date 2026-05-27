package com.betterstudentteam.thebetterstudentapp.frontend.scene;

import com.betterstudentteam.thebetterstudentapp.App;

public class SceneManager {

    private HomeScene mHomeScene;
    private TodoScene mTodoScene;
    private SetupScene mSetupScene;

    public SceneManager() {
        mHomeScene = new HomeScene();
        mTodoScene = new TodoScene();
        mSetupScene = new SetupScene();
    }

    public void setScene(Scenes scenes) {
        switch (scenes) {
            case HOME:
                App.getStage().setScene(mHomeScene);
                break;
            case TODO:
                App.getStage().setScene(mTodoScene);
                break;
            case SETUP:
                App.getStage().setScene(mSetupScene);
                break;
        }
    }
}
