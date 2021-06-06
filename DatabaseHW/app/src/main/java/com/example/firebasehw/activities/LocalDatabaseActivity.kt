package com.example.firebasehw.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasehw.R
import com.example.firebasehw.adapters.BookAdapter
import com.example.firebasehw.data.BookRepository
import com.example.firebasehw.interfaces.OnCellClick
import com.example.firebasehw.models.Book
import com.example.firebasehw.models.entities.BookItem
import java.lang.Exception
import java.lang.reflect.Executable

class LocalDatabaseActivity : AppCompatActivity() {
    private var button: Button? = null
    private var deleteButton: Button?=null
    private var editTextTitle: EditText? = null
    private val bookRepository = BookRepository()

    private var editTextAuthor: EditText? = null
    private var editTextDescription: EditText? = null

    private val books:ArrayList<Book> = ArrayList()
    private var adapter: BookAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_database)

        setupViews()
        //setupRecyclerView()
    }

    fun setupViews() {
        button = findViewById(R.id.button)
        editTextTitle = findViewById(R.id.title)
        editTextAuthor = findViewById(R.id.author)
        editTextDescription = findViewById(R.id.description)

        button?.setOnClickListener {
            insertBook()
           // add()
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        }
        setupRecyclerView()

    }

    fun insertBook() {
        val title = editTextTitle?.text?.toString() ?: return
        val author = editTextAuthor?.text?.toString() ?: return
        val description = editTextDescription?.text?.toString() ?: return
        when (title.isEmpty()) {
            true -> return
        }
        when (author.isEmpty()) {
            true -> return
        }
        when (description.isEmpty()) {
            true -> return
        }

        val bookItem = BookItem((0..100).random(), title, author, description)

        bookRepository.insertBook(bookItem) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteBook(){
        Toast.makeText(this, "Delete success", Toast.LENGTH_SHORT).show()
    }

    fun setupRecyclerView(){

        val recyclerView = findViewById<RecyclerView>(R.id.fragment_recycler_view)
        val layoutManager: LinearLayoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager =layoutManager
        recyclerView.isNestedScrollingEnabled = false
        books.add(Book("Titles","Authors","Descriptions"))
        books.add(Book("Titles","Authors","Descriptions"))
        books.add(Book("Titles","Authors","Descriptions"))
        books.add(Book("Titles","Authors","Descriptions"))

        adapter = BookAdapter(books, OnCellClick{
            book->Toast.makeText(this, "${book.title} ${book.author}", Toast.LENGTH_SHORT).show()
        })
        deleteButton = findViewById(R.id.delete_button)
        deleteButton?.setOnClickListener {
            deleteBook()
            //Toast.makeText(this, "Delete success", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter

    }

    fun add(){
        try{
        var title = findViewById<TextView>(R.id.text_title).setText(editTextTitle.toString()).toString()
        var author = findViewById<TextView>(R.id.text_author).setText(editTextAuthor.toString()).toString()
        var description = findViewById<TextView>(R.id.text_description).setText(editTextDescription.toString()).toString()
        books.add(Book(title,author,description))}
        catch (exception:Exception){
            Toast.makeText(this,"Fields empty",Toast.LENGTH_SHORT).show()
        }
    }
}