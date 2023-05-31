package com.abrorbek_uz.retrofit2.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    fun getRetrofit():Retrofit{

        val loginInterceptor = HttpLoggingInterceptor()
        loginInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val  okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loginInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}