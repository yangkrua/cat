package com.example.somsak.cat;

import android.widget.Button;
import android.widget.EditText;

import com.example.somsak.cat.supportutils.ViewLocator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.util.FragmentTestUtil;

import static com.example.somsak.cat.supportutils.ViewLocator.getButton;
import static com.example.somsak.cat.supportutils.ViewLocator.getEditText;
import static com.example.somsak.cat.supportutils.ViewLocator.getStringRes;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by somsak on 7/14/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CatViewRobolectricTest {
    private CatView mCatView;

    @Before
    public void setUp() throws Exception {
        mCatView = CatView.getNewInstance();
        FragmentTestUtil.startFragment(mCatView);
    }

    @After
    public void tearDown() throws Exception {
        mCatView = null;
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(mCatView);
    }

    @Test
    public void shouldDisplayCatColorAndCatNameHints() throws Exception {
        EditText etCatColor = getEditText(mCatView, R.id.etCatColor);
        assertNotNull(etCatColor);
        assertThat(etCatColor.getHint().toString(), equalTo(getStringRes(R.string.cat_color)));


        EditText etCatName = getEditText(mCatView, R.id.etCatName);
        assertNotNull(etCatName);
        assertThat(etCatName.getHint().toString(), equalTo(getStringRes(R.string.enter_your_cats_name)));
    }

    @Test
    public void shouldFailIfCatNameAndCatColorIsEmpty() throws Exception {
        Button btnSubmit = getButton(mCatView, R.id.btnSubmit);
        assertNotNull(btnSubmit);

        EditText etCatColor = getEditText(mCatView, R.id.etCatColor);
        assertNotNull(etCatColor);

        EditText etCatName = getEditText(mCatView, R.id.etCatName);
        assertNotNull(etCatName);

        btnSubmit.performClick();

        assertEquals(etCatColor.getText().toString(), "");
        assertEquals(etCatName.getText().toString(), "");
    }
}