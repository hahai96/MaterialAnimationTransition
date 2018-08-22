package com.example.ha_hai.demomaterialanimationtransition;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;

import com.example.ha_hai.demomaterialanimationtransition.databinding.ActivityShareElementsBinding;
import com.example.ha_hai.demomaterialanimationtransition.fragment.ShareElementsFragment1;
import com.example.ha_hai.demomaterialanimationtransition.model.Sample;

public class ShareElementsActivity extends HelperActivity {

    private Sample mSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindData();
        setUpWindowAnimations();
        setUpLayout();
        setUpToolbar();
    }

    private void bindData() {
        ActivityShareElementsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_share_elements);
        mSample = (Sample) getIntent().getSerializableExtra(HelperActivity.EXTRA_SAMPLE);
        binding.setSampleShareElementsActivity(mSample);
    }

    private void setUpWindowAnimations() {
        getWindow().getEnterTransition().setDuration(500);
    }

    private void setUpLayout() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(HelperActivity.EXTRA_SAMPLE, mSample);
        ShareElementsFragment1 shareElementsFragment1 = new ShareElementsFragment1();
        shareElementsFragment1.setArguments(bundle);

        // Transition for fragment1
        Slide slideTransition = new Slide(Gravity.LEFT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        // Create fragment and define some of it transitions
        shareElementsFragment1.setReenterTransition(slideTransition);
        shareElementsFragment1.setExitTransition(slideTransition);
        shareElementsFragment1.setSharedElementEnterTransition(new ChangeBounds());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contain_shareElementsActivity, shareElementsFragment1)
                .commit();
    }


}
