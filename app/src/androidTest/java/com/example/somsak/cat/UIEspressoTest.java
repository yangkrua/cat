package com.example.somsak.cat;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by somsak on 7/12/16.
 */
@RunWith(AndroidJUnit4.class)
public class UIEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldDisplayCatName() {
        final String CATNAME = "somsak";

        onView(withId(R.id.etCatName)).check(matches(withText(CATNAME)));
    }
}
