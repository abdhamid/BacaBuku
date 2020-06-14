package com.abhamid.bacabuku.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.abhamid.bacabuku.R
import com.abhamid.bacabuku.model.ApiError
import com.abhamid.bacabuku.model.Book
import com.abhamid.bacabuku.model.Status
import com.abhamid.bacabuku.viewmodel.BooksViewModel
import kotlinx.android.synthetic.main.fragment_new_book.*

class NewBookFragment : Fragment() {
    private lateinit var newBooksViewModel: BooksViewModel
    private val adapter = BookAdapter(mutableListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newBooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)
        return inflater.inflate(R.layout.fragment_new_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newbooks_recyclerview.layoutManager = GridLayoutManager(activity, 2)
        newbooks_recyclerview.adapter = adapter

        newBooksViewModel.getNewBooks().observe(this, Observer { either ->
            if (either?.status == Status.SUCCESS && either.data != null) {
                var books: List<Book> = either.data.books
                adapter.updateBooks(books)
                Log.i("NewBookFragment", either.data.toString())

            } else {
                if (either?.error == ApiError.BOOKS) {
                    Toast.makeText(context, "Error retrieving books", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
}
