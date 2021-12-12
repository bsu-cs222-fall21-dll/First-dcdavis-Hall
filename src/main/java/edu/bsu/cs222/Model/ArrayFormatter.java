package edu.bsu.cs222.Model;

import java.util.ArrayList;

public class ArrayFormatter {
    public String printArrayList(ArrayList<Revision> revision) {
        StringBuilder formattedRevisions = new StringBuilder();

        for (Revision revision1: revision) {
            String user = revision1.getUser();
            String timeStamp = revision1.getTimestamp();

            String revisionData = String.format("%s %s \n", timeStamp, user);
            formattedRevisions.append(revisionData);
        }

        return formattedRevisions.toString();
    }
}
