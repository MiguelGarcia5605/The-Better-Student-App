package com.betterstudentteam.thebetterstudentapp.backend;

import java.io.File;
import java.io.IOException;

public class Save {

    private File mSaveFile;

    public Save() {
        mSaveFile = new File("save.json");

        // Create new save file if no current save file exists
        if (!mSaveFile.exists()) {
            try {
                mSaveFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}