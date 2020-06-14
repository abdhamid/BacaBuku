package com.abhamid.bacabuku.model

import com.google.gson.annotations.SerializedName

data class Resource (
    @SerializedName("resource") val resource: List<Genre>
)
data class Genre(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("count")
    val count: Int
)