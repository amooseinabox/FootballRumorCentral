package com.jonphilo.android.footballrumorcentral.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jonathanphilo on 6/13/15.
 */
public class HandleXML {
    private String title = "title";
    private String link = "link";
    private String description = "description";
    private String urlString = null;
    private XmlPullParserFactory xmlPullParserFactory;
    public volatile boolean parsingComplete = true;
    public volatile ArrayList<RSSItem> items = new ArrayList();

    public HandleXML(String url)
    {
        this.urlString = url;
    }

    public String getTitle()
    {
        return title;
    }

    public String getLink()
    {
        return link;
    }

    public void parseXML(XmlPullParser myParser)
    {
        int event;
        String text = null;
        try{
            event = myParser.getEventType();
            RSSItem item = new RSSItem();
            while(event != XmlPullParser.END_DOCUMENT)
            {
                String name=myParser.getName();

                switch (event)
                {
                    case XmlPullParser.START_TAG:
                        if(name.equals("item"))
                        {
                            item = new RSSItem();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(name.equals("title")){
                            item.setTitle(text);
                        }
                        else if(name.equals("link")){
                            item.setLink(text);
                        }
                        else if(name.equals("description")){
                            item.setDescription(text);
                        }
                        else if(name.equals("content") || name.equals("content:encoded"))
                        {
                            item.setContent(text);
                        }
                        else if(name.equals("pubDate"))
                        {
                            item.setPubDate(text);
                        }
                        else if(name.equals("category"))
                        {
                            item.categories.add(text);
                        }
                        else if(name.equals("item"))
                        {
                            if(item.getTitle() != null && item.getPubDate()!= null) {
                                items.add(item);
                            }
                        }
                        else{
                        }
                        break;
                }
                event = myParser.next();
            }
//            if(item.getTitle() != null && item.getPubDate() != null)
//            {
//                items.add(item);
//            }
            parsingComplete = false;

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void fetchXML()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream stream = conn.getInputStream();
                    xmlPullParserFactory = XmlPullParserFactory.newInstance();
                    XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();

                    xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    xmlPullParser.setInput(stream, null);

                    parseXML(xmlPullParser);
                    stream.close();
                }
                catch(Exception e){

                }
            }
        });
        thread.start();
    }


}
