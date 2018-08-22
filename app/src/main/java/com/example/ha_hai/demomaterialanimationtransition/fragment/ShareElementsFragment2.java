package com.example.ha_hai.demomaterialanimationtransition.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.transition.ChangeBounds;
import android.transition.Fade;
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
public class ShareElementsFragment2 extends Fragment {


    public ShareElementsFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share_elemets_fragment2, container, false);
        final Sample mSample = (Sample) getArguments().getSerializable(HelperActivity.EXTRA_SAMPLE);

        final ImageView imgIconShareElements2 = view.findViewById(R.id.imgIconShareElements2);
        imgIconShareElements2.setColorFilter(ContextCompat.getColor(getActivity(), mSample.getColor()), android.graphics.PorterDuff.Mode.SRC_IN);

        return view;
    }
}
