package edu.bsu.cs222.Model;

public class Revision {
    String user;
    String timestamp;

    public Revision(String user, String timestamp) {
        this.user = user;
        this.timestamp = timestamp;
    }
    public String getUser() {
        return user;
    }
    public String getTimestamp() {
        return timestamp;
    }

}
