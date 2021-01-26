package com.mycompany.reddit;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

//    data > children > data > title
//    data > children > data > url_overridden_by_dest
    private static final String template = "http://api.bart.gov/api/etd.aspx?cmd=etd&orig=MONT&key=MW9S-E7SL-26DU-VV8V&json=y";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/articles")
    public List<RedditObject> greeting(@RequestParam(value = "subreddit", defaultValue = "news") String subreddit) {
        List<RedditObject> arr = new ArrayList<>();
// return json list pulled from reddit
        //        for i in jsonList:
        //        add new object, return list
        arr.add(new RedditObject(counter.incrementAndGet(), subreddit, String.format("/r/%s", subreddit)));
        arr.add(new RedditObject(counter.incrementAndGet(), subreddit, String.format("/r/%s", subreddit)));
        System.out.println(JsonUtilities.parseJson(template));
        return arr;
    }
}