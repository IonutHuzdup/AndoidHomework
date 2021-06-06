package com.example.firebasehw.data;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.firebasehw.models.entities.BookItem;

import org.jetbrains.annotations.NotNull;

@Database(entities = {BookItem.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {
    @NonNull
    @NotNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @NotNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }

    public abstract BookDAO bookDAO();
}
