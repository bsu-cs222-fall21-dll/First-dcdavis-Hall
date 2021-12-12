package edu.bsu.cs222.Model;

import edu.bsu.cs222.View.UserInput;
import edu.bsu.cs222.View.WikiPageNotFound;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Setup {
    public void finalResults() throws IOException {
        //Team B's setup compiler
        //my own originally (past when I sent it in) instantiated the classes but did nothing with them
        //so the idea of the 'nested strings' did not come to mind
        ArrayFormatter arrayFormatter = new ArrayFormatter();
        WikipediaRedirect wikipediaRedirect = new WikipediaRedirect();
        WikiPageNotFound wikiPageNotFound = new WikiPageNotFound();
        WikiAccess wikiAccess = new WikiAccess();
        UserInput userInput = new UserInput();
        InputModifier inputModifier = new InputModifier();
        RevisionParser revisionParser = new RevisionParser();

        String input = userInput.getUserInput();
        String modifiedInput = inputModifier.modifyUserInput(input);
        String url = wikiAccess.createURL(modifiedInput);
        String data = wikiAccess.readURL(url);

        InputStream inputStreamPageNotFound = new ByteArrayInputStream(data.getBytes());
        InputStream inputStreamRedirect = new ByteArrayInputStream(data.getBytes());
        InputStream inputStreamRevisions = new ByteArrayInputStream(data.getBytes());

        wikiPageNotFound.noWikipediaArticleFound(inputStreamPageNotFound);

        System.out.println(wikipediaRedirect.redirectCheck(inputStreamRedirect));
        String finalPrintOut = arrayFormatter.printArrayList(revisionParser.addRevisions(inputStreamRevisions));
        System.out.println(finalPrintOut);
    }
}
