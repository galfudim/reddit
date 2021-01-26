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
    public static String parseJsonIntoList(String urlString, List<RedditObject> redditObjectList) {
        AtomicLong counter = new AtomicLong();
        URL url;
        String text, title, permalink, output = "";
        JSONObject jsonData, currJsonObject, currData;
        JSONArray children;

        try {
            url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "gfudim:redditParser:v0.0.1-SNAPSHOT (by /u/gfudim)");
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }
            Scanner sc = new Scanner(url.openStream());
            text = "";
            while (sc.hasNext()) {
                text += sc.nextLine();
            }
            sc.close();
            JSONParser parse = new JSONParser();
            jsonData = (JSONObject) parse.parse(text);
            jsonData = (JSONObject) jsonData.get("data");
            children = (JSONArray) jsonData.get("children");
            for (int i = 0; i < children.size(); i++) {
                currJsonObject = (JSONObject) children.get(i);
                currData = (JSONObject) currJsonObject.get("data");
                title = currData.get("title").toString();
                permalink = currData.get("permalink").toString();
                RedditObject ro = new RedditObject(counter.incrementAndGet(), title, permalink);
                redditObjectList.add(ro);
            }
            httpURLConnection.disconnect();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return output;
    }
}
