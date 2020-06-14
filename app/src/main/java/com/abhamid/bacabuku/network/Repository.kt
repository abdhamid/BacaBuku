package com.abhamid.bacabuku.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abhamid.bacabuku.model.ApiError
import com.abhamid.bacabuku.model.Either
import com.abhamid.bacabuku.model.Genre
import com.abhamid.bacabuku.model.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Repository : RepositoryHelper {
    private val api =Injection.provideCabacaApi()

    override fun getGenre(): LiveData<Either<Resource>> {
        val liveData = MutableLiveData<Either<Resource>>()
        api.getAllGenre().enqueue(object : Callback<Resource>{
            override fun onResponse(call: Call<Resource>?, response: Response<Resource>?) {
                Log.i("resp", response?.isSuccessful.toString())
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
}
interface RepositoryHelper {
    fun getGenre(): LiveData<Either<Resource>>
}