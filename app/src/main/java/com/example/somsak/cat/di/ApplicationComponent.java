package com.example.somsak.cat.di;

import com.example.somsak.cat.CatView;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by somsak on 7/13/16.
 */
@Singleton
@Component(modules=CatPresenterImpModule.class)
public interface ApplicationComponent {
    void inject(CatView target);
}
