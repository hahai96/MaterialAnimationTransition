package com.example.ha_hai.demomaterialanimationtransition.model;

import android.databinding.BindingAdapter;
import android.graphics.PorterDuff;
import android.support.annotation.ColorRes;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by ha_hai on 7/21/2018.
 */

public class Sample implements Serializable{

    public int color;
    private String name;

    public Sample(int color, String name) {
        this.color = color;
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    @BindingAdapter("bind:colorTint")
    public static void setColorTint(ImageView view, @ColorRes int color) {
//        DrawableCompat.setTint(view.getDrawable(), color);
        view.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }
}
