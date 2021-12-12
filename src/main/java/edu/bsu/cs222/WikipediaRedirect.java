package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRedirect {

    public String redirectCheck(InputStream dataStream) throws IOException {
        try {
            JSONArray result = JsonPath.read(dataStream, "$..redirects");
            JSONArray redirects = JsonPath.read(result, "$..to");
            return "Redirected to " + redirects.get(0).toString() + ".";
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return " ";
        }

    }
}
