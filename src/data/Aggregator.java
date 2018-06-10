package data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Class that aggregates all medical data through web scraping.
 */
public class Aggregator {
    // URL to retrieve medical information from
    private static final String MEDICINE_URL = "https://www.hopkinsmedicine.org/healthlibrary/conditions/adult/";

    /**
     * Aggregator constructor that provides setup logic.
     */
    public Aggregator() throws Exception {
        // TODO: Catch and handle exception
        retrieveData();
    }

    /**
     * Method that retrieves data from the url and stores in a data file.
     */
    public void retrieveData() throws Exception {
        // TODO: Catch and handle exception
        Document medDoc = Jsoup.connect(MEDICINE_URL).get();
        String body = medDoc.body().text();
        System.out.println(body);
    }

    /**
     * Method that checks url for info updates.
     * @return true if site has updates
     */
    public boolean hasUpdate() {
        return false;
    }

    /**
     * Method that checks if medical data file exists
     * @return
     */
    public boolean hasData() {
        return false;
    }
}
