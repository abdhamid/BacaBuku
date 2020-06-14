package com.abhamid.bacabuku.network

import com.abhamid.bacabuku.model.Genre
import com.abhamid.bacabuku.model.Resource
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface CabacaApi {
    @GET("cabaca/_table/genre")
    fun getAllGenre(): Call<Resource>

    @GET("https://cabaca.id:8443/api/v2/book/uptodate?limit=7")
    fun getNewBooks()
}