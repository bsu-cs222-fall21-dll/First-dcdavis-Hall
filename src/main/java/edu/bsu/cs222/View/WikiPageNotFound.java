package edu.bsu.cs222.View;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikiPageNotFound {
    public void noWikipediaArticleFound(InputStream dataStream) throws IOException {
        JSONArray result = JsonPath.read(dataStream, "$..missing");
        if (result.size() != 0) {
            System.err.println("This page does not exist");
            System.exit(2);
        }
    }
}
