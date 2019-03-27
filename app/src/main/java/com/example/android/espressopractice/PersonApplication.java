package com.example.android.espressopractice;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.android.espressopractice.db.PersonDatabase;

import static android.arch.persistence.room.Room.*;

public class PersonApplication extends Application {

    private static String DB_NAME = "person_db";
    private static PersonDatabase personDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        personDatabase = databaseBuilder(getApplicationContext(), PersonDatabase.class, DB_NAME).build();
    }

    public static PersonDatabase getPersonDatabase() {
        return personDatabase;
    }
}
