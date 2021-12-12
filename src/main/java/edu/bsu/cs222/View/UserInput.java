package edu.bsu.cs222.View;

import java.util.Scanner;

public class UserInput {
    public String getUserInput() {
        String userInput;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a wikipedia page you want to see revisions for: ");
            userInput = scanner.nextLine();
        } catch (Exception NoSuchElementException) {
            userInput = "";
        }
        if (userInput.equals("")) {
            System.err.println("Please enter something");
            System.exit(1);
        }
        return userInput;
    }
}
