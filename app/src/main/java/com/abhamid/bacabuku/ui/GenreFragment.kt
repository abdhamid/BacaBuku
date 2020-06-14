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
import androidx.recyclerview.widget.LinearLayoutManager

import com.abhamid.bacabuku.R
import com.abhamid.bacabuku.model.ApiError
import com.abhamid.bacabuku.model.Either
import com.abhamid.bacabuku.model.Genre
import com.abhamid.bacabuku.model.Status
import com.abhamid.bacabuku.viewmodel.GenreViewModel
import kotlinx.android.synthetic.main.fragment_genre.*

/**
 * A simple [Fragment] subclass.
 */
class GenreFragment : Fragment() {
    private lateinit var genreViewModel: GenreViewModel
    private val adapter = GenreAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        genreViewModel = ViewModelProviders.of(this).get(GenreViewModel::class.java)
        return inflater.inflate(R.layout.fragment_genre, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        genre_recyclerview.layoutManager = LinearLayoutManager(context)
        genre_recyclerview.adapter = adapter

        genreViewModel.getAllGenre().observe(this, Observer { either ->
            if (either?.status == Status.SUCCESS && either.data != null) {
                var genres: List<Genre> = either.data.resource
                adapter.updateGenres(genres)
                Log.i("GenreFragment", either.data.toString())

            } else {
                if (either?.error == ApiError.GENRES) {
                    Toast.makeText(context, "Error retrieving genres", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}
