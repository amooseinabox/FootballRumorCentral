package com.jonphilo.android.footballrumorcentral;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.jonphilo.android.footballrumorcentral.adapters.TeamRecyclerAdapter;
import com.jonphilo.android.footballrumorcentral.models.EnglandTeamsModel;
import com.jonphilo.android.footballrumorcentral.models.TeamModel;

import java.util.ArrayList;
import java.util.List;


public class EnglandNewsFeeds extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbar;
    RecyclerView recyclerView;
    int mutedColor = R.attr.colorPrimary;
    TeamRecyclerAdapter teamRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_england_news_feeds);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("England");

        ImageView header = (ImageView) findViewById(R.id.header);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thefa);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener()
        {
            @Override
            public void onGenerated(Palette palette)
            {
                mutedColor = palette.getMutedColor(R.attr.colorPrimary);
                collapsingToolbar.setContentScrimColor(mutedColor);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.scrollableview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<TeamModel> listData = new ArrayList<TeamModel>();
        for(int i = 0; i < EnglandTeamsModel.data.length; i++)
        {
            listData.add(EnglandTeamsModel.data[i]);
        }

        if(teamRecyclerAdapter == null)
        {
            teamRecyclerAdapter = new TeamRecyclerAdapter(getApplicationContext(), listData);
            recyclerView.setAdapter(teamRecyclerAdapter);
        }
        else
        {
            teamRecyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_england_news_feeds, menu);
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
