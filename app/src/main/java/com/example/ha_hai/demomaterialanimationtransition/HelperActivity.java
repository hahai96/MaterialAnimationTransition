package com.example.ha_hai.demomaterialanimationtransition;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ha_hai.demomaterialanimationtransition.helper.TransitionHelper;
import com.example.ha_hai.demomaterialanimationtransition.model.Sample;

public class HelperActivity extends AppCompatActivity {

    public static final String EXTRA_SAMPLE = "sample";
    public static final String EXTRA_TYPE = "type";
    public static final int TYPE_PROGRAMMATICALLY = 0;
    public static final int TYPE_XML = 1;

    public void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarTransitions);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void transitionToActivity(Intent i, Sample sample) {
        Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, false, null);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(i, optionsCompat.toBundle());
    }
}
