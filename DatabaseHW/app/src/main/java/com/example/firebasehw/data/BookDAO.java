package com.example.firebasehw.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.firebasehw.models.entities.BookItem;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface BookDAO {
    @Query("SELECT * FROM bookItem")
    List<BookItem> getAll();

    @Insert
    void insertAll(BookItem...bookItem);

    @Insert
    void insertBook(BookItem bookItem);

    @Delete
    void delete(BookItem bookItem);
}
