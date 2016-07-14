package com.example.somsak.cat.di;

import com.example.somsak.cat.CatPresenterImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by somsak on 7/13/16.
 */
@Module
public class CatPresenterImpModule {
    @Provides @Singleton
    public CatPresenterImp providesCatPresenterImp() {
        return new CatPresenterImp();
    }
}
