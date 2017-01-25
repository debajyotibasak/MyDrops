package com.deboxtream.mydrops;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.deboxtream.mydrops.adapters.Filters;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by DROID on 20-01-2017.
 */

public class AppBucketDrops extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this); //new update
        RealmConfiguration configuration = new RealmConfiguration.Builder().build(); //new update
        Realm.setDefaultConfiguration(configuration);
    }

    public static void save(Context context, int filterOption){

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("filter", filterOption);
        editor.apply();
    }

    public static int load(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        int filterOption = pref.getInt("filter", Filters.NONE);
        return filterOption;
    }

    public static void setRobotoRegular(Context context, TextView textView) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_regular.ttf");
        textView.setTypeface(typeface);
    }

    public static void setRobotoRegular(Context context, TextView... textViews) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_regular.ttf");
        for (TextView textView : textViews) {
            textView.setTypeface(typeface);
        }
    }
}
