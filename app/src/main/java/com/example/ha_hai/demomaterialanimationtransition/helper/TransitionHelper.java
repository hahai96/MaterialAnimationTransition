package com.example.ha_hai.demomaterialanimationtransition.helper;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ha_hai on 7/21/2018.
 */

public class TransitionHelper {

    public static Pair<View, String>[] createSafeTransitionParticipants(Activity activity, boolean includeStatusBar, Pair... otherParticipants) {
        View decor = activity.getWindow().getDecorView();
        View statusBar = null;
        if (includeStatusBar) {
            statusBar = decor.findViewById(android.R.id.statusBarBackground);
        }
        View navBar = decor.findViewById(android.R.id.navigationBarBackground);

        List<Pair> participants = new ArrayList<>();
        addNonNullViewToTransitionParticipants(navBar, participants);
        addNonNullViewToTransitionParticipants(statusBar, participants);

        if (otherParticipants != null && !(otherParticipants.length == 1 && otherParticipants[0] == null)) {
            participants.addAll(Arrays.asList(otherParticipants));
        }
        return participants.toArray(new Pair[participants.size()]);
    }

    private static void addNonNullViewToTransitionParticipants(View view, List<Pair> participants) {
        if (view == null)
            return;

        participants.add(new Pair(view, view.getTransitionName()));
    }
}
