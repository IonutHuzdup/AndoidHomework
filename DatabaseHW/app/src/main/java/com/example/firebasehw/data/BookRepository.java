package com.example.firebasehw.data;

import com.example.firebasehw.ApplicationController;
import com.example.firebasehw.data.tasks.DeleteBookTask;
import com.example.firebasehw.data.tasks.GetAllBooksTask;
import com.example.firebasehw.data.tasks.InsertBookTask;
import com.example.firebasehw.models.entities.BookItem;

public class BookRepository {
    private BookDatabase bookDatabase;

    public BookRepository() {
        bookDatabase = ApplicationController.getBookDatabase();
    }

    public void insertBook(BookItem bookItem, BookRepositoryListener listener) {
        new InsertBookTask(bookDatabase, listener).execute(bookItem);
    }

    public void deleteBook(BookItem bookItem, BookRepositoryListener listener){
        new DeleteBookTask(bookDatabase,listener).execute(bookItem);
    }

    public void getAllBooks(BookRepositoryListener listener) {
        new GetAllBooksTask(bookDatabase, listener).execute();
    }
}
