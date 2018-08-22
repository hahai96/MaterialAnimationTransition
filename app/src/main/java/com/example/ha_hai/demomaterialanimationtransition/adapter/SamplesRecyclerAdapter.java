package com.example.ha_hai.demomaterialanimationtransition.adapter;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ha_hai.demomaterialanimationtransition.CircularRevealActivity;
import com.example.ha_hai.demomaterialanimationtransition.R;
import com.example.ha_hai.demomaterialanimationtransition.ShareElementsActivity;
import com.example.ha_hai.demomaterialanimationtransition.TransitionActivity;
import com.example.ha_hai.demomaterialanimationtransition.databinding.RowSampleBinding;
import com.example.ha_hai.demomaterialanimationtransition.helper.TransitionHelper;
import com.example.ha_hai.demomaterialanimationtransition.model.Sample;

import java.util.List;

/**
 * Created by ha_hai on 7/21/2018.
 */

public class SamplesRecyclerAdapter extends RecyclerView.Adapter<SamplesRecyclerAdapter.MyHolder> {

    private Activity mActivity;
    private List<Sample> mSamples;

    public SamplesRecyclerAdapter(Activity activity, List<Sample> samples) {
        this.mActivity = activity;
        this.mSamples = samples;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowSampleBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mActivity), R.layout.row_sample, parent, false);
        return new MyHolder(binding);
    }

    @Override
    public void onBindViewHolder(final MyHolder viewHolder, int position) {
        final Sample sample = mSamples.get(viewHolder.getAdapterPosition());
        Log.d("AAA", "color: " + sample.getColor() + " - name: " + sample.getName());
        viewHolder.binding.setSample(sample);
        viewHolder.binding.imgIcon.setColorFilter(ContextCompat.getColor(mActivity, sample.getColor()), android.graphics.PorterDuff.Mode.SRC_IN);
        viewHolder.binding.sampleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (viewHolder.getAdapterPosition()) {
                    case 0:
                        transitionToActivity(TransitionActivity.class, sample);
                        break;
                    case 1:
                        transitionToActivity(ShareElementsActivity.class, viewHolder, sample);
                        break;
                    case 2:
                        break;
                    case 3:
                        transitionToActivity(CircularRevealActivity.class, viewHolder, sample, false);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSamples.size();
    }

    private void transitionToActivity(Class targetClass, MyHolder viewHolder, Sample sample) {
        Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(mActivity, true,
                Pair.create((View) viewHolder.binding.imgIcon, mActivity.getString(R.string.share_img_activity)),
                Pair.create((View) viewHolder.binding.txtName, mActivity.getString(R.string.share_text_label_activity)));
        startActivity(targetClass, pairs, sample);
    }

    private void transitionToActivity(Class targetClass, MyHolder viewHolder, Sample sample, boolean includeStatusBar) {
        Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(mActivity, false,
                Pair.create((View) viewHolder.binding.imgIcon, mActivity.getString(R.string.share_img_from_activity_to_circular_fragment)));
        startActivity(targetClass, pairs, sample);
    }

    private void transitionToActivity(Class targetClass, Sample sample) {
        Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(mActivity, true, null);
        startActivity(targetClass, pairs, sample);
    }

    private void startActivity(Class targetClass, Pair<View, String>[] pairs, Sample sample) {
        Intent intent = new Intent(mActivity, targetClass);
        intent.putExtra("sample", sample);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, pairs);
        mActivity.startActivity(intent, optionsCompat.toBundle());
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        private RowSampleBinding binding;

        public MyHolder(RowSampleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
