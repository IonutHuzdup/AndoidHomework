package com.example.firebasehw;

import android.app.Application;

import androidx.room.Room;

import com.example.firebasehw.data.BookDatabase;

public class ApplicationController extends Application {
    private static ApplicationController instance;
    private static BookDatabase bookDatabase;
    private final String bookDatabaseName = "BookDB";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setupDatabase();
    }

    private void setupDatabase(){
        bookDatabase = Room.databaseBuilder(getApplicationContext(),BookDatabase.class,bookDatabaseName).build();
    }

    public static BookDatabase getBookDatabase(){
        return bookDatabase;
    }

    public static ApplicationController getInstance(){
        return instance;
    }
}
