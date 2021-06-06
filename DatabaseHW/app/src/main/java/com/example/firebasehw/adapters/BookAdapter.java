package com.example.firebasehw.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasehw.R;
import com.example.firebasehw.models.Book;
import com.example.firebasehw.interfaces.OnCellClick;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private ArrayList<Book> books;
    private OnCellClick click;

    public BookAdapter(ArrayList<Book> books, OnCellClick click) {
        this.books = books;
        this.click = click;
    }

    @NonNull
    @NotNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.book_cell, parent, false);

        BookViewHolder bookViewHolder = new BookViewHolder(view);
        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BookAdapter.BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textAuthor;
        private TextView textDescription;
        private View view;

        public BookViewHolder(View view) {
            super(view);
            textTitle = view.findViewById(R.id.text_title);
            textAuthor = view.findViewById(R.id.text_author);
            textDescription = view.findViewById(R.id.text_description);
        }

        public void bind(Book book) {
            textTitle.setText(book.getTitle());
            textAuthor.setText(book.getAuthor());
            textDescription.setText(book.getDescription());
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(click!=null){
//                        click.onClick(book);
//                    }
//                }
//            });
        }
    }
}
