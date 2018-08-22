package com.example.ha_hai.demomaterialanimationtransition;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import com.example.ha_hai.demomaterialanimationtransition.databinding.ActivityTransitionBinding;
import com.example.ha_hai.demomaterialanimationtransition.model.Sample;

public class TransitionActivity extends HelperActivity {

    private Sample mSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindData();
        setUpWinDowAnimations();
        setUpLayout();
        setUpToolbar();
    }

    private void setUpLayout() {
        findViewById(R.id.btnExplodeCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransitionActivity.this, TransitionExplodeActivity.class);
                intent.putExtra(HelperActivity.EXTRA_SAMPLE, mSample);
                intent.putExtra(HelperActivity.EXTRA_TYPE, HelperActivity.TYPE_PROGRAMMATICALLY);
                transitionToActivity(intent, mSample);
            }
        });

        findViewById(R.id.btnExplodeXML).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransitionActivity.this, TransitionExplodeActivity.class);
                intent.putExtra(HelperActivity.EXTRA_SAMPLE, mSample);
                intent.putExtra(HelperActivity.EXTRA_TYPE, HelperActivity.TYPE_XML);
                transitionToActivity(intent, mSample);
            }
        });

        findViewById(R.id.btnSlideCode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransitionActivity.this, TransitionSlideActivity.class);
                intent.putExtra(HelperActivity.EXTRA_SAMPLE, mSample);
                intent.putExtra(HelperActivity.EXTRA_TYPE, HelperActivity.TYPE_PROGRAMMATICALLY);
                transitionToActivity(intent, mSample);
            }
        });

        findViewById(R.id.btnSlideXML).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransitionActivity.this, TransitionSlideActivity.class);
                intent.putExtra(HelperActivity.EXTRA_SAMPLE, mSample);
                intent.putExtra(HelperActivity.EXTRA_TYPE, HelperActivity.TYPE_XML);
                transitionToActivity(intent, mSample);
            }
        });

        findViewById(R.id.btnExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });

        findViewById(R.id.btnExitOverridingReturnTransition).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Slide slide = new Slide(Gravity.BOTTOM);
                slide.setDuration(500);
                getWindow().setReturnTransition(slide);

                finishAfterTransition();
            }
        });
    }

    private void bindData() {
        ActivityTransitionBinding transitionBinding = DataBindingUtil.setContentView(this, R.layout.activity_transition);
        mSample = (Sample) getIntent().getSerializableExtra("sample");
        transitionBinding.setTransitionsSample(mSample);
    }

    private void setUpWinDowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(500);
        getWindow().setEnterTransition(fade);
    }
}
