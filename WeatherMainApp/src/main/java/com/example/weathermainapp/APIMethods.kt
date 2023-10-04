package com.example.weathermainapp

import okhttp3.Request

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIMethods {
    @GET("current")

     suspend fun getRes(@Query("access_key")access_key:String,@Query("query")query:String): Response<APIdata>
}