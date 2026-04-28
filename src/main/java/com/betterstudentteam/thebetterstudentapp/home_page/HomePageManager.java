package com.betterstudentteam.thebetterstudentapp.home_page;

import com.betterstudentteam.thebetterstudentapp.assignments.AssignmentManager;
import com.betterstudentteam.thebetterstudentapp.daily_quote.QuoteService;

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
