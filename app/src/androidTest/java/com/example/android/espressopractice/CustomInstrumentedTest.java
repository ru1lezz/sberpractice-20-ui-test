package com.example.android.espressopractice;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CustomInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    @After
    public void truncateTable() {
        PersonApplication.getPersonDatabase().getPersonDao().truncateTable();
    }

    @Test
    public void useAppContext() {
        MainActivityTest mainActivityTest = new MainActivityTest();
        PersonsActivityTest personsActivityTest = mainActivityTest.submit();
        PersonInfoActivityTest personInfoActivityTest = personsActivityTest.clickOnItem();
        personInfoActivityTest.checkData();
    }
}
