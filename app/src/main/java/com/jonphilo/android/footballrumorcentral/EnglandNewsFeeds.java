package com.jonphilo.android.footballrumorcentral;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.jonphilo.android.footballrumorcentral.adapters.TeamRecyclerAdapter;
import com.jonphilo.android.footballrumorcentral.models.EnglandTeamsModel;
import com.jonphilo.android.footballrumorcentral.models.TeamModel;
import com.jonphilo.android.footballrumorcentral.xml.HandleXML;
import com.jonphilo.android.footballrumorcentral.xml.RSSItem;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
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

        try{
            Bitmap bitmap = getAssetBitmapImage(getApplicationContext(), "thefa");
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    mutedColor = palette.getMutedColor(R.attr.colorPrimary);
                    collapsingToolbar.setContentScrimColor(mutedColor);
                }
            });
        }
        catch (Exception e)
        {

        }

        recyclerView = (RecyclerView) findViewById(R.id.scrollableview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        final List<TeamModel> listData = new ArrayList<>();
        for(int i = 0; i < EnglandTeamsModel.data.length; i++)
        {
            listData.add(EnglandTeamsModel.data[i]);
        }

        if(teamRecyclerAdapter == null)
        {
            teamRecyclerAdapter = new TeamRecyclerAdapter(getApplicationContext(), listData);
            recyclerView.setAdapter(teamRecyclerAdapter);
            final TeamRecyclerAdapter.OnItemClickListener onClickListener = new TeamRecyclerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int i) {
                    int itemPosition = recyclerView.getChildAdapterPosition(v);
                    TeamModel teamModel = listData.get(itemPosition);

                    Intent intent = new Intent(getApplicationContext(), EnglandTeamNewsFeed.class);
                    intent.putExtra("teamObj", teamModel);
                    startActivity(intent);
                }
            };
            teamRecyclerAdapter.SetOnItemClickListener(onClickListener);

        }
        else
        {
            teamRecyclerAdapter.notifyDataSetChanged();
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

    public static Drawable getAssetImage(Context context, String filename) throws IOException {
        AssetManager assets = context.getResources().getAssets();
        InputStream buffer = new BufferedInputStream((assets.open("drawable/" + filename + ".png")));
        Bitmap bitmap = BitmapFactory.decodeStream(buffer);
        return new BitmapDrawable(context.getResources(), bitmap);
    }
    public static Bitmap getAssetBitmapImage(Context context, String filename) throws IOException {
        AssetManager assets = context.getResources().getAssets();
        InputStream buffer = new BufferedInputStream((assets.open("drawable/" + filename + ".png")));
        Bitmap bitmap = BitmapFactory.decodeStream(buffer);
        return bitmap;
    }
}
