package edu.bsu.cs222;

import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;


public class WikipediaRevisionReader {
    public static void main(String[] args) {
        //Primary main is currently followed by from professor Gestwicki
        WikipediaRevisionReader revisionReader = new WikipediaRevisionReader();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        try {
            String timestamp = revisionReader.getLatestRevisionOf(line);
            System.out.println(timestamp);
        } catch (IOException ioException) {
            System.err.println("Network connection problem: " + ioException.getMessage());
        }
    }

        private String getLatestRevisionOf(String articleTitle) throws IOException {
            String urlString = String.format("https://en.wikipedia.org/wiki/Doughnut", articleTitle);
            String encoderUrlString = URLEncoder.encode(urlString, Charset.defaultCharset());

            try {
                URL url = new URL(encoderUrlString);
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("User-Agent", "WikipediaRevision/0.1 (dcdavis@bsu.edu)");
                InputStream inputStream = connection.getInputStream();
                RevisionParser parser = new RevisionParser();
                String timestamp = parser.parse(inputStream);
                return timestamp;
            } catch (MalformedURLException malformedURLException) {
                throw new RuntimeException(malformedURLException);
            }
        }
    }
