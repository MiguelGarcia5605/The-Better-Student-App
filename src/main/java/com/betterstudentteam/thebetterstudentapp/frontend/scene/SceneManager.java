package com.betterstudentteam.thebetterstudentapp.frontend.scene;

import com.betterstudentteam.thebetterstudentapp.App;

public class SceneManager {

    private HomeScene mHomeScene;
    private AssignmentScene mAssignmentScene;

    public SceneManager() {
        mHomeScene = new HomeScene();
        mAssignmentScene = new AssignmentScene();
    }

    public void setScene(Scenes scenes) {
        switch (scenes) {
            case HOME:
                App.getStage().setScene(mHomeScene);
                break;
            case ASSIGNMENT:
                App.getStage().setScene(mAssignmentScene);
                break;
        }
    }
}
