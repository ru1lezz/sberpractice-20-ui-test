package com.example.android.espressopractice.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = Person.class, version = 1)
public abstract class PersonDatabase extends RoomDatabase {

    public abstract PersonDAO getPersonDao();
}
