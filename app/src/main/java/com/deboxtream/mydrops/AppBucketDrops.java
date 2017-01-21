package com.deboxtream.mydrops;

import android.app.Application;

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
}
