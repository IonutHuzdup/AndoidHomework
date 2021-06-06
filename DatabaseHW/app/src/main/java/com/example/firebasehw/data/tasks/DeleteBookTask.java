package com.example.firebasehw.data.tasks;

import android.os.AsyncTask;

import com.example.firebasehw.data.BookDatabase;
import com.example.firebasehw.data.BookRepositoryListener;
import com.example.firebasehw.models.entities.BookItem;

public class DeleteBookTask extends AsyncTask<BookItem,Void,Void> {
    private BookDatabase bookDatabase;
    private BookRepositoryListener listener;

    public DeleteBookTask(BookDatabase bookDatabase, BookRepositoryListener listener){
        this.bookDatabase = bookDatabase;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(BookItem... bookItems) {
        bookDatabase.bookDAO().delete(bookItems[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        listener.onSuccess();
    }
}
