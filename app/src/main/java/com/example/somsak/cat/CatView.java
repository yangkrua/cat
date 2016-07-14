package com.example.somsak.cat;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatView extends Fragment implements CatViewContract {
    private static String TAG = CatView.class.getSimpleName();

    @BindView(R.id.etCatName) EditText mEtCatName;
    @BindView(R.id.etCatColor) EditText mEtCatColor;

    // private CatPresenterContract.Operations<CatViewContract> mCatPresenterContract;

   // @Inject CatPresenterContract.Operations<CatViewContract> mCatPresenterContract;

    @Inject CatPresenterImp mCatPresenterContract;

    public CatView() {
        // Required empty public constructor
    }

    /* Factory method pattern */
    public static CatView getNewInstance() {
        return new CatView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Timber.d("onCreateView");

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.cat_view, container, false);

        ButterKnife.bind(CatView.this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Timber.d("onActivityCreated");

        CatApplication.getApplicationComponent().inject(CatView.this);
        if(mCatPresenterContract != null) {
            /* Attach view */
            mCatPresenterContract.attachView(CatView.this);
            Timber.d("mCatPresenterContract != null - OK");
        }
        else {
            Timber.e("Failed to inject CatPresenterImp");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mCatPresenterContract.detachView();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btnSubmit)
    public void submitCat() {
        mCatPresenterContract.saveCatData();
    }

    @Override
    public String getCatName() {
        Timber.d("getCatName: %s", mEtCatName.getText().toString());

        return mEtCatName.getText().toString();
    }

    @Override
    public String getCatColor() {
        Timber.d("getCatColor: %s", mEtCatColor.getText().toString());

        return mEtCatColor.getText().toString();
    }

    @Override
    public void onInvalidInput(String errMessage) {
        Toast.makeText(getActivity(), "Failed to get information: " + errMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onValidInput() {
        Toast.makeText(getActivity(), "Valid information", Toast.LENGTH_LONG).show();
    }
}
