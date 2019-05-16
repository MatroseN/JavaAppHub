package WebScraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class WebScraper {

    private String webScrapeQuote() {
        String url = "https://www.eduro.com/";
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element quote = document.getElementsByTag("dailyquote").select("p").first();
        Element author = document.getElementsByTag("dailyquote").select("p").first().nextElementSibling();

        String dailyQuote = (quote.text() +  " " + author.text());

        return dailyQuote;
    }

    public String getDailyQuote(){
        String quote = webScrapeQuote();

        return quote;
    }
}
