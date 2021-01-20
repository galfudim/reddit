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
    private static final String template = "http://www.reddit.com/r/%s/.json?limit=20";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/articles")
    public List<RedditObject> greeting(@RequestParam(value = "name", defaultValue = "news") String name) {
        List<RedditObject> arr = new ArrayList<>();
// return json list pulled from reddit
        //        for i in jsonList:
        //        add new object, return list
        arr.add(new RedditObject(counter.incrementAndGet(), name, String.format(template, name)));
        arr.add(new RedditObject(counter.incrementAndGet(), name, String.format(template, name)));
        return arr;
    }
}