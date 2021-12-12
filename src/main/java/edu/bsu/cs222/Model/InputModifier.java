package edu.bsu.cs222.Model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class InputModifier {
    public String modifyUserInput(String userInput){
        String encodedSearchString = null;
        try {
            encodedSearchString = URLEncoder.encode(userInput, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodedSearchString;
    }
}
