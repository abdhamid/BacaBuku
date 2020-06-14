package com.abhamid.bacabuku.network

import com.abhamid.bacabuku.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    private const val BASE_URL = "https://cabaca.id:8443/api/v2/"
    private const val HEADER_NAME = "x-dreamfactory-api-key"
    private const val HEADER_VALUE = "25e0bf00ab2fa7f03a9fa57035139e47ccb28c20658f6de907b8011347e369fb"
    const val BASE_IMG = "https://cabaca.id:8443/api/v2/files/"
    const val IMG_API_KEY = "&api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948"

    fun provideRepository(): RepositoryHelper = Repository

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient())
            .build()
    }


    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }
    private fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .addInterceptor { chain ->
                val request = chain.request().newBuilder().addHeader(
                    HEADER_NAME,
                    HEADER_VALUE
                ).build()
                chain.proceed(request)
            }
        return httpClient.build()
    }

    fun provideCabacaApi(): CabacaApi {
        return provideRetrofit().create(CabacaApi::class.java)
    }
}