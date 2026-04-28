package com.betterstudentteam.thebetterstudentapp.HomePage;

import com.betterstudentteam.thebetterstudentapp.Assignments.AssignmentManager;
import DailyQuote.QuoteService;

public class HomePageManager {

    private AssignmentManager assignmentManager;
    private QuoteService quoteService;

    public HomePageManager(AssignmentManager assignment, QuoteService quoteService) {

        this.assignmentManager = assignmentManager;
        this.quoteService = quoteService;
    }

    public HomePageData loadHomePage() {

        return new HomePageData( assignmentManager.getUpcomingAssignments(), assignmentManager.getOverdueAssignments(), quoteService.getQuoteOfTheDay().getText());
    }

}
