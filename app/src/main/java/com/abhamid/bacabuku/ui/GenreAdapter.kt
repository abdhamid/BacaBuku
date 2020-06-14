package com.abhamid.bacabuku.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhamid.bacabuku.R
import com.abhamid.bacabuku.model.Genre
import kotlinx.android.synthetic.main.list_genre.view.*

class GenreAdapter(private val genre: MutableList<Genre>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_genre, parent, false))
    }

    override fun getItemCount(): Int = genre.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(genre[position])
    }

    fun updateGenres(genre: List<Genre>) {
        this.genre.clear()
        this.genre.addAll(genre)
        notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var genre: Genre

    fun bind(genre: Genre) {
        this.genre = genre
        itemView.genre_title.text =genre.title
        itemView.genre_count.text = genre.count.toString()
    }

}
