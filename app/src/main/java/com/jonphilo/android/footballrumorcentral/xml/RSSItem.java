package com.jonphilo.android.footballrumorcentral.xml;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by jonathanphilo on 6/14/15.
 */
public class RSSItem implements Serializable, Comparable<RSSItem>
{
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String link;

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    private String urlString;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> category) {
        this.categories = category;
    }

    public ArrayList<String> categories = new ArrayList();

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    private String pubDate;

    @Override
    public int compareTo(RSSItem another) {

        DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
        try{
            Date thisDate = dateFormat.parse(this.getPubDate());
            Date anotherDate = dateFormat.parse(another.getPubDate());
            if (thisDate.before(anotherDate))
                return 1;
            else if (thisDate.equals(anotherDate))
                return 0;
            else
                return -1;
        }
        catch (Exception e)
        {
            return -1;
        }


    }
}
