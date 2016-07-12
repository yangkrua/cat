package com.example.somsak.cat;

/**
 * Created by somsak on 7/5/16.
 */
public interface CatPresenterContract {
    /* Operations */
    interface Operations<V> {
        void attachView(V view);
        void detachView();
        void saveCatData();
    }

    /* Events */
    interface Events {
        void onSavedSuccess();
        void onSavedFailure();
    }
}
