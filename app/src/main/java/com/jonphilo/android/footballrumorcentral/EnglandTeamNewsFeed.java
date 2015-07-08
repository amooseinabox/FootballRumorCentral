package com.jonphilo.android.footballrumorcentral;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.jonphilo.android.footballrumorcentral.adapters.RSSRecyclerAdapter;
import com.jonphilo.android.footballrumorcentral.adapters.TeamRecyclerAdapter;
import com.jonphilo.android.footballrumorcentral.models.EnglandTeamsModel;
import com.jonphilo.android.footballrumorcentral.models.TeamModel;
import com.jonphilo.android.footballrumorcentral.xml.HandleXML;
import com.jonphilo.android.footballrumorcentral.xml.RSSItem;

import java.util.ArrayList;
import java.util.List;


public class EnglandTeamNewsFeed extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbar;
    RecyclerView recyclerView;
    int mutedColor = R.attr.colorPrimary;
    RSSRecyclerAdapter rssRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_england_team_news_feed);
        Intent intent = getIntent();
        TeamModel teamModel = (TeamModel) intent.getSerializableExtra("teamObj");

        final ImageView image = (ImageView) findViewById(R.id.eng_team_header);
        image.setImageDrawable(getApplicationContext().getDrawable(teamModel.GetPictureID()));

        final Toolbar toolbar = (Toolbar) findViewById(R.id.eng_team_anim_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.eng_team_collapsing_toolbar);
        collapsingToolbar.setTitle(teamModel.GetTeamName());

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), teamModel.GetPictureID());
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                mutedColor = palette.getMutedColor(R.attr.colorPrimary);
                collapsingToolbar.setContentScrimColor(mutedColor);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.eng_team_scrollableview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        final List<RSSItem> listData = new ArrayList<>();

        for(RSSItem rss : teamModel.RSSItems)
        {
            listData.add(rss);
        }

        if(rssRecyclerAdapter == null)
        {
            rssRecyclerAdapter = new RSSRecyclerAdapter(getApplicationContext(), listData);
            recyclerView.setAdapter(rssRecyclerAdapter);
            final RSSRecyclerAdapter.OnItemClickListener onClickListener = new RSSRecyclerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int i) {
//                    int itemPosition = recyclerView.getChildAdapterPosition(v);
//                    R teamModel = listData.get(itemPosition);
//                    Intent intent = new Intent(getApplicationContext(), EnglandTeamNewsFeed.class);
//                    intent.putExtra("teamObj", teamModel);
//                    startActivity(intent);
                }
            };
            rssRecyclerAdapter.SetOnItemClickListener(onClickListener);

        }
        else
        {
            rssRecyclerAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
