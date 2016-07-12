package com.example.somsak.cat;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by somsak on 7/5/16.
 */
public class CatApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
