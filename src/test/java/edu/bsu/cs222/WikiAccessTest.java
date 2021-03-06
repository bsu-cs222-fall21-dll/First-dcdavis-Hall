package edu.bsu.cs222;
import edu.bsu.cs222.Model.WikiAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WikiAccessTest {
    @Test
    public void testUrl() {
        WikiAccess wikiAccess = new WikiAccess();
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=json&rvprop=timestamp%7Cuser&rvlimit=30&titles=Frank+Zappa&redirects=", wikiAccess.createURL("Frank+Zappa"));
    }
}
