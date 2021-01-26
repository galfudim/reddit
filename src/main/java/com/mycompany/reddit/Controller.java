package com.mycompany.reddit;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final String template = "https://www.reddit.com/r/%s/.json?limit=%d";

    @GetMapping("/articles")
    public List<RedditObject> greeting(@RequestParam(value = "subreddit", defaultValue = "news") String subreddit,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        List<RedditObject> arr = new ArrayList<>();
        String url = String.format(template, subreddit, limit);
        JsonUtilities.parseJsonIntoList(url, arr);
        return arr;
    }
}