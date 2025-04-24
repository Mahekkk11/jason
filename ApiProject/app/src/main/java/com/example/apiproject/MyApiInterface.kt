package com.example.apiproject

import retrofit2.http.GET
import kotlin.collections.List

interface MyApiInterface {

    @GET("marvel/")
    fun getData() : retrofit2.Call<List<MyDataItem>>
}