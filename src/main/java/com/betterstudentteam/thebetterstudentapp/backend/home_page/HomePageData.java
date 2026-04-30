
package com.betterstudentteam.thebetterstudentapp.backend.home_page;


import com.betterstudentteam.thebetterstudentapp.backend.assignments.Assignment;
import java.util.List;


public class HomePageData {

    private List<Assignment> upcomingAssignments;
    private List<Assignment> overdueAssignments;
    private String dailyQuote;

    public HomePageData(List<Assignment> upcomingAssignments, List<Assignment> overdueAssignments, String dailyQuote) {
        this.upcomingAssignments = upcomingAssignments;
        this.overdueAssignments = overdueAssignments;
        this.dailyQuote = dailyQuote;
    }

    public List<Assignment> getUpcomingAssignments() {
        return upcomingAssignments;
    }

    public List<Assignment> getOverdueAssignments() {
        return overdueAssignments;
    }

    public String getDailyQuote() {
        return dailyQuote;
    }
}
