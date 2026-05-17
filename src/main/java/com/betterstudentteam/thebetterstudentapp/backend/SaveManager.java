package com.betterstudentteam.thebetterstudentapp.backend;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SaveManager {

    private File mSaveFile;
    private ObjectMapper mObjectMapper;

    public SaveManager() {
        mSaveFile = new File("save.json");
        mObjectMapper = new ObjectMapper();

        // Create new save file if no current save file exists
        if (!mSaveFile.exists()) {
            try {
                mSaveFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public void writeSave(ArrayList<Course> courseArrayList) {
        JsonNode rootNode = mObjectMapper.createObjectNode();

        if (!courseArrayList.isEmpty()) {
            for (int i = 0; courseArrayList.size() > i; i++) {
                Course course = courseArrayList.get(i);
                ArrayList<Assignment> assignmentArrayList = course.getAssignmentArrayList();

                // Add course as child node to root
                JsonNode courseNode = rootNode.asObject().putPOJO("course " + i, courseArrayList.get(i));
            }
        }
        mObjectMapper.writeValue(mSaveFile, rootNode);
    }
}