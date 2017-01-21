package com.deboxtream.mydrops.extras;

import android.view.View;

import java.util.List;

/**
 * Created by DROID on 20-01-2017.
 */

public class Util {
    public static void showViews(List<View> views){
        for(View view: views){
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void hideViews(List<View> views){
        for(View view: views){
            view.setVisibility(View.GONE);
        }
    }
}
