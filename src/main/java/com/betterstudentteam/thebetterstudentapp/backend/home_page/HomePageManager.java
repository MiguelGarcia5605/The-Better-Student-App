package com.betterstudentteam.thebetterstudentapp.backend.home_page;

import com.betterstudentteam.thebetterstudentapp.backend.assignments.AssignmentManager;
import com.betterstudentteam.thebetterstudentapp.backend.daily_quote.QuoteService;

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
