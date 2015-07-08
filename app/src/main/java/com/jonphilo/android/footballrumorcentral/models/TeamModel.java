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
    private int _pictureID;

    public TeamModel(String name, String location, int id, String[] rss)
    {
        _teamName = name;
        _location = location;
        _pictureID = id;
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

    public int GetPictureID()
    {
        return _pictureID;
    }

    public void SetPictureID(int id)
    {
        _pictureID = id;
    }

    public String[] RSS;

    public ArrayList<RSSItem> RSSItems = new ArrayList();

}
