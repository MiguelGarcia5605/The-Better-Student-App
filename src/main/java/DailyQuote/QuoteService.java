package DailyQuote;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class QuoteService {

    private List<Quote> quotes = new ArrayList<>();

    public QuoteService() {

        quotes.add(new Quote(1, "Believe you can and you're halfway there.", "Theodore Roosevelt"));
        quotes.add(new Quote(2,"Success is not final, failure is not fatal.", "Winston Churchill"));
        quotes.add(new Quote(3, "The future depends on what you do today.", "Mahatma Gandhi"));
        quotes.add(new Quote(4, "I can do all things through Christ who strengthens me.", "Phillipians 4:13"));
        quotes.add(new Quote(5, "In the middle of difficulty lies opportunity", "Albert Einstein"));
        quotes.add(new Quote(6, " Do what is right, not what is easy nor what is popular.", " Anonymous"));
        quotes.add(new Quote(7, "If you are not willing to risk the usual, you will have to settle for the ordinary", " Jim Rohn"));

    }

    public List<Quote> getAllQuotes() {
        return quotes;
    }

    public Quote getQuoteOfTheDay() {
        int index = LocalDate.now().getDayOfYear() % quotes.size();
        return quotes.get(index);
    }

    public Quote addQuote(String text, String author) {
        int newId = quotes.size() + 1;
        Quote q = new Quote(newId, text, author);
        quotes.add(q);
        return q;
    }
}
