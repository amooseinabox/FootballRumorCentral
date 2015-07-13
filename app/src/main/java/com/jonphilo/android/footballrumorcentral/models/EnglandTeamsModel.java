package com.jonphilo.android.footballrumorcentral.models;

import com.jonphilo.android.footballrumorcentral.R;

/**
 * Created by jonathanphilo on 6/10/15.
 */
public class EnglandTeamsModel {
    public String name;

    public static final TeamModel[] data =
            {
                    new TeamModel("Arsenal F.C.", "London, England", R.drawable.arsenal,
                            new String[]{
                                    "http://www.football365.com/arsenal/rss",
                                    "http://arseblog.com/feed/",
                                    "http://www.espnfc.com/club/arsenal/359/blog/rss",
                                    "http://metro.co.uk/tag/arsenal-fc/feed/"
                            }),
                    new TeamModel("Chelsea F.C.", "London, England", R.drawable.chelsea,
                            new String[]{
                                    "http://www.football365.com/chelsea/rss",
                                    "http://feeds.feedburner.com/chelseablog",
                                    "http://www.espnfc.com/club/chelsea/363/blog/rss",
                                    "http://www.chelseadaft.org/feeds/posts/default?alt=rss",
                                    "http://theprideoflondon.com/feed/"
                            }),
                    new TeamModel("Manchester City F.C.", "Manchester, England", R.drawable.mancity,
                            new String[]{
                                    "http://www.football365.com/manchester-city/rss",
                                    "http://www.espnfc.com/club/manchester-city/382/blog/rss",
                                    "http://www.typicalcity.org/feed/",
                                    "http://metro.co.uk/tag/manchester-city-fc/feed/"

                            }),
                    new TeamModel("Manchester United F.C.", "Manchester, England", R.drawable.mufc,
                            new String[]{
                                    "http://thepeoplesperson.com/category/man-utd-transfer-news/feed/",
                                    "http://manutdnewsfeed.com/feed/",
                                    "http://thebusbybabe.sbnation.com/rss/current",
                                    "http://www.manchesterlalala.com/feed/",
                                    "http://www.football365.com/manchester-united/rss",
                                    "http://otp.investis.com/clients/us/manchester_united/usn/us-rss-feed.aspx",
                                    "http://www.espnfc.com/club/manchester-united/360/blog/rss",
                                    "http://metro.co.uk/tag/arsenal-fc/feed/"
                            }),
                    new TeamModel("Tottenham Hotspur F.C.", "London, England", R.drawable.thfc,
                            new String[]{
                                    "http://hotspurrelated.co.uk/archive/feed/",
                                    "https://dailyhotspur.wordpress.com/feed/",
                                    "http://www.espnfc.com/club/tottenham-hotspur/367/blog/rss"
                            }),
                    new TeamModel("Southampton F.C.", "Southampton, England", R.drawable.soton,
                            new String[]{
                                    "http://www.espnfc.com/club/southampton/376/blog/rss",
                                    "http://www.football365.com/southampton/rss",
                                    "http://metro.co.uk/tag/southampton-fc/feed/",
                                    "http://metro.co.uk/tag/southampton-fc/feed/"
                            })
            };
    EnglandTeamsModel(String name)
    {
        this.name = name;
    }

}
