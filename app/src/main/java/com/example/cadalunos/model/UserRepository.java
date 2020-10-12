package com.example.cadalunos.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

public class UserRepository {
    private UserDao userDao;
    private LiveData<User> user;
   UserRepository(Application application) {
       StudentRoomDatabase db = StudentRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        user = userDao.getUser();
    }
    LiveData<User> getUser() {
        return user;
    }
    void insert(User user) {
        StudentRoomDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }
}