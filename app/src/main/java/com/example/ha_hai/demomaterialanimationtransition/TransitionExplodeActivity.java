package com.example.ha_hai.demomaterialanimationtransition;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.animation.Interpolator;

import com.example.ha_hai.demomaterialanimationtransition.databinding.ActivityTransitionExplodeAndSlideBinding;
import com.example.ha_hai.demomaterialanimationtransition.model.Sample;

public class TransitionExplodeActivity extends HelperActivity {

    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindData();
        setUpWindowAnimations();
        setUpLayout();
        setUpToolbar();
    }

    private void setUpLayout() {
        findViewById(R.id.btnExitExplodeAndSlide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });
    }

    private void setUpWindowAnimations() {

        Transition transition = null;
        if (type == HelperActivity.TYPE_PROGRAMMATICALLY)
            transition = buildWindowAnimations();
        else if (type == HelperActivity.TYPE_XML)
            transition = TransitionInflater.from(this).inflateTransition(R.transition.transition_explode_xml);

        getWindow().setEnterTransition(transition);
    }

    private void bindData() {
        ActivityTransitionExplodeAndSlideBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_transition_explode_and_slide);
        Intent intent = getIntent();
        Sample sample = (Sample) intent.getSerializableExtra(HelperActivity.EXTRA_SAMPLE);
        type = intent.getIntExtra(HelperActivity.EXTRA_TYPE, 0);
        binding.setTransitionsExplodeCodeSample(sample);
    }

    private Transition buildWindowAnimations() {
        Explode explode = new Explode();
        explode.setDuration(500);
        return explode;
    }
}
