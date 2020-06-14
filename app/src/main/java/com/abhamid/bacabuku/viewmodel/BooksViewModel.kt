package com.abhamid.bacabuku.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.abhamid.bacabuku.network.Injection

class BooksViewModel(application: Application):AndroidViewModel(application) {
    private val repository = Injection.provideRepository()

    private val newBooks = repository.getNewBooks()
    fun getNewBooks() = newBooks

//    private val bookByGenre = repository.getBooksByGenre()
//    fun getBookByGenre() = bookByGenre


}