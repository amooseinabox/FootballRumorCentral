package com.jonphilo.android.footballrumorcentral.models;

import com.jonphilo.android.footballrumorcentral.R;

/**
 * Created by jonathanphilo on 6/10/15.
 */
public class EnglandTeamsModel {
    public String name;

    public static final TeamModel[] data =
            {
                    new TeamModel("Aston Villa F.C.", "Birmingham, England", R.drawable.avfc,
                            new String[]{
                                    "http://www.football365.com/aston-villa/rss",
                                    "http://www.astonvillalife.com/feed/",
                                    "http://avillafan.com/site/feed/",
                                    "http://metro.co.uk/tag/aston-villa-fc/feed/",
                                    "http://7500toholte.sbnation.com/rss/current"
                            }),
                    new TeamModel("Arsenal F.C.", "London, England", R.drawable.arsenal,
                            new String[]{
                                    "http://www.football365.com/arsenal/rss",
                                    "http://arseblog.com/feed/",
                                    "http://metro.co.uk/tag/arsenal-fc/feed/",
                                    "http://theshortfuse.sbnation.com/rss/current"
                            }),
                    new TeamModel("A.F.C. Bournemouth", "Bournemouth, England", R.drawable.bourne,
                            new String[]{
                                    "http://www.football365.com/afc-bournemouth/rss",
                                    "http://www.thesouthend.co.uk/blog/feed/",
                                    "http://afcbchimes.blogspot.com/feeds/posts/default?alt=rss"
                            }),
                    new TeamModel("Chelsea F.C.", "London, England", R.drawable.chelsea,
                            new String[]{
                                    "http://www.football365.com/chelsea/rss",
                                    "http://feeds.feedburner.com/chelseablog",
                                    "http://www.chelseadaft.org/feeds/posts/default?alt=rss",
                                    "http://theprideoflondon.com/feed/",
                                    "http://weaintgotnohistory.sbnation.com/rss/current"
                            }),
                    new TeamModel("Crystal Palace F.C.", "London, England", R.drawable.cpalace,
                            new String[]{
                                    "http://www.football365.com/crystal-palace/rss",
                                    "http://metro.co.uk/tag/crystal-palace-fc/feed/",
                                    "http://theeaglesbeak.com/feed/",
                                    "http://www.holmesdale.net/rss/"
                            }),
                    new TeamModel("Leicester City F.C.", "Leicester, England", R.drawable.leicester,
                            new String[]{
                                    "http://www.football365.com/leicester-city/rss",
                                    "http://metro.co.uk/tag/leicester-city-fc/feed/"
                            }),
                    new TeamModel("Everton F.C.", "Liverpool, England", R.drawable.everton,
                            new String[]{
                                    "http://www.football365.com/everton/rss",
                                    "http://metro.co.uk/tag/everton-fc/feed/",
                                    "http://toffeeweb.com/rss/",
                                    "http://royalbluemersey.sbnation.com/rss/current"
                            }),
                    new TeamModel("Liverpool F.C.", "Liverpool, England", R.drawable.liverpool,
                            new String[]{
                                    "http://www.football365.com/liverpool/rss",
                                    "http://metro.co.uk/tag/liverpool-fc/feed/",
                                    "http://www.thisisanfield.com/feed/",
                                    "http://www.empireofthekop.com/feed/",
                                    "http://anfieldasylum.sbnation.com/rss/current",
                                    "http://liverpooloffside.sbnation.com/rss/current"
                            }),
                    new TeamModel("Manchester City F.C.", "Manchester, England", R.drawable.mancity,
                            new String[]{
                                    "http://www.football365.com/manchester-city/rss",
                                    "http://www.typicalcity.org/feed/",
                                    "http://metro.co.uk/tag/manchester-city-fc/feed/",
                                    "http://bitterandblue.sbnation.com/rss/current"

                            }),
                    new TeamModel("Manchester United F.C.", "Manchester, England", R.drawable.mufc,
                            new String[]{
                                    "http://thepeoplesperson.com/category/man-utd-transfer-news/feed/",
                                    "http://manutdnewsfeed.com/feed/",
                                    "http://thebusbybabe.sbnation.com/rss/current",
                                    "http://www.manchesterlalala.com/feed/",
                                    "http://www.football365.com/manchester-united/rss",
                                    "http://otp.investis.com/clients/us/manchester_united/usn/us-rss-feed.aspx",
                                    "http://metro.co.uk/tag/manchester-united-fc/feed/"
                            }),
                    new TeamModel("Newcastle United F.C.", "Newcastle, England", R.drawable.newcastle,
                            new String[]{
                                    "http://www.football365.com/newcastle-united/rss",
                                    "http://metro.co.uk/tag/newcastle-united-fc/feed/",
                                    "http://www.nufcblog.com/feed/",
                                    "http://cominghomenewcastle.sbnation.com/rss/current"
                            }),
                    new TeamModel("Norwich City F.C.", "Norwich, England", R.drawable.norwich,
                            new String[]{
                                    "http://www.football365.com/norwich-city/rss",
                                    "http://www.canariesworld.co.uk/feed/",
                                    "http://metro.co.uk/tag/norwich-city-fc/feed/"
                            }),
                    new TeamModel("Southampton F.C.", "Southampton, England", R.drawable.soton,
                            new String[]{
                                    "http://www.football365.com/southampton/rss",
                                    "http://metro.co.uk/tag/southampton-fc/feed/",
                                    "http://stmarysmusings.sbnation.com/rss/current",
                                    "http://stmarysmusings.sbnation.com/rss/current"
                            }),
                    new TeamModel("Stoke City F.C.", "Stoke-on-Trent, England", R.drawable.stoke,
                            new String[]{
                                    "http://www.football365.com/stoke-city/rss",
                                    "http://metro.co.uk/tag/stoke-city-fc/feed/",
                                    "http://fourtwothreeonestoke.com/feed/"
                            }),
                    new TeamModel("Sunderland A.F.C.", "Sunderland, England", R.drawable.sunderland,
                            new String[]{
                                    "http://rokerreport.sbnation.com/rss/current",
                                    "http://www.football365.com/sunderland/rss",
                                    "http://metro.co.uk/tag/sunderland-fc/feed/",
                                    "http://www.wearewearside.com/syndication.axd",
                                    "http://salutsunderland.com/feed/"
                            }),
                    new TeamModel("Swansea City A.F.C.", "Swansea, Wales", R.drawable.swansea,
                            new String[]{
                                    "http://www.football365.com/swansea/rss",
                                    "http://metro.co.uk/tag/swansea-city-fc/feed/",
                                    "http://theswanseaway.co.uk/feed/"
                            }),
                    new TeamModel("Tottenham Hotspur F.C.", "London, England", R.drawable.thfc,
                            new String[]{
                                    "http://www.football365.com/tottenham-hotspur/rss",
                                    "http://metro.co.uk/tag/tottenham-hotspur-fc/feed/",
                                    "http://cartilagefreecaptain.sbnation.com/rss/current",
                                    "http://www.thefightingcock.co.uk/blog/articles/feed/",
                                    "http://hotspurhq.com/feed/"
                            }),
                    new TeamModel("Watford F.C.", "Watford, England", R.drawable.watford,
                            new String[]{
                                    "http://www.football365.com/watford/rss",
                                    "http://forzawatford.com/feed/"
                            }),
                    new TeamModel("West Bromwich Albion F.C.", "West Bromwich, England", R.drawable.westbrom,
                            new String[]{
                                    "http://www.football365.com/west-bromwich-albion/rss",
                                    "http://metro.co.uk/tag/west-bromwich-albion-fc/feed/",
                                    "http://www.expressandstar.com/comment-and-opinion/sport-blogs/albion-blog/feed/",
                                    "http://baggiesblog.co.uk/tag/west-brom/feed/"
                            }),
                    new TeamModel("West Ham United F.C.", "London, England", R.drawable.westham,
                            new String[]{
                                    "http://www.football365.com/west-ham/rss",
                                    "https://www.westhamtillidie.com/feed/",
                                    "http://foreverwestham.com/feed",
                                    "http://metro.co.uk/tag/west-ham-united-fc/feed/"
                            })

            };
    EnglandTeamsModel(String name)
    {
        this.name = name;
    }

}
