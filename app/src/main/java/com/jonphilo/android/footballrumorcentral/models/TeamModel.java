package com.jonphilo.android.footballrumorcentral.models;

import com.jonphilo.android.footballrumorcentral.xml.RSSItem;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jonathanphilo on 6/10/15.
 */
public class TeamModel implements Serializable {
    private String _teamName;
    private String _location;
    private String _picture;

    public TeamModel(String name, String location, String filename, String[] rss)
    {
        _teamName = name;
        _location = location;
        _picture = filename;
        RSS = rss;
    }

    public String GetTeamName()
    {
        return _teamName;
    }
    public void SetTeamName(String teamName)
    {
        _teamName = teamName;
    }

    public String GetTeamLocation()
    {
        return _location;
    }

    public void SetTeamLocation(String teamLocation)
    {
        _location = teamLocation;
    }

    public String GetPicture()
    {
        return _picture;
    }

    public void SetPicture(String _picture)
    {
        _picture = _picture;
    }

    public String[] RSS;

    public ArrayList<RSSItem> RSSItems = new ArrayList();

}
