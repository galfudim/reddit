package com.mycompany.reddit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtilities {
    public static String parseJson(String urlString) {
        AtomicLong counter = new AtomicLong();
        URL url;
        String text, title, permalink, output = "";
        JSONObject jsonData, currJsonObject, currData;
        JSONArray children;

        try {
            // Fetching data from BART API, with the following parameters: cmd=etd (current departure information), orig=MONT (Montgomery St. station), key=MW9S-E7SL-26DU-VV8V (test key), json=y (produces JSON output)
            url = new URL("https://www.reddit.com/r/usa/.json?limit=20");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "java:com.mycompany.redditSpringApplication:v0.0.1-SNAPSHOT (by /u/gfudim)");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            Scanner sc = new Scanner(url.openStream());
            text = "";
            while (sc.hasNext()) {
                System.out.println("Entered scanner");
                text += sc.nextLine();
            }
            sc.close();
//            System.out.println(text);
            // Parsing JSON output
            JSONParser parse = new JSONParser();
            jsonData = (JSONObject) parse.parse(text);
            jsonData = (JSONObject) jsonData.get("data");
            children = (JSONArray) jsonData.get("children");
            System.out.println("About to:");
            for (int i = 0; i < children.size(); i++) {
                currJsonObject = (JSONObject) children.get(i);
                currData = (JSONObject) currJsonObject.get("data");

                title = currData.get("title").toString();
                permalink = currData.get("permalink").toString();

                System.out.println(title);
                System.out.println(permalink);
                RedditObject ro = new RedditObject(counter.incrementAndGet(), title, permalink);
            }
            System.out.println("finished");
            httpURLConnection.disconnect();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return output;
    }
}
