package com.jonphilo.android.footballrumorcentral;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.jonphilo.android.footballrumorcentral.adapters.TeamRecyclerAdapter;
import com.jonphilo.android.footballrumorcentral.models.TeamModel;


public class EnglandTeamNewsFeed extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbar;
    RecyclerView recyclerView;
    int mutedColor = R.attr.colorPrimary;

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_england_team_news_feed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
