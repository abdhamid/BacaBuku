package com.abhamid.bacabuku.network

import com.abhamid.bacabuku.model.Books
import com.abhamid.bacabuku.model.Resource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface CabacaApi {
    @GET("cabaca/_table/genre")
    fun getAllGenre(): Call<Resource>

    @GET("book/uptodate?limit=7")
    fun getNewBooks(): Call<Books>

    @GET("book/category?id={genre_id}")
    fun getBooksByGenre(@Path("genre_id") genreId: Int): Call<Books>

//    @GET("book/detail/{book_id}")
//    fun getBookDetail(@Path("book_id") bookId: Int): Call<Unspecified>

//    @GET("writer/detail/{user_id}")
//    fun getWriterDetail(@Path("user_id") userId: Int): Call<Unspecified>
}