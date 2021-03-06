package edu.bsu.cs222;

import edu.bsu.cs222.RevisionParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionParserTest {
    @Test
    public void testParse() throws IOException {
        RevisionParser parser = new RevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamp = parser.parse(testDataStream);
        Assertions.assertEquals("2021-09-19T01:09:23Z", timestamp);
    }
}
