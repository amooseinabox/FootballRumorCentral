package com.jonphilo.android.footballrumorcentral.models;

/**
 * Created by jonathanphilo on 6/10/15.
 */
public class TeamModel {
    private String _teamName;
    private String _location;
    private int _pictureID;

    public TeamModel(String name, String location, int id)
    {
        _teamName = name;
        _location = location;
        _pictureID = id;
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

}
