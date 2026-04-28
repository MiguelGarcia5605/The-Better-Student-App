package DailyQuote;

public class QuoteController {

    private QuoteService quoteService;

    public QuoteController() {
        this.quoteService = new QuoteService();
    }

    public QuotePageData loadQuotePage() {
        return new QuotePageData(quoteService.getQuoteOfTheDay());
    }
}
