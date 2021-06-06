package com.example.firebasehw.models.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class BookItem {
    @PrimaryKey
    public int id;
    @ColumnInfo(name="title")
    public String title;
    @ColumnInfo(name="author")
    public String author;
    @ColumnInfo(name="description")
    public String description;


    public BookItem(int id, String title, String author, String description){
        this.id = id;
        this.title = title;
        this.author = author;
        this.description =description;
    }
}
