package com.abhamid.bacabuku.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abhamid.bacabuku.model.Genre
import com.abhamid.bacabuku.network.Injection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class GenreViewModel(application: Application):AndroidViewModel(application) {
    private val repository = Injection.provideRepository()
//    private val allGenre =repository.getAllGenre()
    private val allGenre = repository.getGenre()
    fun getAllGenre() = allGenre

}