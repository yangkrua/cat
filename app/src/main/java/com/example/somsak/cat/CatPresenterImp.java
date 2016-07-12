package com.example.somsak.cat;

import timber.log.Timber;

/**
 * Created by somsak on 7/5/16.
 */
public class CatPresenterImp implements
        CatPresenterContract.Operations<CatViewContract>,
        CatPresenterContract.Events {

    private CatViewContract mCatViewContract;

    /* Private constructor */
    private CatPresenterImp() {
    }

    /* Factory method */
    public static CatPresenterImp getNewInstance() {
        return new CatPresenterImp();
    }

    /* Operations */
    @Override
    public void attachView(CatViewContract view) {
        Timber.d("attachView");
        mCatViewContract = view;
    }

    @Override
    public void detachView() {
        Timber.d("detachView");

        mCatViewContract = null;
    }

    @Override
    public void saveCatData() {
        if(mCatViewContract.getCatName().isEmpty()) {
            mCatViewContract.onInvalidInput("No cat name was entered");
            Timber.e("saveCatData Name: %s Color: %s", mCatViewContract.getCatName(), mCatViewContract.getCatColor());
        }
        else if(mCatViewContract.getCatColor().isEmpty()) {
            mCatViewContract.onInvalidInput("No cat color was entered");
            Timber.e("saveCatData Name: %s Color: %s", mCatViewContract.getCatName(), mCatViewContract.getCatColor());
        }
        else {
            mCatViewContract.onValidInput();
            Timber.d("saveCatData Name: %s Color: %s", mCatViewContract.getCatName(), mCatViewContract.getCatColor());
        }
    }

    /* Events */
    @Override
    public void onSavedSuccess() {

    }

    @Override
    public void onSavedFailure() {

    }
}
