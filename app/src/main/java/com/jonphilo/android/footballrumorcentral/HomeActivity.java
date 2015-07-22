package com.jonphilo.android.footballrumorcentral;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.jonphilo.android.footballrumorcentral.adapters.RSSRecyclerAdapter;
import com.jonphilo.android.footballrumorcentral.models.MainRSSLists;
import com.jonphilo.android.footballrumorcentral.xml.HandleXML;
import com.jonphilo.android.footballrumorcentral.xml.RSSItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    RecyclerView mRecyclerView;
    Intent intent;
    RSSRecyclerAdapter rssRecyclerAdapter;
    List<RSSItem> listData = new ArrayList<>();
    ProgressBar progressBar;
    int numberOfStories;
    int totalStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpToolBar();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer);
        setUpNavDrawer();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.nav_scrollableview);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_england:
                        intent = new Intent(HomeActivity.this, EnglandNewsFeeds.class);
                        startActivity(intent);
                        return true;
//                    case R.id.nav_spain:
//                        Snackbar.make(mRecyclerView, "Spain", Snackbar.LENGTH_SHORT).show();
//                        return true;
                    default:
                        return true;
                }
            }
        });

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(rssRecyclerAdapter);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_main);
        totalStories = MainRSSLists.RSSFeeds.length;
        numberOfStories = 0;
        for(String rss : MainRSSLists.RSSFeeds)
        {
            GetRSSDataTask task = new GetRSSDataTask();
            task.execute(rss);
        }
        progressBar.setVisibility(ProgressBar.VISIBLE);
//
//        int i = 0;
//        i++;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    private void setUpToolBar()
    {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if(mToolbar != null){
            setSupportActionBar(mToolbar);
        }
    }

    private void setUpNavDrawer()
    {
        if(mToolbar != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationIcon(R.drawable.ic_drawer);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }
    }

    private class GetRSSDataTask extends AsyncTask<String, Void, List<RSSItem>> {
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
                        Snackbar.make(mRecyclerView, "Loading", Snackbar.LENGTH_SHORT);
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
                mRecyclerView.setAdapter(rssRecyclerAdapter);
                final RSSRecyclerAdapter.OnItemClickListener onClickListener = new RSSRecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int i) {
                        int itemPosition = mRecyclerView.getChildAdapterPosition(v);
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
