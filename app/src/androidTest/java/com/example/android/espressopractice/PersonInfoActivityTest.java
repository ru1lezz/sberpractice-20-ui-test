package com.example.android.espressopractice;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;

public class PersonInfoActivityTest {

    public void checkData() {
        Espresso.onView(ViewMatchers.withId(R.id.first_name_text_view)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.last_name_text_view)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.middle_name_text_view)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.first_name_text_view)).check(ViewAssertions.matches(ViewMatchers.withText(MainActivityTest.FIRST_NAME)));
        Espresso.onView(ViewMatchers.withId(R.id.last_name_text_view)).check(ViewAssertions.matches(ViewMatchers.withText(MainActivityTest.LAST_NAME)));
        Espresso.onView(ViewMatchers.withId(R.id.middle_name_text_view)).check(ViewAssertions.matches(ViewMatchers.withText(MainActivityTest.MIDDLE_NAME)));
    }
}
