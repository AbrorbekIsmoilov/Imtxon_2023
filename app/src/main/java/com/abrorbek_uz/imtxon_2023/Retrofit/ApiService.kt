package com.abrorbek_uz.retrofit2.networking

import com.abrorbek_uz.imtxon_2023.models.APIDataItem

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getMarvels():Call<List<APIDataItem>>
}