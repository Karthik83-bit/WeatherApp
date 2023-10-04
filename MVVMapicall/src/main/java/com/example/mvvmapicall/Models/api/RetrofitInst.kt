package com.example.mvvmapicall.Models.api

import com.google.gson.Gson
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInst {
    val url="http://api.weatherstack.com/"
    fun getInst(): Retrofit {
        return Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
    }
}
