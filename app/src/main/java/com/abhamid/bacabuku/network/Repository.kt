package com.abhamid.bacabuku.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abhamid.bacabuku.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository : RepositoryHelper {
    private val api =Injection.provideCabacaApi()
//    private val genreId = SharedPrefs.getGenre()

    override fun getGenre(): LiveData<Either<Resource>> {
        val liveData = MutableLiveData<Either<Resource>>()
        api.getAllGenre().enqueue(object : Callback<Resource>{
            override fun onResponse(call: Call<Resource>?, response: Response<Resource>?) {
                if (response != null && response.isSuccessful) {
                    liveData.value = Either.success(response.body())
                } else {
                    liveData.value = Either.error(ApiError.GENRES, null)
                }
            }

            override fun onFailure(call: Call<Resource>?, t: Throwable?) {
                liveData.value = Either.error(ApiError.GENRES, null)
            }
        })
        return liveData
    }

    override fun getNewBooks(): LiveData<Either<Books>> {
        val liveData = MutableLiveData<Either<Books>>()
        api.getNewBooks().enqueue(object : Callback<Books>{
            override fun onResponse(call: Call<Books>?, response: Response<Books>?) {
                if (response != null && response.isSuccessful) {
                    liveData.value = Either.success(response.body())
                } else {
                    liveData.value = Either.error(ApiError.BOOKS, null)
                }
            }

            override fun onFailure(call: Call<Books>?, t: Throwable?) {
                liveData.value = Either.error(ApiError.BOOKS, null)
            }
        })
        return liveData
    }

//    override fun getBooksByGenre(): LiveData<Either<Books>> {
//        val liveData = MutableLiveData<Either<Books>>()
//        api.getBooksByGenre(1).enqueue(object : Callback<Books>{
//            override fun onResponse(call: Call<Books>?, response: Response<Books>?) {
//                if (response != null && response.isSuccessful) {
//                    liveData.value = Either.success(response.body())
//                } else {
//                    liveData.value = Either.error(ApiError.BOOKS, null)
//                }
//            }
//
//            override fun onFailure(call: Call<Books>?, t: Throwable?) {
//                liveData.value = Either.error(ApiError.BOOKS, null)
//            }
//        })
//        return liveData
//    }
}
interface RepositoryHelper {
    fun getGenre(): LiveData<Either<Resource>>
    fun getNewBooks(): LiveData<Either<Books>>
//    fun getBooksByGenre(): LiveData<Either<Books>>
}