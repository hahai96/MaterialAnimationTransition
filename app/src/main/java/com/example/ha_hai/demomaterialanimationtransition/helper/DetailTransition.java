package com.example.ha_hai.demomaterialanimationtransition.helper;

import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;

/**
 * Created by ha_hai on 7/29/2018.
 */

public class DetailTransition extends TransitionSet {

    public DetailTransition() {
        setOrdering(ORDERING_TOGETHER);
        addTransition(new ChangeBounds())
                .addTransition(new ChangeTransform())
                .addTransition(new ChangeImageTransform());
    }
}
