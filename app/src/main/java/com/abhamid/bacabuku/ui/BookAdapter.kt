package com.abhamid.bacabuku.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhamid.bacabuku.R
import com.abhamid.bacabuku.model.Book
import com.abhamid.bacabuku.network.Injection
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_book.view.*

class BookAdapter(private val book: MutableList<Book>) : RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_book, parent, false))
    }

    override fun getItemCount(): Int = book.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(book[position])
    }

    fun updateBooks(book: List<Book>) {
        this.book.clear()
        this.book.addAll(book)
        notifyDataSetChanged()
    }
}

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var book: Book

    fun bind(book: Book) {
        this.book = book
        itemView.book_title.text =book.title
        val picasso = Picasso.get()
            .load(Injection.BASE_IMG + book.coverUrl + Injection.IMG_API_KEY)
            .into(itemView.book_cover)

    }

}