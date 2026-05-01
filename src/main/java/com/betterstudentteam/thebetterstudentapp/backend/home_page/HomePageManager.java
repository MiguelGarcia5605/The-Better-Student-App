package com.betterstudentteam.thebetterstudentapp.backend.home_page;

import com.betterstudentteam.thebetterstudentapp.backend.assignment.AssignmentList;
import com.betterstudentteam.thebetterstudentapp.backend.daily_quote.QuoteService;

public class HomePageManager {

    private AssignmentList assignmentList;
    private QuoteService quoteService;

    public HomePageManager(AssignmentList assignment, QuoteService quoteService) {

        this.assignmentList = assignmentList;
        this.quoteService = quoteService;
    }

    public HomePageData loadHomePage() {

        return new HomePageData( assignmentList.getUpcomingAssignments(), assignmentList.getOverdueAssignments(), quoteService.getQuoteOfTheDay().getText());
    }

}
