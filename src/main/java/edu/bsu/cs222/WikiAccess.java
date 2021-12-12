package edu.bsu.cs222;

import java.io.*;
import java.net.*;
import java.io.IOException;

//Create URL class is team B's work
public class WikiAccess {
    public String createURL(String searchableArticle) {
        String urlStart = "https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=json&rvprop=timestamp%7Cuser&rvlimit=30&titles=";
        String urlEnd = "&redirects=";
        String fullUrl = urlStart + searchableArticle + urlEnd;
        return fullUrl;
    }
    //was planned to be a mesh between original
    // Wikipedia Revision Reader class and team B's read class
    // but an error had followed
    public String readURL(String url) throws IOException {
        URL search  = new URL(url);
        URLConnection connection = search.openConnection();
        connection.setRequestProperty("User-agent", "WikipediaProject/0.1 (dcdavis@bsu.edu)");
        try {
            connection.connect();
        }
        catch (ConnectException | EOFException | UnknownHostException connectionException) {
            System.err.println("Network connection problem: ");
            System.exit(3);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine = in.readLine();
        in.close();
        return  inputLine;
    }
}
