package com.example.android.espressopractice;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

public class MainActivityTest {

    public static final String FIRST_NAME = "Sunggat";
    public static final String LAST_NAME = "Yerzhan";
    public static final String MIDDLE_NAME = "Yerbolzhanovich";

    public PersonsActivityTest submit() {
        Espresso.onView(ViewMatchers.withId(R.id.last_name_edit_text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.first_name_edit_text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.middle_name_edit_text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.submit_btn)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.last_name_edit_text)).perform(ViewActions.typeText(LAST_NAME));
        Espresso.onView(ViewMatchers.withId(R.id.last_name_edit_text)).perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.first_name_edit_text)).perform(ViewActions.typeText(FIRST_NAME));
        Espresso.onView(ViewMatchers.withId(R.id.first_name_edit_text)).perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.middle_name_edit_text)).perform(ViewActions.typeText(MIDDLE_NAME));
        Espresso.onView(ViewMatchers.withId(R.id.middle_name_edit_text)).perform(ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.submit_btn)).perform(ViewActions.click());

        return new PersonsActivityTest();
    }
}
