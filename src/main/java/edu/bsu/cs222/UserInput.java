package edu.bsu.cs222;

import java.util.Scanner;

public class UserInput {
    public String getUserInput() {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a wikipedia page you want to see revisions for: ");
        userInput = scanner.nextLine();
        if (userInput.equals("")) {

        }

        return userInput;
    }
}
