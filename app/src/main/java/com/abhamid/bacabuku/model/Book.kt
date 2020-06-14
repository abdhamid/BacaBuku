package com.abhamid.bacabuku.model

import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("result") val books: List<Book>
)
data class Book(
    val id: Int,
    val title: String,
    @SerializedName("cover_url")
    val coverUrl: String,
    @SerializedName("rate_sum")
    val rating: Float
)