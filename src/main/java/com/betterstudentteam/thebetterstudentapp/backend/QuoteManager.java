package com.betterstudentteam.thebetterstudentapp.backend;

import java.time.LocalTime;

public class QuoteManager {

    static public String getTimeRelativeGreeting() {
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isAfter(LocalTime.of(17, 0)) && currentTime.isBefore(LocalTime.MAX)) {
            return "Good Evening";
        } else if (currentTime.isAfter(LocalTime.NOON) && currentTime.isBefore(LocalTime.of(17, 0))) {
            return "Good Afternoon";
        } else if (currentTime.isAfter(LocalTime.MIDNIGHT) && currentTime.isBefore(LocalTime.NOON)){
            return "Good Morning";
        }

        return "Hello";
    }
}
