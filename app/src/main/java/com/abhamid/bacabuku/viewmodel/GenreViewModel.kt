package com.abhamid.bacabuku.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.abhamid.bacabuku.network.Injection

class GenreViewModel(application: Application):AndroidViewModel(application) {
    private val repository = Injection.provideRepository()
//    private val allGenre =repository.getAllGenre()
    private val allGenre = repository.getGenre()
    fun getAllGenre() = allGenre

}