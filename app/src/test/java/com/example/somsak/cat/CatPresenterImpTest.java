package com.example.somsak.cat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;

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
        /* Return a fake empty string for cat name */
        when(mMockCatViewContract.getCatColor()).thenReturn("blue");
        when(mMockCatViewContract.getCatName()).thenReturn("");

        /* Try and save the data */
        mCatPresenterContract.saveCatData();

        /* verify that getColor was called 1 time */
        verify(mMockCatViewContract, times(1)).getCatColor();
        /* verify that getName was called 1 time */
        verify(mMockCatViewContract, times(2)).getCatName();

        /* verify that on invalid input was called only once */
        verify(mMockCatViewContract, times(1)).onInvalidInput(anyString());

        /* verify that this was never called */
        verify(mMockCatViewContract, never()).onValidInput();
    }

    @Test
    public void shouldFailIfThereIsNoCatColor() throws Exception {
        /* Return a fake empty string for color */
        when(mMockCatViewContract.getCatColor()).thenReturn("");
        when(mMockCatViewContract.getCatName()).thenReturn("Somsack");

        /* Try and save the data */
        mCatPresenterContract.saveCatData();

        /* Verify that getcolor was called 2 times */
        verify(mMockCatViewContract, times(2)).getCatColor();
        /* Verify that getName was called 2 times */
        verify(mMockCatViewContract, times(2)).getCatName();

        /* verify that invalid input was called only once */
        verify(mMockCatViewContract, times(1)).onInvalidInput(anyString());

        /* Verify that this was never called */
        verify(mMockCatViewContract, never()).onValidInput();
    }

    @Test
    public void shouldFailIfThereIsNoColorAndName() throws Exception {
        /* Return a fake empty string for color */
        when(mMockCatViewContract.getCatColor()).thenReturn("");
        when(mMockCatViewContract.getCatName()).thenReturn("");

        /* Try and save the data */
        mCatPresenterContract.saveCatData();

        /* Verify that getcolor was called 2 times */
        verify(mMockCatViewContract, times(1)).getCatColor();
        /* Verify that getName was called 2 times */
        verify(mMockCatViewContract, times(2)).getCatName();

        /* verify that invalid input was called only once */
        verify(mMockCatViewContract, times(1)).onInvalidInput(anyString());

        /* Verify that this was never called */
        verify(mMockCatViewContract, never()).onValidInput();
    }

    @Test
    public void shouldSuccessIfValidColorAndName() throws Exception {
        /* Return a fake empty string for color */
        when(mMockCatViewContract.getCatColor()).thenReturn("blue");
        when(mMockCatViewContract.getCatName()).thenReturn("somsack");

        /* Try and save the data */
        mCatPresenterContract.saveCatData();

        /* Verify that getcolor was called 2 times */
        verify(mMockCatViewContract, times(2)).getCatColor();
        /* Verify that getName was called 2 times */
        verify(mMockCatViewContract, times(2)).getCatName();

        /* verify that invalid input was called only once */
        verify(mMockCatViewContract, never()).onInvalidInput(anyString());

        /* Verify that this was never called */
        verify(mMockCatViewContract, times(1)).onValidInput();
    }


}