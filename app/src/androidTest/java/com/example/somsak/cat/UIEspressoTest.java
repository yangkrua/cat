package com.example.somsak.cat;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
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
    public void shouldDisplayCatNameHint() {
        final String CAT_HINT_NAME = "Enter your cats name";
        onView(withHint(CAT_HINT_NAME)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldDisplayCatColorHint() {
        final String CAT_HINT_COLOR = "Enter your cats color";
        onView(withHint(CAT_HINT_COLOR)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldContainCatName() {
        final String CAT_NAME = "somsak";

        onView(withId(R.id.etCatName)).perform(typeText(CAT_NAME));
    }

    @Test
    public void shouldContainCatColor() {
        final String CAT_COLOR = "blue";
        onView(withId(R.id.etCatColor)).perform(typeText(CAT_COLOR));
    }

    @Test
    public void shouldPerformClick() {
        onView(withId(R.id.btnSubmit)).perform(click());
    }
}
