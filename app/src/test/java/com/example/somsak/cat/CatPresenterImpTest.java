package com.example.somsak.cat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by somsak on 7/5/16.
 */
public class CatPresenterImpTest {

    private CatPresenterContract.Operations<CatViewContract> mCatPresenterContract;
    private CatViewContract mMockCatViewContract;

    @Before
    public void setUp() throws Exception {
        mCatPresenterContract = CatPresenterImp.getNewInstance();
        mMockCatViewContract = mock(CatView.class);

        mCatPresenterContract.attachView(mMockCatViewContract);
    }

    @After
    public void tearDown() throws Exception {
        mCatPresenterContract.detachView();
        mMockCatViewContract = null;
        mCatPresenterContract = null;
    }

    @Test
    public void shouldFailIfThereIsNoCatName() throws Exception {
        /* Return a fake empty string for cat color */
        when(mMockCatViewContract.getCatColor()).thenReturn("");
        when(mMockCatViewContract.getCatName()).thenReturn("blue");

        /* Try and save the data */
        mCatPresenterContract.saveCatData();

        /* verify that getColor was called 1 time */
        verify(mMockCatViewContract, times(2)).getCatColor();
        /* verify that getName was called 1 time */
        verify(mMockCatViewContract, times(2)).getCatName();

        /* verify that on invalid input was called only once */
        verify(mMockCatViewContract, times(1)).onInvalidInput(anyString());

        /* verify that this was never called */
        verify(mMockCatViewContract, never()).onValidInput();
    }
}