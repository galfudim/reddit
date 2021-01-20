package com.mycompany.reddit;

public class RedditObject {

    private final long id;
    private final String title;
    private final String url;

    public RedditObject(long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}