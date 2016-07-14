package com.example.somsak.cat;

import android.app.Application;

import com.example.somsak.cat.di.ApplicationComponent;
import com.example.somsak.cat.di.CatPresenterImpModule;
import com.example.somsak.cat.di.DaggerApplicationComponent;

import timber.log.Timber;

/**
 * Created by somsak on 7/5/16.
 */
public class CatApplication extends Application {
    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        applicationComponent = DaggerApplicationComponent
                .builder()
                .catPresenterImpModule(new CatPresenterImpModule())
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
