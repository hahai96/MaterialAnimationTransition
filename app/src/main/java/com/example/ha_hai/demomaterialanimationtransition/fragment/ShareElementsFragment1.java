package com.example.ha_hai.demomaterialanimationtransition.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ha_hai.demomaterialanimationtransition.HelperActivity;
import com.example.ha_hai.demomaterialanimationtransition.R;
import com.example.ha_hai.demomaterialanimationtransition.model.Sample;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareElementsFragment1 extends Fragment {

    public ShareElementsFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share_elements_fragment1, container, false);
        final Sample mSample = (Sample) getArguments().getSerializable(HelperActivity.EXTRA_SAMPLE);

        final ImageView imgIconShareElements1 = view.findViewById(R.id.imgIconShareElements1);
        imgIconShareElements1.setColorFilter(ContextCompat.getColor(getActivity(), mSample.getColor()), android.graphics.PorterDuff.Mode.SRC_IN);

        view.findViewById(R.id.btnNextOverLapFalse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNextFragment(mSample, imgIconShareElements1, false);
            }
        });

        view.findViewById(R.id.btnNextOverLapTrue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNextFragment(mSample, imgIconShareElements1, true);
            }
        });

        return view;
    }

    private void addNextFragment(Sample mSample, ImageView imgIconShareElements1, boolean isOverlap) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(HelperActivity.EXTRA_SAMPLE, mSample);
        ShareElementsFragment2 shareElementsFragment2 = new ShareElementsFragment2();
        shareElementsFragment2.setArguments(bundle);

        Slide slide = new Slide(Gravity.RIGHT);
        slide.setDuration(300);

        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(300);

        shareElementsFragment2.setEnterTransition(slide);
        shareElementsFragment2.setAllowEnterTransitionOverlap(isOverlap);
        shareElementsFragment2.setAllowReturnTransitionOverlap(isOverlap);
        shareElementsFragment2.setSharedElementEnterTransition(changeBounds);

        getFragmentManager().beginTransaction()
                .replace(R.id.contain_shareElementsActivity, shareElementsFragment2)
                .addToBackStack(null)
                .addSharedElement(imgIconShareElements1, getString(R.string.share_img_between_two_fragments))
                .commit();
    }

}
