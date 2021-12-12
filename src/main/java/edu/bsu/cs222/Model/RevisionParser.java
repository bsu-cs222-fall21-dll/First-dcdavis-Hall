package edu.bsu.cs222.Model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RevisionParser {
    //Team I's  parsing framework for revision array
    public ArrayList<Revision> addRevisions(InputStream testDataStream) throws IOException {

        ArrayList<Revision> revisionsList = new ArrayList<>();
        JSONArray revisionsJSONArray = JsonPath.read(testDataStream, "$..revisions[0:]");

        for (int i = 0; i < revisionsJSONArray.size(); i++) {
            JSONArray author = JsonPath.read(revisionsJSONArray, "$..user");
            //took me 15 minutes to find; read(revisionsJSONArray) was reading testDataStream
            // which it used to do as a test in the past causing index errors
            JSONArray timestamp = JsonPath.read(revisionsJSONArray, "$..timestamp");
            Revision revision = new Revision(author.get(i).toString(), timestamp.get(i).toString());
            revisionsList.add(revision);
        }
        return revisionsList;
    }
}
