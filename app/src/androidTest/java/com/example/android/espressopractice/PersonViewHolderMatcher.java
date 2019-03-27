package com.example.android.espressopractice;

import android.support.v7.widget.RecyclerView;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class PersonViewHolderMatcher extends TypeSafeMatcher<RecyclerView.ViewHolder> {
    @Override
    protected boolean matchesSafely(RecyclerView.ViewHolder item) {
        PersonAdapter.PersonViewHolder holder = (PersonAdapter.PersonViewHolder) item;
        boolean isCorrectFirstName = holder.getFirstName().equals(MainActivityTest.FIRST_NAME);
        boolean isCorrectLastName = holder.getLastName().equals(MainActivityTest.LAST_NAME);
        boolean isCorrectMiddleName = holder.getMiddleName().equals(MainActivityTest.MIDDLE_NAME);

        return isCorrectFirstName && isCorrectLastName && isCorrectMiddleName;
    }

    @Override
    public void describeTo(Description description) {

    }
}
