package com.jonphilo.android.footballrumorcentral;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jonphilo.android.footballrumorcentral.adapters.RSSRecyclerAdapter;
import com.jonphilo.android.footballrumorcentral.models.TeamModel;
import com.jonphilo.android.footballrumorcentral.xml.HandleXML;
import com.jonphilo.android.footballrumorcentral.xml.RSSItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EnglandTeamNewsFeed extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbar;
    RecyclerView recyclerView;
    int mutedColor = R.attr.colorPrimary;
    RSSRecyclerAdapter rssRecyclerAdapter;
    List<RSSItem> listData = new ArrayList<>();
    ProgressBar progressBar;
    int numberOfStories;
    int totalStories;
    Bitmap bitmap;

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

        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.eng_team_collapsing_toolbar);
        collapsingToolbar.setTitle(teamModel.GetTeamName());

        bitmap = BitmapFactory.decodeResource(getResources(), teamModel.GetPictureID());
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                mutedColor = palette.getMutedColor(R.attr.colorPrimary);
                collapsingToolbar.setContentScrimColor(mutedColor);
            }
        });

        AdView mAdView = (AdView) findViewById(R.id.adView_team);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        recyclerView = (RecyclerView) findViewById(R.id.eng_team_scrollableview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(rssRecyclerAdapter);

        numberOfStories = 0;
        totalStories = teamModel.RSS.length;
        for(String rss : teamModel.RSS)
        {
            GetRSSDataTask task = new GetRSSDataTask();
            task.execute(rss);
        }

        progressBar.setVisibility(ProgressBar.VISIBLE);

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!bitmap.isRecycled())
            bitmap.recycle();
    }

    private class GetRSSDataTask extends AsyncTask<String, Void, List<RSSItem>>{
        @Override
        protected List<RSSItem> doInBackground(String... urls)
        {
            List<RSSItem> items = new ArrayList<>();
            try{
                for(String rssItem : urls)
                {
                    HandleXML xmlHandler = new HandleXML(rssItem);
                    xmlHandler.fetchXML();
                    while(xmlHandler.parsingComplete)
                    {
                        Snackbar.make(recyclerView, "Loading", Snackbar.LENGTH_SHORT);
                    }
                    for(RSSItem item : xmlHandler.items)
                    {
                       items.add(item);
                    }
                }
                return items;
            }
            catch(Exception e)
            {
                Log.e("EnglandTeamNewsError", e.getMessage());
            }
            return null;
        }

        @Override
        protected  void onPostExecute(List<RSSItem> result){
            listData.addAll(result);
            Collections.sort(listData);


            if(rssRecyclerAdapter == null)
            {
                rssRecyclerAdapter = new RSSRecyclerAdapter(getApplicationContext(), listData);
                recyclerView.setAdapter(rssRecyclerAdapter);
                final RSSRecyclerAdapter.OnItemClickListener onClickListener = new RSSRecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int i) {
                    int itemPosition = recyclerView.getChildAdapterPosition(v);
                    RSSItem rssItem = listData.get(itemPosition);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(rssItem.getLink()));
                    startActivity(intent);
                    }
                };
                rssRecyclerAdapter.SetOnItemClickListener(onClickListener);

            }
            else
            {
                rssRecyclerAdapter.notifyDataSetChanged();
            }
            numberOfStories++;
            if(totalStories == numberOfStories)
            {
                progressBar.setVisibility(ProgressBar.INVISIBLE);
                Collections.sort(listData);
                rssRecyclerAdapter.notifyDataSetChanged();
            }

        }
    }
}
