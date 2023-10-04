package com.example.mvvmapicall.Models.api

import androidx.lifecycle.LiveData
import com.example.mvvmapicall.Models.Data.APIdata
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current")
    suspend fun getData(@Query("access_key")access_key:String,@Query("query")query:String): Response<APIdata>
}