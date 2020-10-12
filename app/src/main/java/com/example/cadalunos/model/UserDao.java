package com.example.cadalunos.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public abstract class UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(User user);

    @Query("DELETE FROM user")
    public abstract void deleteAll();

    @Query("SELECT * from user LIMIT 1")
    public abstract LiveData<User> getUser();

}