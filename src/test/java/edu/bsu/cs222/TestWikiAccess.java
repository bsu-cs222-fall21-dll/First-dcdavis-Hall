package edu.bsu.cs222;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestWikiAccess {
    @Test
    public void testUrl() {
        WikiAccess wikiAccess = new WikiAccess();
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=json&rvprop=timestamp%7Cuser&rvlimit=30&titles=", wikiAccess.createURL("Frank+Zappa"));
    }
}
