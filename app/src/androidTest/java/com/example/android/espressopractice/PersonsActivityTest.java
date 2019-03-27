package com.example.android.espressopractice;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;

public class PersonsActivityTest {

    public PersonsActivityTest() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    public PersonInfoActivityTest clickOnItem () {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnHolderItem(new PersonViewHolderMatcher(), ViewActions.click()));
        return new PersonInfoActivityTest();
    }
}
