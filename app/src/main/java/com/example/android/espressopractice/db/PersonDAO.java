package com.example.android.espressopractice.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public abstract class PersonDAO {

    @Query("select * from person")
    public abstract List<Person> getPersonList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(Person person);

    @Query("delete from person")
    public abstract void truncateTable();
}
