package com.example.firebasehw.data.tasks;

import android.os.AsyncTask;

import com.example.firebasehw.data.BookDatabase;
import com.example.firebasehw.data.BookRepositoryListener;
import com.example.firebasehw.models.entities.BookItem;

import java.util.List;

public class GetAllBooksTask extends AsyncTask<Void, Void, List<BookItem>>{
    private BookDatabase bookDatabase;
    private BookRepositoryListener listener;

    public GetAllBooksTask(BookDatabase bookDatabase, BookRepositoryListener listener) {
        this.bookDatabase = bookDatabase;
        this.listener = listener;
    }

    @Override
    protected List<BookItem> doInBackground(Void... voids) {
        return bookDatabase.bookDAO().getAll();
    }

    @Override
    protected void onPostExecute(List<BookItem> bookItem) {
        super.onPostExecute(bookItem);
        listener.onSuccess();
    }
}
