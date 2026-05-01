package com.betterstudentteam.thebetterstudentapp.backend.util;

import java.util.UUID;

public class ID {
    // Generate unique ID's for each assignment so n one override each other
    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}