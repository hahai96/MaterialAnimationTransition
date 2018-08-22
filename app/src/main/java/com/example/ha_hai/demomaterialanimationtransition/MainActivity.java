package com.example.ha_hai.demomaterialanimationtransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;

import com.example.ha_hai.demomaterialanimationtransition.adapter.SamplesRecyclerAdapter;
import com.example.ha_hai.demomaterialanimationtransition.model.Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Sample> mSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpWinDowAnimations();
        setUpToolBar();
        setUpSamples();
        setUpLayout();
    }

    private void setUpWinDowAnimations() {
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void setUpSamples() {
        mSamples = Arrays.asList(
                new Sample(R.color.sample_red, "Transitions"),
                new Sample(R.color.sample_blue, "Shared Elements"),
                new Sample(R.color.sample_green, "View animations"),
                new Sample(R.color.sample_yellow, "Circular Reveal Animation")
        );
    }

    private void setUpLayout() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        SamplesRecyclerAdapter adapter = new SamplesRecyclerAdapter(this, mSamples);
        recyclerView.setAdapter(adapter);
    }


}
