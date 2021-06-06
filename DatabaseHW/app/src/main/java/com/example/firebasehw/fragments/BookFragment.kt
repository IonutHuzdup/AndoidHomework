package com.example.firebasehw.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasehw.R
import com.example.firebasehw.adapters.BookAdapter
import com.example.firebasehw.data.BookRepository
import com.example.firebasehw.interfaces.OnCellClick
import com.example.firebasehw.models.Book
import com.example.firebasehw.models.entities.BookItem

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BookFragment : Fragment(), OnCellClick {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView:RecyclerView
    private var adapter:BookAdapter?=null

    private var button: Button?= null
    private var editTextTitle: EditText?=null
    private var editTextAuthor: EditText?=null
    private var editTextDescription: EditText?=null

    private val bookRepository = BookRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        setupViews()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var books:ArrayList<Book> = ArrayList()
        var view:View =inflater.inflate(R.layout.fragment_book, container, false)
        recyclerView = view.findViewById(R.id.fragment_recycler_view)
        adapter = BookAdapter(books,this)
        var linearLayout = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayout
        books.add(Book("asd","asd","asd"))
        books.add(Book("asd","asd","asd"))
        books.add(Book("asd","asd","asd"))
        books.add(Book("asd","asd","asd"))
        books.add(Book("asd","asd","asd"))
        books.add(Book("asd","asd","asd"))
        books.add(Book("asd","asd","asd"))
        books.add(Book("asd","asd","asd"))
        books.add(Book("asd","asd","asd"))


        recyclerView.adapter = adapter
       // setupViews()
        return view

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



    fun setupViews(){
        button = view?.findViewById(R.id.button)
        editTextTitle = view?.findViewById(R.id.title)
        editTextAuthor= view?.findViewById(R.id.author)
        editTextDescription = view?.findViewById(R.id.description)

        button?.setOnClickListener {
            insertBook()
            Toast.makeText(context,"Success", Toast.LENGTH_SHORT).show()
        }
    }

    fun insertBook(){
        val title = editTextTitle?.text?.toString()?:return
        val author = editTextAuthor?.text?.toString()?:return
        val description = editTextDescription?.text?.toString()?:return
        when(title.isEmpty()){
            true -> return
        }
        when(author.isEmpty()){
            true -> return
        }
        when(description.isEmpty()){
            true -> return
        }

        val bookItem = BookItem((0..100).random(),title,author,description)

        bookRepository.insertBook(bookItem){
            Toast.makeText(context,"Success", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(book: Book?) {
        TODO("Not yet implemented")
    }


}