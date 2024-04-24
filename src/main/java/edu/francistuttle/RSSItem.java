package edu.francistuttle;

public class RSSItem {
    public String title;
    public String link;
    public String imageLink;
    public String description;
    public String pubDate;

    public RSSItem(String title, String link, String imageLink, String description, String pubDate)
    {
        this.title = title;
        this.link = link;
        this.imageLink = imageLink;
        this.description = description;
        this.pubDate = pubDate;
    }
}
