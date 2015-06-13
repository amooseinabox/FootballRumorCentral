package com.jonphilo.android.footballrumorcentral.models;

import com.jonphilo.android.footballrumorcentral.R;

/**
 * Created by jonathanphilo on 6/10/15.
 */
public class EnglandTeamsModel {
    public String name;

    public static final TeamModel[] data =
            {
                    new TeamModel("Manchester United F.C.", "Manchester, England", R.drawable.mufc),
                    new TeamModel("Tottenham Hotspur F.C.", "London, England", R.drawable.thfc),
                    new TeamModel("Southampton F.C.", "Southampton, England", R.drawable.soton )
            };
    EnglandTeamsModel(String name)
    {
        this.name = name;
    }

}
