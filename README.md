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
