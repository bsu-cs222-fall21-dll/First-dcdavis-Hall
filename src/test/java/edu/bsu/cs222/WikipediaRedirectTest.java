package edu.bsu.cs222;

import edu.bsu.cs222.Model.WikipediaRedirect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;

public class WikipediaRedirectTest {
    @Test
    public void redirectTest() throws IOException {
        WikipediaRedirect wikipediaRedirect = new WikipediaRedirect();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        Assertions.assertEquals("Redirected to Frank Zappa.", wikipediaRedirect.redirectCheck(testDataStream));
    }
}
