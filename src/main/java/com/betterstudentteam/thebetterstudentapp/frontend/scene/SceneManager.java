package com.betterstudentteam.thebetterstudentapp.frontend.scene;

import com.betterstudentteam.thebetterstudentapp.App;

public class SceneManager {

    private HomeScene mHomeScene;
    private AssignmentScene mAssignmentScene;
    private CourseScene mCourseScene;

    public SceneManager() {
        mHomeScene = new HomeScene();
        mAssignmentScene = new AssignmentScene();
        mCourseScene = new CourseScene();
    }

    public void setScene(Scenes scenes) {
        switch (scenes) {
            case HOME:
                App.getStage().setScene(mHomeScene);
                break;
            case ASSIGNMENT:
                App.getStage().setScene(mAssignmentScene);
                break;
            case COURSE:
                App.getStage().setScene(mCourseScene);
                break;
        }
    }
}
