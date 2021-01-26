# Java Reddit Scraper

#### 1. Getting started
```
git clone https://github.com/galfudim/reddit.git
cd reddit
```

#### 2. Setting a unique User-Agent:
Change Line 25 of `src/main/java/com/mycompany/reddit/JsonUtilities.java` and set a unique User-Agent for your client.
The [Reddit API](https://github.com/reddit-archive/reddit/wiki/API#rules "API#rules") suggests the following format:

`<platform>:<app ID>:<version string> (by /u/<reddit username>)`. For example: `java:com.mycompany.reddit:v0.0.1-SNAPSHOT (by /u/[your Reddit username])`

#### 3. Building:
```
mvn clean package
```
#### 4. Starting:
```
java -jar target/reddit-0.0.1-SNAPSHOT.jar 
```

#### 5. Using:
Go to `http://localhost:8080/articles` and specify a subreddit name for the subreddit field and a limit on number of articles for the limit field. For example: `http://localhost:8080/articles?subreddit=NBA&limit=5`.
The response should look like this:
```json
[
    {
        "id": 1,
        "title": "Trade Talk Tuesday + Game Thread Index",
        "permalink": "/r/nba/comments/l5di6l/trade_talk_tuesday_game_thread_index/"
    },
    {
        "id": 2,
        "title": "[SERIOUS NEXT DAY THREAD] Post-Game Discussion (January 25, 2021)",
        "permalink": "/r/nba/comments/l5cl4z/serious_next_day_thread_postgame_discussion/"
    },
    {
        "id": 3,
        "title": "LeBron James tonight with 46 points, 7/11 from 3, 21 points in the 4th quarter.",
        "permalink": "/r/nba/comments/l557lo/lebron_james_tonight_with_46_points_711_from_3_21/"
    },
    {
        "id": 4,
        "title": "[Highlight] Curry is straight up ridiculous",
        "permalink": "/r/nba/comments/l55so5/highlight_curry_is_straight_up_ridiculous/"
    },
    {
        "id": 5,
        "title": "[Dumas] If you notice, a lack of official tributes from organizations and the NBA this week for Kobe Bryant, it is because his family has asked that teams do not do tributes this year.",
        "permalink": "/r/nba/comments/l50qr3/dumas_if_you_notice_a_lack_of_official_tributes/"
    }
]
```