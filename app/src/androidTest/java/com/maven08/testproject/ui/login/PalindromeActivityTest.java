package com.maven08.testproject.ui.login;


import com.maven08.palindrome.R;
import com.maven08.palindrome.ui.main.PalindromeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class PalindromeActivityTest {

    @Rule
    public ActivityTestRule<PalindromeActivity> mActivityTestRule = new ActivityTestRule<>(PalindromeActivity.class);

    @Test
    public void loginActivityTest() {
        // Click is needed since we perform validation on lose focus
        onView(withId(R.id.txtText)).perform(click(), replaceText("asd@asd.com"));
        onView(withId(R.id.button)).check(matches(isEnabled()));
        onView(withId(R.id.button)).perform(click());
    }
}
