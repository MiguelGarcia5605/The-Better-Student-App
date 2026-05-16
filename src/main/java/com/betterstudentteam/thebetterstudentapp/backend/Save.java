package com.betterstudentteam.thebetterstudentapp.backend;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class Save {

    private File mSaveFile;
    private ObjectMapper mSaveMapper;
    private ObjectNode mRootNode;

    public Save() {
        mSaveFile = new File("save.json");

        // Create new save file if no current save file exists
        if (!mSaveFile.exists()) {
            try {
                mSaveFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        open();

        // FUTURE WARNING: if the root node is updated in the future the save mapper instance will not change.
        mRootNode = mSaveMapper.createObjectNode();

        close();
    }

    public void open() {
        mSaveMapper = new ObjectMapper();
        JsonNode node = mSaveMapper.readTree(mSaveFile);
        System.out.println(node.toPrettyString());
    }

    public void close() {
        mSaveMapper.writeValue(mSaveFile, mRootNode);
    }

}